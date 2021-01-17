package com.example.haushaltsbuch.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.haushaltsbuch.R
import com.example.haushaltsbuch.ui.addeditexpense.AddEditExpense
import com.example.haushaltsbuch.ui.charts.PieChart
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var drawer: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById<DrawerLayout>(R.id.drawer)
        val sidenav: NavigationView = findViewById(R.id.sidenav)
        sidenav.setNavigationItemSelectedListener(this)
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer?.addDrawerListener(toggle)
        toggle.syncState()

        val button: Button = findViewById(R.id.buttonAusgaben)
        button.setOnClickListener{
            startActivity(Intent(this, AddEditExpense::class.java))
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // add the routing for remaining elements
            R.id.nav_statistics -> {startActivity(Intent(this, PieChart::class.java))}
        }
        return true
    }
    override fun onBackPressed() {
        if (drawer?.isDrawerOpen(GravityCompat.START) == true){
            drawer?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}