package com.mobile.azrinurvani.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mobile.azrinurvani.list.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFruit = arrayOf(
            "Apple", "Banana","Avocado","Durian","Mangosteen","Rose Apple"
        )

        val listAdapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,listFruit)

        binding.listView.adapter = listAdapter

        binding.listView.setOnItemClickListener {parent,view,position,id->
            Toast.makeText(applicationContext,"Anda memilih buah : ${listFruit[position]}",Toast.LENGTH_LONG).show()
        }
    }
}