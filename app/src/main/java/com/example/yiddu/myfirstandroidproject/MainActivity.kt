package com.example.yiddu.myfirstandroidproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.example.yiddu.myfirstandroidproject.activity.HomeActivity
import com.example.yiddu.myfirstandroidproject.presenter.LoginContract
import com.example.yiddu.myfirstandroidproject.presenter.LoginPresenter

class MainActivity() : AppCompatActivity(), LoginContract.View, Parcelable {
    private val TAG = "LoginActivity"

    private lateinit var mBtnLogin: Button

    private lateinit var mEditUsername: EditText
    private lateinit var mEditPassword: EditText
    private val presenter = LoginPresenter(this)

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnLogin =  findViewById(R.id.buttob_login)
        mEditUsername = findViewById(R.id.text_username)
        mEditPassword = findViewById(R.id.text_password)

        mBtnLogin.setOnClickListener{
            presenter.startLogin(mEditUsername.text.toString(), mEditPassword.text.toString())
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun loginSuccess() {
        Log.i(TAG, "loginSuccess")
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
