package com.onuremren.tarif.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.onuremren.tarif.NavMenuDirections
import com.onuremren.tarif.R
import com.onuremren.tarif.view.fragment.AnaYemekFragmentDirections
import com.onuremren.tarif.view.fragment.MenuListFragmentDirections
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_shopping_list.*

class MainActivity3 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.anaSayfa){
            val action = Intent(this,MainActivity2::class.java)
            startActivity(action)
        }
        if (item.itemId == R.id.anaYemekler){
            val action = MenuListFragmentDirections.actionGlobalAnaYemekFragment()
            Navigation.findNavController(this,R.id.fragmentContainerView2).navigate(action)
        }
        if (item.itemId == R.id.yardimci){
            val action = MenuListFragmentDirections.actionMenuListFragmentToYardimciYemekFragment()
            Navigation.findNavController(this,R.id.fragmentContainerView2).navigate(action)
        }
        if (item.itemId == R.id.tatli){
            val action = MenuListFragmentDirections.actionMenuListFragmentToTatliFragment()
            Navigation.findNavController(this,R.id.fragmentContainerView2).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }

}