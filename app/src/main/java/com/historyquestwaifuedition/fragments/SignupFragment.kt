package com.historyquestwaifuedition.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.historyquestwaifuedition.R
import com.historyquestwaifuedition.api.HistoryQuestApi
import com.historyquestwaifuedition.api.HistoryQuestApiService
import com.historyquestwaifuedition.enums.LoginMenuSelections
import com.historyquestwaifuedition.models.LoginKey
import com.historyquestwaifuedition.models.RegistrationDetails
import kotlinx.android.synthetic.main.fragment_signup.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class SignupFragment : Fragment() {


    private lateinit var historyQuestApiService: HistoryQuestApiService
    private var onSelectionsClickListener: SignupFragment.OnSelectionsClickListener? = null
    private var sendRegistration: Call<LoginKey>? = null
    private val sendRegistrationCallback: Callback<LoginKey> = object:
        Callback<LoginKey> {
        override fun onFailure(call: Call<LoginKey>, t: Throwable) {
            print(t)
        }

        override fun onResponse(call: Call<LoginKey>, response: Response<LoginKey>) {
            if (response.code() == 400) {

                val jObjError = JSONObject(response.errorBody()!!.string())
                try {
                    Toast.makeText(
                        context,
                        "error: " + jObjError.getString("non_field_errors"),
                        Toast.LENGTH_LONG
                    ).show()
                }catch (e: Exception) {

                }
                try {
                    Toast.makeText(
                        context,
                        "password2: " + jObjError.getString("password2"),
                        Toast.LENGTH_LONG
                    ).show()
                }catch (e: Exception) {

                }
                try {
                    Toast.makeText(
                        context,
                        "password1: " + jObjError.getString("password1"),
                        Toast.LENGTH_LONG
                    ).show()
                }catch (e: Exception) {

                }
                try {
                    Toast.makeText(
                        context,
                        "email: " + jObjError.getString("email"),
                        Toast.LENGTH_LONG
                    ).show()
                }catch (e: Exception) {

                }
                try {
                    Toast.makeText(
                        context,
                        "username: " + jObjError.getString("username"),
                        Toast.LENGTH_LONG
                    ).show()
                }catch (e: Exception) {

                }



            } else if (response.code() == 201) {
                Toast.makeText(context, "Registration Successful!", Toast.LENGTH_SHORT).show()
                val sharedPref: SharedPreferences =
                    context!!.getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPref.edit()
                editor.putString("username", et_r_username.text.toString())
                editor.putString("token", response.body()!!.key)
                editor.apply()
                onSelectionsClickListener?.onSelectionsClick((LoginMenuSelections.SIGN_UP_FINAL))
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
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b_sign_up.setOnClickListener {
            sendRegistration?.cancel()

            val registrationInfo = RegistrationDetails(et_r_username.text.toString(), et_r_email.text.toString(), et_r_password1.text.toString(), et_r_password2.text.toString())

            sendRegistration = historyQuestApiService.sendRegistration(registrationInfo)
            sendRegistration?.enqueue(sendRegistrationCallback)
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
