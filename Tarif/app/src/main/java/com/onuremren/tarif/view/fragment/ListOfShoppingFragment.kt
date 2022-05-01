package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import com.onuremren.tarif.adapter.ShoppingListAdapter
import com.onuremren.tarif.database.ShoppingDao
import com.onuremren.tarif.database.ShoppingDatabase
import com.onuremren.tarif.databinding.FragmentListOfShoppingBinding
import com.onuremren.tarif.model.ShoppingList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_list_of_shopping.*


class ListOfShoppingFragment : Fragment() {

    private var _binding: FragmentListOfShoppingBinding?=null
    private val binding get()  = _binding!!
    private lateinit var shoppingDao: ShoppingDao
    private lateinit var shoppingDatabase: ShoppingDatabase
    private val mDisposable = CompositeDisposable()
    var listFromMain: ShoppingList? = null
    private lateinit var shoppingAdapter: ShoppingListAdapter

    private val args: ListOfShoppingFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoppingDatabase = Room.databaseBuilder(requireContext(),ShoppingDatabase::class.java,"ShoppingList").build()
        shoppingDao = shoppingDatabase.shoppingDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListOfShoppingBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listeKaydet.setOnClickListener { save(view) }
        binding.ListeSil.setOnClickListener { deleteList(view) }

        arguments?.let {
            val info = ListOfShoppingFragmentArgs.fromBundle(it).info

            if (info == "old"){
                binding.listeKaydet.visibility = View.GONE
                binding.ListeSil.visibility = View.VISIBLE
                val selectedId = ListOfShoppingFragmentArgs.fromBundle(it).id
                mDisposable.add(shoppingDao.getListById(selectedId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponseWithOldList))

            } else{
                binding.ListeSil.visibility = View.GONE
                binding.listeKaydet.visibility = View.VISIBLE


            }
        }
       listeTv.text = args.info



    }
    private fun handleResponseWithOldList(shoppingList: ShoppingList){
        listFromMain = shoppingList
        binding.listeTv.setText(shoppingList.shoppingList)

    }

    private fun deleteList(view: View) {

        listFromMain?.let {
            mDisposable.add(shoppingDao.delete(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse))
        }
    }

    private fun handleResponse(){
        val action = ListOfShoppingFragmentDirections.actionListOfShoppingFragmentToShoppingDetailFragment("",0)
        Navigation.findNavController(requireView()).navigate(action)
    }




    private fun save(view: View) {

        val listTitle = binding.listeTv.text.toString()

        val mListe = ShoppingList(listTitle)
        mDisposable.add(shoppingDao.insert(mListe)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

}