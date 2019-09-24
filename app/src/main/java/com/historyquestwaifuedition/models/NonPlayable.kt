package com.historyquestwaifuedition.models

data class NonPlayable(
    val name: String,
    val dialogue : DialogueTree
) : Character(name = name, inventory =  mutableListOf(), health = 0)