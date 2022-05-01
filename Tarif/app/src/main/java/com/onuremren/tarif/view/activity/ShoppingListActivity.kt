package com.onuremren.tarif.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.navigation.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.onuremren.tarif.NavListDirections
import com.onuremren.tarif.R
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShoppingListActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        setSupportActionBar(toolbar)

        setupActionBarWithNavController(navController)
       // bottom_nav.setupWithNavController(navController)



/*
        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TemizlikFragment(), "Temizlik Ürünleri")
        adapter.addFragment(YiyecekFragment(),"Yiyecek")
        adapter.addFragment(DrinksFragment(),"İçecek")
        adapter.addFragment(ElektronikFragment(),"Elektronik")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

 */


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if (item.itemId == R.id.yiyecek) {
            val action = NavListDirections.actionGlobalYiyecekFragment()
            navController.navigate(action)

        }

        if (item.itemId == R.id.vegatables){
            val actionVegatables = NavListDirections.actionGlobalVegatablesFragment()
            navController.navigate(actionVegatables)

        }

        if (item.itemId == R.id.fruits){
            val actionFruits = NavListDirections.actionGlobalFruitsFragment()
            navController.navigate(actionFruits)
        }

        if (item.itemId == R.id.drinks){
         val actionDrinks = NavListDirections.actionGlobalDrinksFragment()
         navController.navigate(actionDrinks)
        }

        if (item.itemId == R.id.elektronik){
            val action = NavListDirections.actionGlobalTemizlikFragment()
            navController.navigate(action)
        }

        if (item.itemId == R.id.main){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}