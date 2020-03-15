package com.lucasprojects.sorteiointegrador.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.adapter.Adapter
import com.lucasprojects.sorteiointegrador.constants.Constants
import com.lucasprojects.sorteiointegrador.entities.Person
import com.lucasprojects.sorteiointegrador.entities.Team
import com.lucasprojects.sorteiointegrador.listenner.OnClickListenner
import kotlin.random.Random

class HomeFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mOnClickListenner: OnClickListenner

    private val arrayOne = arrayOf(
        Person(1, 47834248, "sara"),
        Person(2, 47834260, "alicia"),
        Person(3, 343190904, "lara")
    )
    private val arrayTwo = arrayOf(
        Person(4, 47834734, "alan"),
        Person(5, 14566722, "danylo"),
        Person(6, 29796449, "victor"),
        Person(7, 54503973, "felipe"),
        Person(8, 47700368, "caio")
    )
    private val arrayThree =
        arrayOf(
            Person(9, 47834365, "matheus"),
            Person(10, 47751527, "De Cellis"),
            Person(11, 47834230, "suennaby"),
            Person(12, 42949476, "jorge"),
            Person(13, 47834341, "augusto"),
            Person(14, 47527659, "thiago")
        )
    private val arrayFour =
        arrayOf(
            Person(15, 47834406, "gabriel"),
            Person(16, 52612637, "lucas"),
            Person(17, 47834318, "eduardo"),
            Person(18, 47723471, "fabricio"),
            Person(19, 47834216, "bruno")
        )
    private val arrayFive = arrayOf(
        Person(20, 47834261, "icaro"),
        Person(21, 47747549, "vinicius"),
        Person(22, 47834187, "tayrone"),
        Person(23, 47834406, "carlos"),
        Person(24, 47778635, "hiago")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        createInteractionTeams()
        mRecyclerView = view.findViewById(R.id.recyclerView)
        createTeamsArrays()
        return view
    }

    private fun createTeamsArrays() {
        val teams = ArrayList<Team>()
        teams.add(Team(Constants.TEAMS_ID.TEAMONE, Constants.TEAMS_NAMES.TEAMONE))
        teams.add(Team(Constants.TEAMS_ID.TEAMTWO, Constants.TEAMS_NAMES.TEAMTWO))
        teams.add(Team(Constants.TEAMS_ID.TEAMTHREE, Constants.TEAMS_NAMES.TEAMTHREE))
        teams.add(Team(Constants.TEAMS_ID.TEAMFOUR, Constants.TEAMS_NAMES.TEAMFOUR))
        teams.add(Team(Constants.TEAMS_ID.TEAMFIVE, Constants.TEAMS_NAMES.TEAMFIVE))
        val teamsAdapter = Adapter(teams, mOnClickListenner)
        mRecyclerView.adapter = teamsAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(view?.context)
    }

    private fun createInteractionTeams() {
        mOnClickListenner = object : OnClickListenner {
            override fun onClickItem(idTeam: Int) {
                val inflater = layoutInflater
                val inflaterView = inflater.inflate(R.layout.custom_click_team, null)
                val btnRaffle = inflaterView.findViewById<Button>(R.id.btnRaffle)
                val btnExit = inflaterView.findViewById<Button>(R.id.btnExit)
                val imageMember = inflaterView.findViewById<ImageView>(R.id.imageMember)
                val textNameTeam = inflaterView.findViewById<TextView>(R.id.textNameTeam)
                val textNameMember = inflaterView.findViewById<TextView>(R.id.textNameMember)
                when (idTeam) {
                    Constants.TEAMS_ID.TEAMONE -> textNameTeam.text = Constants.TEAMS_NAMES.TEAMONE
                    Constants.TEAMS_ID.TEAMTWO -> textNameTeam.text = Constants.TEAMS_NAMES.TEAMTWO
                    Constants.TEAMS_ID.TEAMTHREE -> textNameTeam.text = Constants.TEAMS_NAMES.TEAMTHREE
                    Constants.TEAMS_ID.TEAMFOUR -> textNameTeam.text = Constants.TEAMS_NAMES.TEAMFOUR
                    Constants.TEAMS_ID.TEAMFIVE -> textNameTeam.text = Constants.TEAMS_NAMES.TEAMFIVE
                }
                val alertDialog = AlertDialog.Builder(view?.context)
                alertDialog.setView(inflaterView)
                alertDialog.setCancelable(true)
                val dialogRaffle = alertDialog.create()
                dialogRaffle.show()
                var person: Person? = null
                btnRaffle.setOnClickListener {
                    when (idTeam) {
                        1 -> person = arrayOne[Random.nextInt(arrayOne.size)]
                        2 -> person = arrayTwo[Random.nextInt(arrayTwo.size)]
                        3 -> person = arrayThree[Random.nextInt(arrayThree.size)]
                        4 -> person = arrayFour[Random.nextInt(arrayFour.size)]
                        5 -> person = arrayFive[Random.nextInt(arrayFive.size)]
                    }

                    when (person?.name) {
                        "alan" -> imageMember.setImageResource(R.drawable.alan)
                        "alicia" -> imageMember.setImageResource(R.drawable.alicia)
                        "augusto" -> imageMember.setImageResource(R.drawable.augusto)
                        "bruno" -> imageMember.setImageResource(R.drawable.bruno)
                        "caio" -> imageMember.setImageResource(R.drawable.caio)
                        "danylo" -> imageMember.setImageResource(R.drawable.danylo)
                        "De Cellis" -> imageMember.setImageResource(R.drawable.decellis)
                        "eduardo" -> imageMember.setImageResource(R.drawable.eduardo)
                        "fabricio" -> imageMember.setImageResource(R.drawable.fabricio)
                        "felipe" -> imageMember.setImageResource(R.drawable.felipe)
                        "gabriel" -> imageMember.setImageResource(R.drawable.gabriel)
                        "hiago" -> imageMember.setImageResource(R.drawable.hiago)
                        "icaro" -> imageMember.setImageResource(R.drawable.icaro)
                        "jorge" -> imageMember.setImageResource(R.drawable.jorge)
                        "lara" -> imageMember.setImageResource(R.drawable.lara)
                        "lucas" -> imageMember.setImageResource(R.drawable.lucas)
                        "matheus" -> imageMember.setImageResource(R.drawable.matheus)
                        "sara" -> imageMember.setImageResource(R.drawable.sara)
                        "suennaby" -> imageMember.setImageResource(R.drawable.suennaby)
                        "thayrone" -> imageMember.setImageResource(R.drawable.thayrone)
                        "thiago" -> imageMember.setImageResource(R.drawable.thiago)
                        "victor" -> imageMember.setImageResource(R.drawable.victor)
                        "vinicius" -> imageMember.setImageResource(R.drawable.vinicius)
                    }

                    textNameMember.text = person?.name?.toUpperCase()
                    Toast.makeText(view?.context, "${person?.name?.toUpperCase()}", Toast.LENGTH_SHORT).show()
                }
                btnExit.setOnClickListener {
                    dialogRaffle.dismiss()
                }
            }
        }
    }
}

