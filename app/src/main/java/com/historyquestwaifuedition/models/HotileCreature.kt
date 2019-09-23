package com.historyquestwaifuedition.models

class HotileCreature(
    name: String,
    health: Int,
    drops: MutableList<Item>
)
    : Character(name = name, inventory = drops, health = health)
{
}