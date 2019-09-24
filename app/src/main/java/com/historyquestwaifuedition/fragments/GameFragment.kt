package com.historyquestwaifuedition.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.math.IntVec2D
import com.historyquestwaifuedition.models.HMap
import com.historyquestwaifuedition.models.Node
import com.historyquestwaifuedition.models.Player
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.hud.*

class GameFragment : Fragment() {
    private lateinit var player: Player
    private lateinit var map: HMap
    private lateinit var mapFragment: MapFragment
    private lateinit var HUDFragment: HUDFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = Player("testplayer", 100, IntVec2D(0, 0))

        val maxPosition = IntVec2D(9, 9) // TODO this is a test map
        val testNodes = mutableListOf<Node>()
        (0..maxPosition.y).forEach { y ->
            (0..maxPosition.x).forEach { x ->
                testNodes.add(Node(IntVec2D(x, y), if (Math.random() < 0.5) 0 else 1))
            }
        }
        map = HMap(maxPosition, testNodes)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapFragment = childFragmentManager.findFragmentById(R.id.f_map) as MapFragment
        HUDFragment = childFragmentManager.findFragmentById(R.id.f_hud) as HUDFragment

        object: Thread() {
            override fun run() {
                super.run()
                sleep(2000) // because map view is not created yet

                activity!!.runOnUiThread {
                    mapFragment.setMap(map)
                    mapFragment.setPlayer(player)
                    pb_loading.visibility = View.GONE
                }
            }
        }.start()

        HUDFragment.right_button.setOnClickListener {
            moveRight()
        }

        HUDFragment.left_button.setOnClickListener {
            moveLeft()
        }

        HUDFragment.up_button.setOnClickListener {
            moveUp()
        }

        HUDFragment.down_button.setOnClickListener {
            moveDown()
        }
    }

    private fun moveRight() {
        if (player.position.x == map.maxPosition.x) return // OOB
        player.position.x += 1
        mapFragment.updatePlayerPosition()
    }

    private fun moveLeft() {
        if (player.position.x == 0) return // OOB
        player.position.x -= 1
        mapFragment.updatePlayerPosition()
    }

    private fun moveUp() {
        if (player.position.y == 0) return // OOB
        player.position.y -= 1
        mapFragment.updatePlayerPosition()
    }

    private fun moveDown() {
        if (player.position.y == map.maxPosition.y) return // OOB
        player.position.y += 1
        mapFragment.updatePlayerPosition()
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            GameFragment()
    }
}
