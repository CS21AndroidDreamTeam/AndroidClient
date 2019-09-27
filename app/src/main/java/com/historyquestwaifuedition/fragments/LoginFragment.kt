package com.historyquestwaifuedition.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.api.HistoryQuestApi
import com.historyquestwaifuedition.api.HistoryQuestApiService
import com.historyquestwaifuedition.enums.LoginMenuSelections
import com.historyquestwaifuedition.models.LoginDetails
import com.historyquestwaifuedition.models.LoginKey
import kotlinx.android.synthetic.main.fragment_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {
    private lateinit var historyQuestApiService: HistoryQuestApiService
    private var onSelectionsClickListener: OnSelectionsClickListener? = null
    private var sendLogin: Call<LoginKey>? = null
    private val sendLoginCallback: Callback<LoginKey> = object:
        Callback<LoginKey> {
        override fun onFailure(call: Call<LoginKey>, t: Throwable) {
            print(t)
        }

        override fun onResponse(call: Call<LoginKey>, response: Response<LoginKey>) {
            if (response.code() == 400) {
                Toast.makeText(context, "Login Unsuccessful, check your Username/Password", Toast.LENGTH_LONG).show()
            }
            else if (response.code() == 200) {
                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                val sharedPref: SharedPreferences = context!!.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPref.edit()
                editor.putString("username", et_username.text.toString())
                editor.putString("token", response.body()!!.key)
                editor.apply()
                onSelectionsClickListener?.onSelectionsClick((LoginMenuSelections.LOGIN))
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        historyQuestApiService = HistoryQuestApi(context!!).service
    }

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
            sendLogin?.cancel()

            val loginInfo = LoginDetails(et_username.text.toString(), et_password.text.toString())

            sendLogin = historyQuestApiService.sendLogin(loginInfo)
            sendLogin?.enqueue(sendLoginCallback)
        }
        tv_go_back.setOnClickListener{
            onSelectionsClickListener?.onSelectionsClick((LoginMenuSelections.BACK_TO_MENU))
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

}
