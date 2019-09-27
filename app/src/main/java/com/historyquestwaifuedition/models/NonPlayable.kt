package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D

data class NonPlayable(
    val name: String,
    val dialogue : DialogueNode,
    val position: IntVec2D
)