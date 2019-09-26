package com.historyquestwaifuedition.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.api.HistoryQuestApi
import com.historyquestwaifuedition.api.HistoryQuestApiService
import com.historyquestwaifuedition.models.*
import kotlinx.android.synthetic.main.fragment_dialogue_interaction.*

private const val ARG_PLAYER = "player"
private const val ARG_LANDMARK = "landmark"

class DialogueInteraction : Fragment() {
    private lateinit var historyQuestApiService: HistoryQuestApiService
    private lateinit var player: Player
    private lateinit var landmark: NodeData
    private lateinit var dialogue: NonPlayable
    var giveItem: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            player = it.getSerializable(ARG_PLAYER) as Player
            landmark = it.getSerializable(ARG_LANDMARK) as NodeData
        }

        historyQuestApiService = HistoryQuestApi(context!!).service
        //Get NPC to Dialogue

        val name = landmark.name as String
        dialogue = NonPlayableFactory.createNonPlayable(name)

        //Get item for NPC
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dialogue_interaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(landmark.name) {
            "Prehistoric Cave" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgcave)
                iv_dialogue_npc.setImageResource(R.drawable.npccave)
            }
            "Medieval Wizards Tower" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgwizard)
                iv_dialogue_npc.setImageResource(R.drawable.npcwizard)
            }
            "Abandoned Cottage" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgcottage)
                iv_dialogue_npc.setImageResource(R.drawable.npccottage)
            }
            "Alchemists Laboratory" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgalchemist)
                iv_dialogue_npc.setImageResource(R.drawable.npcalchemist)
            }
            "Viking Barracks" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgviking)
                iv_dialogue_npc.setImageResource(R.drawable.npcviking)
            }
            "Roman Colosseum" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgroman)
                iv_dialogue_npc.setImageResource(R.drawable.npcrome)
            }
            "London Shop" -> {
                iv_dialogue_background.setImageResource(R.drawable.bglondon)
                iv_dialogue_npc.setImageResource(R.drawable.npclondon)
            }
            "Futuristic Lab" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgfuture)
                iv_dialogue_npc.setImageResource(R.drawable.npclab)
            }
            "Barbaric Outpost" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgbarb)
                iv_dialogue_npc.setImageResource(R.drawable.npcbarbarian)
            }
            "Western Town" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgwestern)
                iv_dialogue_npc.setImageResource(R.drawable.npcwestern)
            }
            "Colonial Puritan Church" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgchurch)
                iv_dialogue_npc.setImageResource(R.drawable.npcpuritan)
            }
            "Nazi Meeting Hall" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgmeetinghall)
                iv_dialogue_npc.setImageResource(R.drawable.npcmeeting)
            }
            "Cold War Nuclear Site" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgnuclear)
                iv_dialogue_npc.setImageResource(R.drawable.npcnuclear)
            }
            "Chinese Pagoda" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgpagoda)
                iv_dialogue_npc.setImageResource(R.drawable.npcpagoda)
            }
            "Beached Pirate Ship" -> {
                iv_dialogue_background.setImageResource(R.drawable.bgpirate)
                iv_dialogue_npc.setImageResource(R.drawable.npcpirate)
            }
            else -> throw IllegalArgumentException("This shouldn't be possible")

        }
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
