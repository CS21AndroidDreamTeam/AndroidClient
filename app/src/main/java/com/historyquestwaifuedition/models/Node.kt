package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D
import java.io.Serializable

class Node(
    var id: Int,
    var name: String,
    var desc: String,
    var position: IntVec2D
) : Serializable