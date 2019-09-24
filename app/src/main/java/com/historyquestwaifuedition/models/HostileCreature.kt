package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D

class HostileCreature(
    name: String,
    health: Int,
    drops: MutableList<Item>,
    position: IntVec2D
)
    : Character(name = name, inventory = drops, health = health, position = position)
{
}