package com.example.yiddu.myfirstandroidproject.presenter

import android.text.TextUtils
import android.util.Log

class LoginPresenter(private val loginView: LoginContract.View) : LoginContract.Presenter {
    private val TAG = "LoginPresenter"

    override fun startLogin(userName: String, password: String) {
        Log.d(TAG, "Username: $userName, Password: $password" )
        if (validateAccount(userName, password)) {
            // TODO call login api
            loginView.loginSuccess()
        }
    }

    private fun validateAccount(userName: String, password: String): Boolean {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            return false
        }
        return true
    }
}