package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


class Player(
    name: String,
    health: Int,
    position: IntVec2D
): Character(name = name, inventory =  mutableListOf(), health = health, position = position), Serializable