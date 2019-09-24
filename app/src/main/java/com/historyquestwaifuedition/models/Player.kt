package com.historyquestwaifuedition.models

data class Player(
    val name: String,
    var health: Int
): Character(name = name, inventory =  mutableListOf(), health = health)