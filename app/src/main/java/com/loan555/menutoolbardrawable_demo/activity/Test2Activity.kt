package com.loan555.menutoolbardrawable_demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.loan555.menutoolbardrawable_demo.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tool_bar
import kotlinx.android.synthetic.main.activity_test2.*

class Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        //--------- tool bar
        setSupportActionBar(tool_bar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //---------- su kien
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_fragment2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //bat su kien
        return when (item.itemId) {
            R.id.red, R.id.blue -> {
                item.isChecked = !item.isChecked
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}