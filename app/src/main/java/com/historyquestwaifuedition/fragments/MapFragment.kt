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

val MAP_SIZE = IntVec2D(5, 5)

class MapFragment : Fragment() {
    private lateinit var player: Player
    private lateinit var map: HMap
    private lateinit var playerView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = Player("testplayer", 100, IntVec2D(0, 0))

        val maxPosition = IntVec2D(9, 9) // TODO this is a test map
        val testNodes = mutableListOf<Node>()
        (0..maxPosition.y).forEach { y ->
            (0..maxPosition.x).forEach { x ->
                testNodes.add(Node(IntVec2D(x, y), 0))
            }
        }
        map = HMap(maxPosition, testNodes)

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

        playerView = ImageView(context)
        playerView.setImageResource(R.drawable.sensei)
        (view as ViewGroup).addView(playerView)
        playerView.layoutParams.width = 100
        playerView.layoutParams.height = 100

        object: Thread() {
            override fun run() {
                super.run()
                sleep(3000)

                activity!!.runOnUiThread {
                    player.position.x = 1
                    updatePlayerPosition()
                }
            }
        }.start()
    }

    fun updatePlayerPosition() { // TODO optimize send the previous position so we don't have to check if the map images changed

        // update map images
        val mapTopLeft = IntVec2D(
            (player.position.x / MAP_SIZE.x) * 5,
            (player.position.y / MAP_SIZE.y) * 5
        )
        val mapBottomRight = IntVec2D(
            mapTopLeft.x + MAP_SIZE.x - 1,
            mapTopLeft.y + MAP_SIZE.y - 1
        )

        val mapNodesStartIndex = mapTopLeft.x + (mapTopLeft.y * MAP_SIZE.y)
        val mapNodesEndIndex =  mapBottomRight.x + (mapBottomRight.y * MAP_SIZE.y)

        for ((mapViewI, mapNodesI) in (mapNodesStartIndex..mapNodesEndIndex).withIndex()) {
            val imageView = gl_map.getChildAt(mapViewI) as ImageView

            if (mapNodesI < map.nodes.size) {
                // TODO set image of map node image view
                //imageView.setImageResource()
            } else { // out of bounds
                imageView.background = null
            }
        }

        // update player position on the map
        val playerRelativeScreenPosition = IntVec2D(
            player.position.x % MAP_SIZE.x,
            player.position.y % MAP_SIZE.y
        )
        val mapNodeImageViewSize = gl_map.bottom / MAP_SIZE.y
        val playerViewTranslation = Vec2D(
            (mapNodeImageViewSize * 0.5f) + (mapNodeImageViewSize * playerRelativeScreenPosition.x) - playerView.layoutParams.width * 0.5f,
            (mapNodeImageViewSize * 0.5f) + (mapNodeImageViewSize * playerRelativeScreenPosition.y) - playerView.layoutParams.height * 0.5f
        )

        playerView.x = playerViewTranslation.x
        playerView.y = playerViewTranslation.y
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MapFragment()
    }
}
