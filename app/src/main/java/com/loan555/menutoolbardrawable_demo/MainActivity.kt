package com.loan555.menutoolbardrawable_demo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.drawer_layout
import kotlinx.android.synthetic.main.activity_navigation_draw.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //--------- tool bar
        setSupportActionBar(tool_bar)
        supportActionBar?.setLogo(R.drawable.ic_baseline_calendar_today_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)

        //----------tab layout
        tab_layout.addTab(tab_layout.newTab().setText("Fragment 1"))
        tab_layout.addTab(tab_layout.newTab().setText("Fragment 2"))
        tab_layout.addTab(tab_layout.newTab().setText("Fragment 3"))
        tab_layout.tabGravity = TabLayout.GRAVITY_FILL
        //----------viewpager
        val adapter = FragmentViewPagerAdapter(this.supportFragmentManager, tab_layout.tabCount)
        view_pager.adapter = adapter
        //-------
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragment1 -> {
                    view_pager.currentItem = 0
                    true
                }
                R.id.fragment2 -> {
                    view_pager.currentItem = 1
                    true
                }
                R.id.fragment3 -> {
                    view_pager.currentItem = 2
                    true
                }
                else -> false
            }
        }
        //-----
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.e("eee", "currenItem = ${view_pager.currentItem} // tab = ${tab!!.position}")
                view_pager!!.currentItem = tab!!.position
                when (view_pager.currentItem) {
                    0 -> {
                        draw_layout_main.menu.findItem(R.id.nav_camera).isChecked = true
                        bottom_navigation.menu.findItem(R.id.fragment1).isChecked = true
                    }
                    1 -> {
                        draw_layout_main.menu.findItem(R.id.nav_gallery).isChecked = true
                        bottom_navigation.menu.findItem(R.id.fragment2).isChecked = true
                    }
                    2 -> {
                        draw_layout_main.menu.findItem(R.id.nav_slideshow).isChecked = true
                        bottom_navigation.menu.findItem(R.id.fragment3).isChecked = true
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        draw_layout_main.setNavigationItemSelectedListener { item ->
            item.isChecked = true
            drawer_layout.closeDrawers()
            Toast.makeText(this, "Ban vua nhan ${item.title}", Toast.LENGTH_SHORT).show()
            when (item.itemId) {
                R.id.nav_camera -> view_pager.currentItem = 0
                R.id.nav_gallery -> view_pager.currentItem = 1
                else -> view_pager.currentItem = 2
            }
            true
        }
    }

    override fun onBackPressed() {
        // back ve trang fragment truoc. neu ko co ham nay thi no se thoat ung dung luon
        if (view_pager.currentItem == 0) {
            super.onBackPressed()
        } else view_pager.currentItem--
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //bat su kien
        return when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            R.id.red, R.id.blue -> {
                item.isChecked = !item.isChecked
                true
            }

            R.id.search -> {
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.folder -> {
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.create_new -> {
                Toast.makeText(this, item.title.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

