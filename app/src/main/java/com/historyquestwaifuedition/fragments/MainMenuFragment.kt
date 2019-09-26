package com.historyquestwaifuedition.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.enums.MainMenuSelections
import kotlinx.android.synthetic.main.fragment_main_menu.*

class MainMenuFragment : Fragment() {
    private var onSelectionsClickListener: OnSelectionsClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_new_game.setOnClickListener {
            onSelectionsClickListener?.onSelectionsClick(MainMenuSelections.NEW_GAME)
        }

        b_quit.setOnClickListener {
            onSelectionsClickListener?.onSelectionsClick(MainMenuSelections.QUIT)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnSelectionsClickListener) {
            onSelectionsClickListener = context
        } else {
            throw RuntimeException("Context must implement OnSelectionsClickListener")
        }
    }



    override fun onDetach() {
        super.onDetach()

        onSelectionsClickListener = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainMenuFragment()
    }

    interface OnSelectionsClickListener {
        fun onSelectionsClick(clickedSelection: MainMenuSelections)
    }
}
