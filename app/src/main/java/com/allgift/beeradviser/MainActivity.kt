package com.allgift.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findBeerBtn = findViewById<Button>(R.id.btn_find_beer)
        val brands = findViewById<TextView>(R.id.tv_brands)
        val beerColor = findViewById<Spinner>(R.id.sp_beer_color)

        findBeerBtn.setOnClickListener {
            val color = beerColor.selectedItem.toString()
            val beerList = getBeers(color)
            val beers = beerList.reduce{str, item -> str + '\n' + item}
//            Toast.makeText(this, "Btn Clicked", Toast.LENGTH_LONG).show()
            brands.text = beers
        }
    }

    private fun getBeers(color:String): List<String> {
        return when(color) {
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Rose Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}