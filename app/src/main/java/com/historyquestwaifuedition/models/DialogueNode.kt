package com.historyquestwaifuedition.models

import org.w3c.dom.Text

data class DialogueNode(
    val dialgoue: String,
    val previous: DialogueNode,
    val choiceLeft: DialogueNode,
    val choiceRight: DialogueNode
)