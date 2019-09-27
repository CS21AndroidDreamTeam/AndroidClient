package com.historyquestwaifuedition.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.math.IntVec2D
import com.historyquestwaifuedition.math.Vec2D
import com.historyquestwaifuedition.models.HMap
import com.historyquestwaifuedition.models.Node
import com.historyquestwaifuedition.models.Player
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment() {
    private var player: Player? = null
    private var map: HMap? = null
    private var playerView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun setPlayer(player: Player) {
        this.player = player

        if (playerView == null) {
            playerView = ImageView(context)
        }
        playerView?.let {
            it.setImageResource(R.drawable.sensei) // TODO
            (view as ViewGroup).addView(playerView)
            it.layoutParams.width = 100 // TODO
            it.layoutParams.height = 100 // TODO
        }

        updatePlayerPosition()
    }

    fun setMap(map: HMap) {
        this.map = map
        gl_map.removeAllViews()
        gl_map.columnCount = MAP_VIEW_SIZE.x
        gl_map.rowCount = MAP_VIEW_SIZE.y
        val nodeWidth = gl_map.bottom / MAP_VIEW_SIZE.y
        for (i in 0..(MAP_VIEW_SIZE.x * MAP_VIEW_SIZE.y)) {
            val imageView = ImageView(context)
            gl_map.addView(imageView)
            imageView.layoutParams.width = nodeWidth
            imageView.layoutParams.height = nodeWidth
        }

        updatePlayerPosition()
    }

    fun updatePlayerPosition() { // TODO optimize send the previous position so we don't have to check if the map images changed
        player ?: return
        map ?: return

        // update map images
        val mapTopLeft = IntVec2D(
            (player!!.position.x / MAP_VIEW_SIZE.x) * MAP_VIEW_SIZE.x,
            (player!!.position.y / MAP_VIEW_SIZE.y) * MAP_VIEW_SIZE.y
        )

//        val mapBottomRight = IntVec2D(
//            mapTopLeft.x + MAP_VIEW_SIZE.x - 1,
//            mapTopLeft.y + MAP_VIEW_SIZE.y - 1
//        )
//
//        val mapNodesStartIndex = mapTopLeft.x + (mapTopLeft.y * MAP_VIEW_SIZE.y)
//        val mapNodesEndIndex =  mapBottomRight.x + (mapBottomRight.y * MAP_VIEW_SIZE.y)
//
//        for ((mapViewI, mapNodesI) in (mapNodesStartIndex..mapNodesEndIndex).withIndex()) {
//            val imageView = gl_map.getChildAt(mapViewI) as ImageView
//
//            if (mapNodesI < map!!.nodes.size) {
//                imageView.setImageResource(TILE_LIST[if (Math.random() < 0.5f) 0 else 1])
//            } else { // out of bounds
//                imageView.background = null
//            }
//        }

        for (mapViewX in 0 until MAP_VIEW_SIZE.x) {
            val nodeX = mapTopLeft.x + mapViewX
            for (mapViewY in 0 until MAP_VIEW_SIZE.y) {
                val nodeY = mapTopLeft.y + mapViewY

                val mapViewI = mapViewX + (mapViewY * MAP_VIEW_SIZE.x)
                val imageView = gl_map.getChildAt(mapViewI) as ImageView

                if (nodeX < map!!.size.x && nodeY < map!!.size.y) {
                    val node = map!!.nodes[nodeX][nodeY]

                    when (node.name) {
                        "Road"->{
                            imageView.setImageResource(TILE_LIST[0])
                        }
                        "Prehistoric Cave" ->{
                            imageView.setImageResource(R.drawable.backpack)
                        }
                        "Medieval Wizards Tower" -> {
                            imageView.setImageResource(R.drawable.backpack)
                        }
                        "Abandoned Cottage" -> {
                            imageView.setImageResource(R.drawable.belt)
                        }
                        "Alchemists Laboratory" -> {
                            imageView.setImageResource(R.drawable.belt)
                        }
                        "Viking Barracks" -> {
                            imageView.setImageResource(R.drawable.bomb)
                        }
                        "Roman Colosseum" -> {
                            imageView.setImageResource(R.drawable.bomb)
                        }
                        "London Shop" -> {
                            imageView.setImageResource(R.drawable.book)
                        }
                        "Futuristic Lab" -> {
                            imageView.setImageResource(R.drawable.book)
                        }
                        "Barbaric Outpost" -> {
                            imageView.setImageResource(R.drawable.bronze_coin)
                        }
                        "Western Town" -> {
                            imageView.setImageResource(R.drawable.bronze_coin)
                        }
                        "Colonial Puritan Church" -> {
                            imageView.setImageResource(R.drawable.clover)
                        }
                        "Nazi Meeting Hall" -> {
                            imageView.setImageResource(R.drawable.clover)
                        }
                        "Cold War Nuclear Site" -> {
                            imageView.setImageResource(R.drawable.feather)
                        }
                        "Chinese Pagoda" -> {
                            imageView.setImageResource(R.drawable.feather)
                        }
                        "Beached Pirate Ship" -> {
                            imageView.setImageResource(R.drawable.ring)
                        }

                        else-> {
                            imageView.setImageResource(TILE_LIST[1])
                        }
                    }

                } else { // out of bounds
                    imageView.setImageBitmap(null)
                }
            }
        }

        // update player position on the map
        val playerRelativeScreenPosition = IntVec2D(
            player!!.position.x % MAP_VIEW_SIZE.x,
            player!!.position.y % MAP_VIEW_SIZE.y
        )
        val mapNodeImageViewSize = gl_map.bottom / MAP_VIEW_SIZE.y
        val playerViewTranslation = Vec2D(
            (mapNodeImageViewSize * 0.5f) + (mapNodeImageViewSize * playerRelativeScreenPosition.x) - playerView!!.layoutParams.width * 0.5f,
            (mapNodeImageViewSize * 0.5f) + (mapNodeImageViewSize * playerRelativeScreenPosition.y) - playerView!!.layoutParams.height * 0.5f
        )

        playerView!!.x = playerViewTranslation.x
        playerView!!.y = playerViewTranslation.y
    }

    fun getLandmarkNode(player: Player) : Node = map!!.nodes[player.position.x][player.position.y]


    companion object {
        val MAP_VIEW_SIZE = IntVec2D(6, 6)

        val TILE_LIST = arrayOf(R.drawable.grass5, R.drawable.dirt5)

        @JvmStatic
        fun newInstance() =
            MapFragment()
    }
}
