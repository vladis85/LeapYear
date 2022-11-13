package com.example.bissextile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bissextile.databinding.ActivityMainBinding
import java.time.Year

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
            val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = YearAdapter(generateYears())
        recyclerView.scrollToPosition((Year.now().value.toInt())/4-2)


        
            val ed = (binding.edYear)
            ed.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->

                if (binding.edYear.text.length in 2..5 &&
                    keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {

                    //Perform Code
                    val year: String = binding.edYear.text.toString()
                    val year1 = year.toInt()


                    val no = (binding.tvNo)
                    val yes = (binding.tvYes)
                    val field = (binding.tvEmpty)

                    if (year1 % 100 == 0 && year1 % 400 == 0 || year1 % 4 == 0) {
                        field.visibility = View.INVISIBLE
                        no.visibility = View.INVISIBLE
                        yes.visibility = View.VISIBLE
                        recyclerView.scrollToPosition(year1 / 4 - 2)
                    }
                    else {
                        field.visibility = View.INVISIBLE
                        yes.visibility = View.INVISIBLE
                        no.visibility = View.VISIBLE
                    }
                    return@OnKeyListener true
                }
                false

            })
        }

    private fun generateYears(): List<Int> {
        val years = mutableListOf<Int>()
        for (i in 1..10000) {
            if (i % 100 == 0 && i % 400 == 0 || i % 4 == 0) years.add(i)
        }
        return years

    }

}

