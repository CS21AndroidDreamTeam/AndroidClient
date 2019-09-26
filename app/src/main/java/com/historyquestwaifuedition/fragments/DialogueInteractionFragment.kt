package com.historyquestwaifuedition.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.api.HistoryQuestApi
import com.historyquestwaifuedition.api.HistoryQuestApiService
import com.historyquestwaifuedition.models.Landmark
import com.historyquestwaifuedition.models.NodeData
import com.historyquestwaifuedition.models.NonPlayable
import com.historyquestwaifuedition.models.Player

private const val ARG_PLAYER = "player"
private const val ARG_LANDMARK = "landmark"

class DialogueInteraction : Fragment() {
    private lateinit var historyQuestApiService: HistoryQuestApiService
    private lateinit var player: Player
    private lateinit var landmark: NodeData
    private lateinit var dialoguer: NonPlayable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            player = it.getSerializable(ARG_PLAYER) as Player
            landmark = it.getSerializable(ARG_LANDMARK) as NodeData
        }

        historyQuestApiService = HistoryQuestApi(context!!).service
        //Get NPC to Dialogue



        //Get item for NPC
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialogue_interaction, container, false)
    }






    companion object {

        @JvmStatic
        fun newInstance(player: Player, landmark: NodeData) =
            DialogueInteraction().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PLAYER, player)
                    putSerializable(ARG_LANDMARK, landmark)
                }
            }
    }
}
