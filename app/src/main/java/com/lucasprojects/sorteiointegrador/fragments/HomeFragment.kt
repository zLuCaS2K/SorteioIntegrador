package com.lucasprojects.sorteiointegrador.fragments

import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.adapter.Adapter
import com.lucasprojects.sorteiointegrador.constants.Constants
import com.lucasprojects.sorteiointegrador.entities.Person
import com.lucasprojects.sorteiointegrador.entities.Team
import com.lucasprojects.sorteiointegrador.listenner.OnClickListenner
import com.squareup.picasso.Picasso
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var mFilterMode: Int = 0
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mOnClickListenner: OnClickListenner

    private val arrayOne = arrayOf(
        Person(1, 47834248, Constants.PERSON_NAME.SARA),
        Person(2, 47834260, Constants.PERSON_NAME.ALICIA),
        Person(3, 43190904, Constants.PERSON_NAME.LARA)
    )
    private val arrayTwo = arrayOf(
        Person(4, 47834734, Constants.PERSON_NAME.ALAN),
        Person(5, 14566722, Constants.PERSON_NAME.DANYLO),
        Person(6, 29796449, Constants.PERSON_NAME.VICTOR),
        Person(7, 54503973, Constants.PERSON_NAME.FELIPE),
        Person(8, 47700368, Constants.PERSON_NAME.CAIO)
    )
    private val arrayThree =
        arrayOf(
            Person(9, 47834365, Constants.PERSON_NAME.MATHEUS),
            Person(10, 47751527, Constants.PERSON_NAME.DE_CELLIS),
            Person(11, 47834230, Constants.PERSON_NAME.SUENNABY),
            Person(12, 42949476, Constants.PERSON_NAME.JORGE),
            Person(13, 47834341, Constants.PERSON_NAME.AUGUSTO),
            Person(14, 47527659, Constants.PERSON_NAME.THIAGO)
        )
    private val arrayFour =
        arrayOf(
            Person(15, 47834406, Constants.PERSON_NAME.GABRIEL),
            Person(16, 52612637, Constants.PERSON_NAME.LUCAS),
            Person(17, 47834318, Constants.PERSON_NAME.EDUARDO),
            Person(18, 47723471, Constants.PERSON_NAME.FABRICIO),
            Person(19, 47834216, Constants.PERSON_NAME.BRUNO)
        )
    private val arrayFive = arrayOf(
        Person(20, 47834261, Constants.PERSON_NAME.ICARO),
        Person(21, 47747549, Constants.PERSON_NAME.VINICIUS),
        Person(22, 47834187, Constants.PERSON_NAME.THAYRONE),
        Person(23, 47834406, Constants.PERSON_NAME.CARLOS),
        Person(24, 47778635, Constants.PERSON_NAME.HIAGO)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val argument = arguments
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        if (argument != null) {
            mFilterMode = argument.getInt("mode")
        }
        createInteractionTeams(mFilterMode)
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

    private fun createInteractionTeams(mFilter: Int) {
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
                    Constants.TEAMS_ID.TEAMTHREE -> textNameTeam.text =
                        Constants.TEAMS_NAMES.TEAMTHREE
                    Constants.TEAMS_ID.TEAMFOUR -> textNameTeam.text =
                        Constants.TEAMS_NAMES.TEAMFOUR
                    Constants.TEAMS_ID.TEAMFIVE -> textNameTeam.text =
                        Constants.TEAMS_NAMES.TEAMFIVE
                }
                val alertDialog = AlertDialog.Builder(view?.context)
                alertDialog.setView(inflaterView)
                alertDialog.setCancelable(true)
                val dialogRaffle = alertDialog.create()
                if (dialogRaffle.window != null) {
                    dialogRaffle.window?.setBackgroundDrawable(ColorDrawable(0))
                }
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

                    if (mFilter == 0) {
                        when (person?.name) {
                            Constants.PERSON_NAME.ALAN -> imageMember.setImageResource(R.drawable.alan)
                            Constants.PERSON_NAME.ALICIA -> imageMember.setImageResource(R.drawable.alicia)
                            Constants.PERSON_NAME.AUGUSTO -> imageMember.setImageResource(R.drawable.augusto)
                            Constants.PERSON_NAME.BRUNO -> imageMember.setImageResource(R.drawable.bruno)
                            Constants.PERSON_NAME.CAIO -> imageMember.setImageResource(R.drawable.caio)
                            Constants.PERSON_NAME.CARLOS -> imageMember.setImageResource(R.drawable.carlos)
                            Constants.PERSON_NAME.DANYLO -> imageMember.setImageResource(R.drawable.danylo)
                            Constants.PERSON_NAME.DE_CELLIS -> imageMember.setImageResource(R.drawable.decellis)
                            Constants.PERSON_NAME.EDUARDO -> imageMember.setImageResource(R.drawable.eduardo)
                            Constants.PERSON_NAME.FABRICIO -> imageMember.setImageResource(R.drawable.fabricio)
                            Constants.PERSON_NAME.FELIPE -> imageMember.setImageResource(R.drawable.felipe)
                            Constants.PERSON_NAME.GABRIEL -> imageMember.setImageResource(R.drawable.gabriel)
                            Constants.PERSON_NAME.HIAGO -> imageMember.setImageResource(R.drawable.hiago)
                            Constants.PERSON_NAME.ICARO -> imageMember.setImageResource(R.drawable.icaro)
                            Constants.PERSON_NAME.JORGE -> imageMember.setImageResource(R.drawable.jorge)
                            Constants.PERSON_NAME.LARA -> imageMember.setImageResource(R.drawable.lara)
                            Constants.PERSON_NAME.LUCAS -> imageMember.setImageResource(R.drawable.lucas)
                            Constants.PERSON_NAME.MATHEUS -> imageMember.setImageResource(R.drawable.matheus)
                            Constants.PERSON_NAME.SARA -> imageMember.setImageResource(R.drawable.sara)
                            Constants.PERSON_NAME.SUENNABY -> imageMember.setImageResource(R.drawable.suennaby)
                            Constants.PERSON_NAME.THAYRONE -> imageMember.setImageResource(R.drawable.thayrone)
                            Constants.PERSON_NAME.THIAGO -> imageMember.setImageResource(R.drawable.thiago)
                            Constants.PERSON_NAME.VICTOR -> imageMember.setImageResource(R.drawable.victor)
                            Constants.PERSON_NAME.VINICIUS -> imageMember.setImageResource(R.drawable.vinicius)
                        }
                        val animation = AnimationUtils.loadAnimation(view?.context, R.anim.zoom_in)
                        imageMember.startAnimation(animation)
                        textNameMember.text = person?.name?.toUpperCase()
                    } else {
                        val cm =
                            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
                        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
                        if (isConnected) {
                            Picasso.get()
                                .load("https://avatars1.githubusercontent.com/u/${person?.idGit}")
                                .into(imageMember)
                            val animation =
                                AnimationUtils.loadAnimation(view?.context, R.anim.zoom_in)
                            imageMember.startAnimation(animation)
                            textNameMember.text = person?.name?.toUpperCase()
                        } else {
                            textNameMember.text = getString(R.string.no_conected)
                            textNameMember.setTextColor(
                                ContextCompat.getColor(
                                    view!!.context,
                                    R.color.colorRed
                                )
                            )
                            Toast.makeText(view?.context, "Sem Conexão", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                btnExit.setOnClickListener {
                    dialogRaffle.dismiss()
                }
            }
        }
    }
}

