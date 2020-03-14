package com.lucasprojects.sorteiointegrador.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.constants.Constants
import com.lucasprojects.sorteiointegrador.entities.Team
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /** Definindo a cor dos itens da NavigationView como nulas */
        navigationView.itemIconTintList = null
        /** Definindo o NavController */
        val navController = Navigation.findNavController(this, R.id.navHostFragment)
        /** Configurando a Navegação do App */
        NavigationUI.setupWithNavController(navigationView, navController)
        /** Execução com a navegação baseada no destino */
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.navOffline -> textMode.text = getString(R.string.off)
                R.id.navOnline -> textMode.text = getString(R.string.on)
            }
        }
        /** Criação dos equipes */
        createTeamsArrays()
    }

    private fun createTeamsArrays() {
        val teams = ArrayList<Team>()
        teams.add(Team(Constants.TEAMS_NAMES.TEAMONE))
        teams.add(Team(Constants.TEAMS_NAMES.TEAMTWO))
        teams.add(Team(Constants.TEAMS_NAMES.TEAMTHREE))
        teams.add(Team(Constants.TEAMS_NAMES.TEAMFOUR))
        teams.add(Team(Constants.TEAMS_NAMES.TEAMFIVE))
    }
}
