package com.historyquestwaifuedition.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.enums.LoginMenuSelections
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*


class SignupFragment : Fragment() {
    private var onSelectionsClickListener: OnSelectionsClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_sign_up.setOnClickListener {
            onSelectionsClickListener?.onSelectionsClick(LoginMenuSelections.SIGN_UP_FINAL)
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SignupFragment()
    }

    interface OnSelectionsClickListener {
        fun onSelectionsClick(clickedSelection: LoginMenuSelections)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is SignupFragment.OnSelectionsClickListener) {
            onSelectionsClickListener = context
        } else {
            throw RuntimeException("Context must implement OnSelectionsClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()

        onSelectionsClickListener = null
    }

}
