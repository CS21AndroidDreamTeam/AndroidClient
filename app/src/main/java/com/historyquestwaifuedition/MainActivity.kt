package com.historyquestwaifuedition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.historyquestwaifuedition.enums.MainMenuSelections
import com.historyquestwaifuedition.fragments.GameFragment
import com.historyquestwaifuedition.fragments.MainMenuFragment

class MainActivity : AppCompatActivity(), MainMenuFragment.OnSelectionsClickListener,
GameFragment.OnReturnToMainMenuListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openMainMenu()
    }

    override fun onSelectionsClick(clickedSelection: MainMenuSelections) {
        when (clickedSelection) {
            MainMenuSelections.NEW_GAME -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, GameFragment.newInstance())
                .commit()
            MainMenuSelections.QUIT -> finish()
        }
    }

    override fun onReturnToMainMenu() {
        openMainMenu()
    }

    fun openMainMenu() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, MainMenuFragment.newInstance())
            .commit()
    }
}

