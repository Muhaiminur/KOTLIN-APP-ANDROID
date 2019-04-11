package com.muhaiminur.gkotlin

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_home__page.*
import kotlinx.android.synthetic.main.app_bar_home__page.*
import kotlinx.android.synthetic.main.content_home__page.*
import com.synnapps.carouselview.ImageListener
import android.widget.Toast
import com.synnapps.carouselview.ImageClickListener


class HomePage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__page)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //banner work
        val image_list = ArrayList<Int>()
        image_list.add(R.drawable.logo)
        image_list.add(R.drawable.logo)
        image_list.add(R.drawable.logo)
        image_list.add(R.drawable.logo)
        carouselView.pageCount = image_list.size
        val imageListener = object : ImageListener {
            override fun setImageForPosition(position: Int, imageView: ImageView) {
                imageView.setImageResource(image_list[position])
            }
        }
        carouselView.setImageListener(imageListener)
        carouselView.setImageClickListener(ImageClickListener { position ->
            Toast.makeText(
                this@HomePage,
                "Clicked item: $position",
                Toast.LENGTH_SHORT
            ).show()
        })

        //viewpager work
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.recycler_view_string)))
        tabLayout!!.addTab(tabLayout!!.newTab().setText(getString(R.string.grid_view_string)))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home__page, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) :
        FragmentPagerAdapter(fm) {

        // this is for fragment tabs
        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> {
                    //  val homeFragment: HomeFragment = HomeFragment()
                    return Recycler_Page()
                }
                1 -> {
                    return GridPage()
                }
                else -> return null
            }
        }

        // this counts total number of tabs
        override fun getCount(): Int {
            return totalTabs
        }
    }
}
