package com.onuremren.tarif.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onuremren.tarif.R

import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    alisverisYap.setOnClickListener {
        val intent = Intent(this, ShoppingListActivity::class.java)
        startActivity(intent)
    }

        tarifHazirla.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        menuHazirla.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

    }
}