package com.mobile.azrinurvani.recyclerviewviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azrinurvani.recyclerviewviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var fruitRecyclerAdapter : FruitRecyclerAdapter
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val fruitName = arrayListOf<String>(
            "Apple",
            "Avocado",
            "Cherry",
            "Durian",
            "Rose Apple",
            "Mangosteen",
            "Strawberry"
        )

        val fruitImage = arrayListOf<Int>(
            R.drawable.apel,
            R.drawable.alpukat,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
        )

        fruitRecyclerAdapter = FruitRecyclerAdapter(fruitName,fruitImage)

        activityMainBinding.rvFruit.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = fruitRecyclerAdapter
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fruit,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Action click menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.list_mode){
            activityMainBinding.rvFruit.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = fruitRecyclerAdapter
            }
        }else if (item.itemId ==R.id.grid_mode){
            activityMainBinding.rvFruit.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@MainActivity,2)
                adapter = fruitRecyclerAdapter
            }
        }

        return super.onOptionsItemSelected(item)
    }
}