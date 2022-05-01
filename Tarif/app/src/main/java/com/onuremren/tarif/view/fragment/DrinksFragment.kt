package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.onuremren.tarif.databinding.FragmentDrinksBinding
import kotlinx.android.synthetic.main.fragment_drinks.*
import kotlinx.android.synthetic.main.fragment_fruits.*

class DrinksFragment : Fragment() {

    private var _binding: FragmentDrinksBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDrinksBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.kaydetButton5.setOnClickListener {
            var list = ""

            if (ayran.isChecked){
                list += ayran.text.toString()
                textView6.text = list
            }

            if (kola.isChecked){
                list += kola.text.toString()
                textView6.text = list
            }
            if (yedigun.isChecked){
                list += yedigun.text.toString()
                textView6.text = list
            }
            if (gazoz.isChecked){
                list += gazoz.text.toString()
                textView6.text = list
            }

            if (salgam.isChecked){
                list += salgam.text.toString()
                textView6.text = list
            }
            if (visneSuyu.isChecked){
                list += visneSuyu.text.toString()
                textView6.text = list
            }

            if (elmaSuyu.isChecked){
                list += elmaSuyu.text.toString()
                textView6.text = list
            }

            if (seftaliSuyu.isChecked){
                list += seftaliSuyu.text.toString()
                textView6.text = list
            }
            if (su.isChecked){
                list += su.text.toString()
                textView6.text = list
            }

            if (limonata.isChecked){
                list += limonata.text.toString()
                textView6.text = list
            }

            if (soda.isChecked){
                list += soda.text.toString()
                textView6.text = list
            }

            if (enerjiIcecegi.isChecked){
                list += enerjiIcecegi.text.toString()
                textView6.text = list
            }
            if (fanta.isChecked){
                list += fanta.text.toString()
                textView6.text = list
            }
        }


        binding.next5.setOnClickListener {
            val listOf = textView6.text.toString()
            val action = DrinksFragmentDirections.actionDrinksFragmentToListOfShoppingFragment(
                listOf
            )
            Navigation.findNavController(it).navigate(action)
        }
        binding.myList5.setOnClickListener {
            val action = DrinksFragmentDirections.actionDrinksFragmentToShoppingDetailFragment("old",0)
            Navigation.findNavController(it).navigate(action)
        }
    }
}