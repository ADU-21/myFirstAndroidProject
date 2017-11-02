package com.example.yiddu.myfirstandroidproject.presenter

/**
 * Created by yiddu on 10/19/17.
 */
interface LoginContract {
    interface Presenter {
        fun startLogin(userName: String, password: String)
    }
    interface View {
        fun loginSuccess()
    }
}