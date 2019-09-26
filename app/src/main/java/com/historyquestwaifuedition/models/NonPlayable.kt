package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D

class NonPlayable(
    name: String,
    dialogue : DialogueNode,
    position: IntVec2D
) : Character(name = name, inventory =  mutableListOf(), health = 0, position = position) {



}