package com.lucasprojects.sorteiointegrador.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.entities.Team
import com.lucasprojects.sorteiointegrador.holder.RaffleViewHolder
import com.lucasprojects.sorteiointegrador.listenner.OnClickListenner

class Adapter( teamsList: ArrayList<Team>, listenner: OnClickListenner) : RecyclerView.Adapter<RaffleViewHolder>() {

    private val teamListProperty = teamsList
    private val listennerProperty = listenner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaffleViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_list_teams, parent, false)
        return RaffleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamListProperty.size
    }

    override fun onBindViewHolder(holder: RaffleViewHolder, position: Int) {
        val teams: Team = teamListProperty[position]
        holder.bindData(teams, listennerProperty)
    }
}