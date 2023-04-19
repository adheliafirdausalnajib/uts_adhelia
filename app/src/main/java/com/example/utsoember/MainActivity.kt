package com.example.utsoember

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

import java.util.ArrayList

import com.example.utsoember.ItemAdapter.Companion.SPAN_COUNT_ONE
import com.example.utsoember.ItemAdapter.Companion.SPAN_COUNT_THREE

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initItemsData()

        gridLayoutManager = GridLayoutManager(this, SPAN_COUNT_ONE)
        itemAdapter = ItemAdapter(items, gridLayoutManager)
        recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = gridLayoutManager
    }

    private fun initItemsData() {
        items = ArrayList<Item>(9).apply {
            add(Item(R.drawable.adelle, "Adelle", "21074938", 22))
            add(Item(R.drawable.arianagrande, "Ariana Grande", "2546785", 54))
            add(Item(R.drawable.beyonce, "Beyonce", "3285489", 20))
            add(Item(R.drawable.billieelish, "Billie Elish", "2104411994", 67))
            add(Item(R.drawable.brunomars, "Bruno Mars", "21965744", 20))
            add(Item(R.drawable.camiliacabelo, "Camilia Cabelo", "32439054", 67))
            add(Item(R.drawable.charlieputh, "Charlie Puth", "21443596", 33))
            add(Item(R.drawable.demilovato, "Demi Lovato", "2145566", 54))
            add(Item(R.drawable.edsheeran, "Edsheran", "2135854", 20))
            add(Item(R.drawable.jeckieevancho, "Jeckie Evancho", "2546785", 54))
            add(Item(R.drawable.jenniferlopez, "Jennifer Lopez", "3285489", 20))
            add(Item(R.drawable.johnnyorlando, "Johnny Orlando", "2104411994", 67))
            add(Item(R.drawable.justinbieber, "Justin Bieber", "21965744", 20))
            add(Item(R.drawable.kattyperry, "Katty Perry", "32439054", 67))
            add(Item(R.drawable.rihanna, "Rihanna", "21443596", 33))
            add(Item(R.drawable.samsmith, "Sam Smith", "2546785", 54))
            add(Item(R.drawable.selenagomez, "Selenagomez", "3285489", 20))
            add(Item(R.drawable.shakira, "Shakira", "2104411994", 67))
            add(Item(R.drawable.shawnmendes, "Shawn Mendes", "21965744", 20))
            add(Item(R.drawable.taylorswift, "Taylor Swift", "32439054", 67))
            add(Item(R.drawable.zaynmalik, "Zayn Malik", "21443596", 33))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_ml, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_switch_layout) {
            switchLayout()
            switchIcon(item)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun switchLayout() {
        if (gridLayoutManager.spanCount == SPAN_COUNT_ONE) {
            gridLayoutManager.spanCount = SPAN_COUNT_THREE
        } else {
            gridLayoutManager.spanCount = SPAN_COUNT_ONE
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.itemCount)
    }

    private fun switchIcon(item: MenuItem) {
        if (gridLayoutManager.spanCount == SPAN_COUNT_THREE) {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_3))
        } else {
            item.setIcon(resources.getDrawable(R.drawable.ic_span_1))
        }
    }
}