package com.lucasprojects.sorteiointegrador.activities

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.constants.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView.itemIconTintList = null
        imageMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        imageInfo.setOnClickListener {
            showInfoDialog()
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

    private fun showInfoDialog() {
        val inflater = layoutInflater
        val inflaterView = inflater.inflate(R.layout.custom_dialog_about, null)
        val btnViewCode = inflaterView.findViewById<Button>(R.id.btnViewCode)
        val alertDialogAbout = AlertDialog.Builder(this)
        alertDialogAbout.setView(inflaterView)
        alertDialogAbout.setCancelable(true)
        val dialogAbout = alertDialogAbout.create()
        if (dialogAbout.window != null) {
            dialogAbout.window?.setBackgroundDrawable(ColorDrawable(0))
        }
        dialogAbout.show()
        btnViewCode.setOnClickListener {
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(Constants.LINKS.LINK_REPOSITORY))
            startActivity(webIntent)
        }
    }
}
