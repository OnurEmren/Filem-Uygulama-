package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.onuremren.tarif.adapter.ShoppingListAdapter
import com.onuremren.tarif.database.ShoppingDao
import com.onuremren.tarif.database.ShoppingDatabase
import com.onuremren.tarif.databinding.FragmentShoppingDetailBinding
import com.onuremren.tarif.model.ShoppingList
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class ShoppingDetailFragment : Fragment() {
    private var _binding: FragmentShoppingDetailBinding?=null
    private val binding get()  = _binding!!
    private lateinit var shoppingDao: ShoppingDao
    private lateinit var shoppingDatabase: ShoppingDatabase
    private val mDisposable = CompositeDisposable()
    var listFromMain: ShoppingList? = null
    private lateinit var shoppingAdapter: ShoppingListAdapter

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
        _binding = FragmentShoppingDetailBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFromSql()

    }

    private fun getFromSql() {
        mDisposable.add(shoppingDao.getListWithNameAndId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(shoppingList: List<ShoppingList>){
        binding.recyclerView3.layoutManager = LinearLayoutManager(requireContext())
        shoppingAdapter = ShoppingListAdapter(shoppingList)
        binding.recyclerView3.adapter = shoppingAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}