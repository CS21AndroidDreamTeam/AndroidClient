package com.historyquestwaifuedition.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.enums.LoginMenuSelections
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call


class LoginFragment : Fragment() {
    private var onSelectionsClickListener: OnSelectionsClickListener? = null
    private var sendLogin: Call<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_sign_up.setOnClickListener {
            onSelectionsClickListener?.onSelectionsClick(LoginMenuSelections.SIGN_UP)
        }
        b_login_final.setOnClickListener{

            onSelectionsClickListener?.onSelectionsClick((LoginMenuSelections.LOGIN))
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }

    interface OnSelectionsClickListener {
        fun onSelectionsClick(clickedSelection: LoginMenuSelections)
    }

    override fun onAttach(context: Context?) {
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

}
