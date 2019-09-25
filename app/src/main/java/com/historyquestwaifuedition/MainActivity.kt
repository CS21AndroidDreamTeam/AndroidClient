package com.historyquestwaifuedition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.historyquestwaifuedition.enums.MainMenuSelections
import com.historyquestwaifuedition.fragments.GameFragment
import com.historyquestwaifuedition.fragments.LoginFragment
import com.historyquestwaifuedition.fragments.MainMenuFragment

class MainActivity : AppCompatActivity(), MainMenuFragment.OnSelectionsClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, MainMenuFragment.newInstance())
            .commit()

    }

    override fun onSelectionsClick(clickedSelection: MainMenuSelections) {
        when (clickedSelection) {
            MainMenuSelections.NEW_GAME -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, GameFragment.newInstance())
                .commit()
            MainMenuSelections.QUIT -> finish()
            MainMenuSelections.LOGIN -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, LoginFragment.newInstance())
                .commit()
        }
    }
}

