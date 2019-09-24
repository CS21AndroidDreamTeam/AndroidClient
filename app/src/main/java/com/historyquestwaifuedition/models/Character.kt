package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D

open class Character(
    var name: String,
    var inventory: MutableList<Item>,
    var health: Int,
    var position: IntVec2D
)