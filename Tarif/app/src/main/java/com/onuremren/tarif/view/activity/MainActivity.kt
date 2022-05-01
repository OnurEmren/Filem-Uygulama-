package com.onuremren.tarif.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.onuremren.tarif.R
import com.onuremren.tarif.view.fragment.ListFragmentDirections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate((R.menu.menu_add_recipes),menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragmentContainerView)
        return navController.navigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.addRecipes){
            val action = ListFragmentDirections.actionListFragmentToMyRecipeFragment("new",0)
            Navigation.findNavController(this,R.id.fragmentContainerView).navigate(action)

        }

        return super.onOptionsItemSelected(item)
    }
}