package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.room.Room
import com.onuremren.tarif.database.ShoppingDao
import com.onuremren.tarif.database.ShoppingDatabase
import com.onuremren.tarif.databinding.FragmentVegatablesBinding
import kotlinx.android.synthetic.main.fragment_temizlik.*
import kotlinx.android.synthetic.main.fragment_vegatables.*


class VegatablesFragment : Fragment() {

    private var _binding : FragmentVegatablesBinding?= null
    private val binding get() = _binding!!
    private lateinit var shoppingDao: ShoppingDao
    private lateinit var shoppingDatabase: ShoppingDatabase

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
        _binding = FragmentVegatablesBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listeOlustur.setOnClickListener {
            var list = "\n"

            if (domates.isChecked){
                list += domates.text.toString()
                textView3.text = list
            }

            if (biber.isChecked){
                list += biber.text.toString()
                textView3.text = list
            }

            if (patates.isChecked){
                list += patates.text.toString()
                textView3.text = list
            }

            if (kabak.isChecked){
                list += kabak.text.toString()
                textView3.text = list
            }

            if (karalahana.isChecked){
                list += karalahana.text.toString()
                textView3.text = list
            }

            if (sogan.isChecked){
                list += sogan.text.toString()
                textView3.text = list
            }

            if (enginar.isChecked){
                list += enginar.text.toString()
                textView3.text = list
            }

            if (kereviz.isChecked){
                list += kereviz.text.toString()
                textView3.text = list
            }

            if (ispanak.isChecked){
                list += ispanak.text.toString()
                textView3.text = list
            }

            if (patlican.isChecked){
                list += patlican.text.toString()
                textView3.text = list
            }

            if (turp.isChecked){
                list += turp.text.toString()
                textView3.text = list
            }
            if (roka.isChecked){
                list += roka.text.toString()
                textView3.text = list
            }

            if (havuc.isChecked){
                list += havuc.text.toString()
                textView3.text = list
            }

            if (brokoli.isChecked){
                list += brokoli.text.toString()
                textView3.text = list
            }

            if (semizOtu.isChecked){
                list += semizOtu.text.toString()
                textView3.text = list
            }
            if (pirasa.isChecked){
                list += pirasa.text.toString()
                textView3.text = list
            }
            if (gobek.isChecked){
                list += gobek.text.toString()
                textView3.text = list
            }
            if (karnabahar.isChecked){
                list += karnabahar.text.toString()
                textView3.text = list
            }
            if (dolmabiber.isChecked){
                list += dolmabiber.text.toString()
                textView3.text = list
            }

            if (yesilSogan.isChecked){
                list += yesilSogan.text.toString()
                textView3.text = list
            }

            if (kirmizi.isChecked){
                list += kirmizi.text.toString()
                textView3.text = list
            }
        }

        binding.nextButton3.setOnClickListener {
            val listOf = textView3.text.toString()
            val action = VegatablesFragmentDirections.actionVegatablesFragmentToListOfShoppingFragment(
                listOf
            )
            Navigation.findNavController(it).navigate(action)
        }
        binding.myList.setOnClickListener {
            val action = VegatablesFragmentDirections.actionVegatablesFragmentToShoppingDetailFragment("old",0)
            Navigation.findNavController(it).navigate(action)
        }
    }


}