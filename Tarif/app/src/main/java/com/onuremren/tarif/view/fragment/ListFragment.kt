package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.onuremren.tarif.adapter.EatAdapter
import com.onuremren.tarif.database.EatDao
import com.onuremren.tarif.database.EatDatabase
import com.onuremren.tarif.databinding.FragmentListBinding
import com.onuremren.tarif.model.Eat
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ListFragment : Fragment() {

    private var _binding : FragmentListBinding?= null
    private val binding get() = _binding!!
    private lateinit var eatAdapter : EatAdapter
    private val mDisposable = CompositeDisposable()
    private lateinit var eatDao : EatDao
    private lateinit var eatDatabase : EatDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        eatDatabase = Room.databaseBuilder(requireContext(),EatDatabase::class.java,"Recipes").build()
        eatDao = eatDatabase.eatDao()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getFromSql()

    }

    private fun getFromSql() {
        mDisposable.add(eatDao.getEatWithNameAndId()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))
    }

    private fun handleResponse(eatList: List<Eat>){
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        eatAdapter = EatAdapter(eatList)
        binding.recyclerView.adapter = eatAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}