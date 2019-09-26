package com.historyquestwaifuedition.models

import android.text.BoringLayout
import org.w3c.dom.Text

data class DialogueNode(
    val dialgoue: String,
    val choiceLeft: DialogueNode? = null,
    val choiceRight: DialogueNode? = null
)