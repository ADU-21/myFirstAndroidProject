package com.example.yiddu.myfirstandroidproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var mBtnLogin: Button
    private lateinit var mEditUsername: EditText
    private lateinit var mEditPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBtnLogin =  findViewById(R.id.buttob_login)
        mEditUsername = findViewById(R.id.text_username)
        mEditPassword = findViewById(R.id.text_password)

        mBtnLogin.setOnClickListener{
            Log.i("Username", mEditUsername.editableText.toString())
            Log.i("Password", mEditPassword.editableText.toString())
            Log.i("Button", "Btn")
        }
    }
}
