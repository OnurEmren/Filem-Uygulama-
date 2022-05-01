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
import com.onuremren.tarif.databinding.FragmentTemizlikBinding

import kotlinx.android.synthetic.main.fragment_temizlik.*


class TemizlikFragment : Fragment() {
    private var _binding: FragmentTemizlikBinding?=null
    private val binding get()  = _binding!!
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
        _binding = FragmentTemizlikBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.kaydetButton.setOnClickListener {
            var list = "\n"

            if (checkBox.isChecked){
                list += checkBox.text.toString()
                textView2.text = list
            }
            if (checkbox2.isChecked){
                list += checkbox2.text.toString()
                textView2.text = list
            }
            if (checkbox3.isChecked){
                list += checkbox3.text.toString()
                textView2.text = list
            }
            if (checkbox4.isChecked){
                list += checkbox4.text.toString()
                textView2.text = list
            }
            if (checkbox5.isChecked){
                list += checkbox5.text.toString()
                textView2.text = list
            }
            if (checkbox6.isChecked){
                list += checkbox6.text.toString()
                textView2.text = list
            }
            if (checkbox7.isChecked){
                list += checkbox7.text.toString()
                textView2.text = list
            }
            if (checkbox8.isChecked){
                list += checkbox8.text.toString()
                textView2.text = list
            }
            if (checkbox9.isChecked){
                list += checkbox9.text.toString()
                textView2.text = list
            }
            if (checkbox11.isChecked){
                list += checkbox11.text.toString()
                textView2.text = list
            }
            if (checkbox12.isChecked){
                list += checkbox12.text.toString()
                textView2.text = list
            }
            if (checkbox13.isChecked){
                list += checkbox13.text.toString()
                textView2.text = list
            }
            if (checkbox14.isChecked){
                list += checkbox14.text.toString()
                textView2.text = list
            }
            if (checkbox15.isChecked){
                list += checkbox15.text.toString()
                textView2.text = list
            }

            if (karbonat.isChecked){
                list += karbonat.text.toString()
                textView2.text = list
            }
            if (arapSabunu.isChecked){
                list += arapSabunu.text.toString()
                textView2.text = list
            }
            if (firin.isChecked){
                list += firin.text.toString()
                textView2.text = list
            }
            if (sirkeli.isChecked){
                list += sirkeli.text.toString()
                textView2.text = list
            }
            if (banyo.isChecked){
                list += banyo.text.toString()
                textView2.text = list
            }
            if (limonTuzu.isChecked){
                list += limonTuzu.text.toString()
                textView2.text = list
            }
            if (kirec.isChecked){
                list += kirec.text.toString()
                textView2.text = list
            }
            if (gumus.isChecked){
                list += gumus.text.toString()
                textView2.text = list
            }
            if (beyazSabun.isChecked){
                list += beyazSabun.text.toString()
                textView2.text = list
            }
            if (caydanlik.isChecked){
                list += caydanlik.text.toString()
                textView2.text = list
            }
            if (karbonat.isChecked){
                list += karbonat.text.toString()
                textView2.text = list
            }


        }

        binding.nextButton.setOnClickListener {

            val listOf = textView2.text.toString()
            val action = TemizlikFragmentDirections.actionTemizlikFragmentToListOfShoppingFragment(
                listOf
            )
            Navigation.findNavController(it).navigate(action)
        }

        binding.myOldList.setOnClickListener {
            val action = TemizlikFragmentDirections.actionTemizlikFragmentToShoppingDetailFragment("old",0)
            Navigation.findNavController(it).navigate(action)
        }



}

}