package com.lucasprojects.sorteiointegrador.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        Person(1, 47834248, "Sara"),
        Person(2, 47834260, "Alicia"),
        Person(3, 343190904, "Lara")
    )
    private val arrayTwo = arrayOf(
        Person(4, 47834734, "Alan"),
        Person(5, 14566722, "Danylo"),
        Person(6, 29796449, "Victor"),
        Person(7, 54503973, "Felipe"),
        Person(8, 47700368, "Caio")
    )
    private val arrayThree =
        arrayOf(
            Person(9, 47834365, "Matheus"),
            Person(10, 47751527, "De Cellis"),
            Person(11, 47834230, "Suennaby"),
            Person(12, 42949476, "Jorge"),
            Person(13, 47834341, "Augusto"),
            Person(14, 47527659, "Thiago")
        )
    private val arrayFour =
        arrayOf(
            Person(15, 47834406, "Gabriel"),
            Person(16, 52612637, "Lucas"),
            Person(17, 47834318, "Eduardo"),
            Person(18, 47723471, "Fabricio"),
            Person(19, 47834216, "Bruno")
        )
    private val arrayFive = arrayOf(
        Person(20, 47834261, "Icaro"),
        Person(21, 47747549, "Vinicius"),
        Person(22, 47834187, "Tayrone"),
        Person(23, 47834406, "Carlos"),
        Person(24, 47778635, "Hiago")
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
                val alertDialog = AlertDialog.Builder(view?.context)
                alertDialog.setView(inflaterView)
                alertDialog.setCancelable(false)
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
                    Toast.makeText(view?.context, "${person?.name}", Toast.LENGTH_SHORT).show()
                }
                btnExit.setOnClickListener {
                    dialogRaffle.dismiss()
                }
            }
        }
    }
}

