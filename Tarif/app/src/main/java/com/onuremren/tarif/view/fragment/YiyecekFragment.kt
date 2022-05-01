package com.onuremren.tarif.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.Room
import com.onuremren.tarif.database.ShoppingDao
import com.onuremren.tarif.database.ShoppingDatabase
import com.onuremren.tarif.databinding.FragmentYiyecekBinding
import kotlinx.android.synthetic.main.fragment_temizlik.*
import kotlinx.android.synthetic.main.fragment_yiyecek.*


class YiyecekFragment : Fragment() {

    private lateinit var shoppingDao: ShoppingDao
    private lateinit var shoppingDatabase: ShoppingDatabase
    private var _binding: FragmentYiyecekBinding? = null
    private val binding get() = _binding!!

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
        _binding = FragmentYiyecekBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.kaydetButton2.setOnClickListener {

            var list = ""

            if (checkbox.isChecked){
                list += checkbox.text.toString()
                textView5.text = list
            }

            if (checkbox17.isChecked){
                list += checkbox17.text.toString()
                textView5.text = list
            }

            if (checkbox222.isChecked){
                list += checkbox222.text.toString()
                textView5.text = list
            }
            if (checkbox333.isChecked){
                list += checkbox333.text.toString()
                textView5.text = list
            }
            if (checkbox444.isChecked){
                list += checkbox444.text.toString()
                textView5.text = list
            }
            if (checkbox555.isChecked){
                list += checkbox555.text.toString()
                textView5.text = list
            }
            if (checkbox66.isChecked){
                list += checkbox66.text.toString()
                textView5.text = list
            }
            if (checkBox7.isChecked){
                list += checkBox7.text.toString()
                textView5.text = list
            }
            if (checkbox88.isChecked){
                list += checkbox88.text.toString()
                textView5.text = list
            }
            if (checkbox99.isChecked){
                list += checkbox99.text.toString()
                textView5.text = list
            }
            if (checkbox111.isChecked){
                list += checkbox111.text.toString()
                textView5.text = list
            }
            if (checkbox112.isChecked){
                list += checkbox112.text.toString()
                textView5.text = list
            }
            if (checkbox113.isChecked){
                list += checkbox113.text.toString()
                textView5.text = list
            }
            if (checkbox114.isChecked){
                list += checkbox114.text.toString()
                textView5.text = list
            }
            if (checkbox115.isChecked){
                list += checkbox115.text.toString()
                textView5.text = list
            }
            if(checkbox16.isChecked){
                list += checkbox16.text.toString()
                textView5.text = list
            }

            if (checkbox20.isChecked){
                list += checkbox16.text.toString()
                textView5.text = list
            }
            if (checkbox19.isChecked){
                list += checkbox19.text.toString()
                textView5.text = list
            }

            if (checkbox10.isChecked){
                list += checkbox10.text.toString()
                textView5.text = list
            }

            if (checkbox1.isChecked){
                list += checkbox1.text.toString()
                textView5.text = list
            }

            if (checkbox18.isChecked){
                list += checkbox18.text.toString()
                textView5.text = list
            }

            if (labne.isChecked){
                list += labne.text.toString()
                textView5.text = list
            }

            if (kuzu.isChecked){
                list += kuzu.text.toString()
                textView5.text = list
            }

            if (kanat.isChecked){
                list += labne.text.toString()
                textView5.text = list
            }
            if (kiyma.isChecked){
                list += labne.text.toString()
                textView5.text = list
            }

            if (yarimSut.isChecked){
                list += yarimSut.text.toString()
                textView5.text = list
            }
            if (tamSut.isChecked){
                list += tamSut.text.toString()
                textView5.text = list
            }
            if (tavuk.isChecked){
                list += tavuk.text.toString()
                textView5.text = list
            }
            if (yesilZeytin.isChecked){
                list += yesilZeytin.text.toString()
                textView5.text = list
            }
            if (ezine.isChecked){
                list += ezine.text.toString()
                textView5.text = list
            }
            if (orguPeynir.isChecked){
                list += orguPeynir.text.toString()
                textView5.text = list
            }
            if (telPenir.isChecked){
                list += telPenir.text.toString()
                textView5.text = list
            }




        }

        binding.nextButton2.setOnClickListener {

            val listOf = textView5.text.toString()
            val action = YiyecekFragmentDirections.actionYiyecekFragmentToListOfShoppingFragment(listOf)
            Navigation.findNavController(it).navigate(action)
        }

        binding.myOldList2.setOnClickListener {
            val action = YiyecekFragmentDirections.actionYiyecekFragmentToShoppingDetailFragment("old",0)
            Navigation.findNavController(it).navigate(action)
        }

    }

}