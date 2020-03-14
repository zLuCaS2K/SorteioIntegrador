package com.lucasprojects.sorteiointegrador.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.adapter.Adapter
import com.lucasprojects.sorteiointegrador.constants.Constants
import com.lucasprojects.sorteiointegrador.entities.Team
import com.lucasprojects.sorteiointegrador.listenner.OnClickListenner

class HomeFragment : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mOnClickListenner: OnClickListenner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        createInteractionTeams(view.context)
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

    private fun createInteractionTeams(context: Context) {
        mOnClickListenner = object : OnClickListenner {
            override fun onClickItem(idTeam: Int) {
                Toast.makeText(context, "O Time clicado foi $idTeam", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
