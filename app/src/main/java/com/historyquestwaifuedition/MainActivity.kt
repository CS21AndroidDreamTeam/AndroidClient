package com.historyquestwaifuedition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.historyquestwaifuedition.api.HistoryQuestApiService
import com.historyquestwaifuedition.enums.LoginMenuSelections
import com.historyquestwaifuedition.enums.MainMenuSelections
import com.historyquestwaifuedition.fragments.GameFragment
import com.historyquestwaifuedition.fragments.LoginFragment
import com.historyquestwaifuedition.fragments.MainMenuFragment
import com.historyquestwaifuedition.fragments.SignupFragment

class MainActivity : AppCompatActivity(), MainMenuFragment.OnSelectionsClickListener,
    LoginFragment.OnSelectionsClickListener,
    GameFragment.OnReturnToMainMenuListener,
    SignupFragment.OnSelectionsClickListener {


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
            MainMenuSelections.LOGIN -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, LoginFragment.newInstance())
                .commit()
        }
    }

    override fun onSelectionsClick(clickedSelection: LoginMenuSelections) {
        when (clickedSelection) {
            LoginMenuSelections.SIGN_UP -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, SignupFragment.newInstance())
                .commit()
            LoginMenuSelections.LOGIN -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, MainMenuFragment.newInstance())
                .commit()
            LoginMenuSelections.SIGN_UP_FINAL -> supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, MainMenuFragment.newInstance())
                .commit()
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

