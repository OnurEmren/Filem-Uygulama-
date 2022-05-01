package com.onuremren.tarif.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.onuremren.tarif.databinding.FragmentFruitsBinding
import kotlinx.android.synthetic.main.fragment_fruits.*
import kotlinx.android.synthetic.main.fragment_vegatables.*


class FruitsFragment : Fragment() {

    private var _binding : FragmentFruitsBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFruitsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listeOlustur4.setOnClickListener {
            var list = ""
            if (elma.isChecked){
                list += elma.text.toString()
                textView4.text = list
            }
            if (armut.isChecked){
                list += armut.text.toString()
                textView4.text = list
            }
            if (portakal.isChecked){
                list += portakal.text.toString()
                textView4.text = list
            }
            if (seftali.isChecked){
                list += seftali.text.toString()
                textView4.text = list
            }
            if (greyfurt.isChecked){
                list += greyfurt.text.toString()
                textView4.text = list
            }
            if (ayva.isChecked){
                list += ayva.text.toString()
                textView4.text = list
            }
            if (muz.isChecked){
                list += muz.text.toString()
                textView4.text = list
            }

            if (kivi.isChecked){
                list += kivi.text.toString()
                textView4.text = list
            }

            if (ananas.isChecked){
                list += ananas.text.toString()
                textView4.text = list
            }

            if (cilek.isChecked){
                list += cilek.text.toString()
                textView4.text = list
            }
            if (avokado.isChecked){
                list += avokado.text.toString()
                textView4.text = list
            }

            if (incir.isChecked){
                list += incir.text.toString()
                textView4.text = list
            }
            if (erik.isChecked){
                list += erik.text.toString()
                textView4.text = list
            }
            if (kiraz.isChecked){
                list += kiraz.text.toString()
                textView4.text = list
            }

            if (limon.isChecked){
                list += limon.text.toString()
                textView4.text = list
            }
            if (uzum.isChecked){
                list += uzum.text.toString()
                textView4.text = list
            }
            if (hurma.isChecked){
                list += hurma.text.toString()
                textView4.text = list
            }
            if (mango.isChecked){
                list += mango.text.toString()
                textView4.text = list
            }
            if (dut.isChecked){
                list += dut.text.toString()
                textView4.text = list
            }
            if (alic.isChecked){
                list += alic.text.toString()
                textView4.text = list
            }
            if (kavun.isChecked){
                list += kavun.text.toString()
                textView4.text = list
            }
            if (karpuz.isChecked){
                list += karpuz.text.toString()
                textView4.text = list
            }

        }


        binding.nextButton4.setOnClickListener {
            val listOf = textView4.text.toString()
            val action = FruitsFragmentDirections.actionFruitsFragmentToListOfShoppingFragment(
                listOf
            )
            Navigation.findNavController(it).navigate(action)
        }
        binding.myList3.setOnClickListener {
            val action = FruitsFragmentDirections.actionFruitsFragmentToShoppingDetailFragment("old",0)
            Navigation.findNavController(it).navigate(action)
        }

    }
}
