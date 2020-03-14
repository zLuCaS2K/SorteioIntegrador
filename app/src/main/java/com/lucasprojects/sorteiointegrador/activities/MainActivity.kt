package com.lucasprojects.sorteiointegrador.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.lucasprojects.sorteiointegrador.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.itemIconTintList = null
        imageMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(navigationView, navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navOffline -> {
                    val textMode = findViewById<TextView>(R.id.textMode)
                    textMode.text = getString(R.string.off)
                    textMode.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
                }
                R.id.navOnline -> {
                    val textMode = findViewById<TextView>(R.id.textMode)
                    textMode.text = getString(R.string.on)
                    textMode.setTextColor(ContextCompat.getColor(this, R.color.colorGreen))
                }
            }
        }
    }
}
