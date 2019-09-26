package com.historyquestwaifuedition.models

import java.io.Serializable


class NodeData(
    var id: Int? = null,
    var name: String? = null,
    var desc: String? = null,
    var positionx: Int? = null,
    var positiony: Int? = null
) : Serializable