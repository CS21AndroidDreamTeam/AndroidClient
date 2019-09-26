package com.historyquestwaifuedition.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.models.NonPlayable
import com.historyquestwaifuedition.models.Player

private const val ARG_PLAYER = "player"

class DialogueInteraction : Fragment() {
    private lateinit var player: Player
    private lateinit var dialoguer: NonPlayable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            player = it.getSerializable(ARG_PLAYER) as Player
        }
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DialogueInteraction.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(player: Player) =
            DialogueInteraction().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PLAYER, player)
                }
            }
    }
}
