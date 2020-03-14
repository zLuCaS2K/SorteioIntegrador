package com.lucasprojects.sorteiointegrador.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.lucasprojects.sorteiointegrador.R
import com.lucasprojects.sorteiointegrador.entities.Team
import com.lucasprojects.sorteiointegrador.listenner.OnClickListenner

class RaffleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mTeamName = itemView.findViewById<TextView>(R.id.textTeam)
    private val mTeamImage = itemView.findViewById<ImageView>(R.id.imageTeam)
    private val layoutContraintOne = itemView.findViewById<ConstraintLayout>(R.id.layoutContraintOne)

    fun bindData(team: Team, listenner: OnClickListenner) {
        mTeamName.text = team.name
        when (team.idTeam) {
            1 -> mTeamImage.setImageResource(R.drawable.petshop)
            2 -> mTeamImage.setImageResource(R.drawable.autonomous)
            3 -> mTeamImage.setImageResource(R.drawable.coffee)
            4 -> mTeamImage.setImageResource(R.drawable.math)
            5 -> mTeamImage.setImageResource(R.drawable.startup)
        }

        layoutContraintOne.setOnClickListener {
            listenner.onClickItem(team.idTeam)
        }
    }
}