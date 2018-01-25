package com.example.user.firstproject

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {


    private var mIsLogin = false
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE)
        mIsLogin = sharedPreferences.getBoolean("IsLogin",false)

        if(mIsLogin){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main_container, HomeFragment(), "HomeFragment")
                    .commit()
        }else{
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fl_main_container, LoginFragment(), "LoginFragment")
                    .commit()
        }

//        btn_login.setOnClickListener {
//        if(et_account.text.toString()=="red" && et_password.text.toString() == "123"){
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)
//
//        }else{
//            AlertDialog.Builder(this)
//                    .setTitle("錯誤訊息")
//                    .setMessage("帳號或密碼錯誤")
//                    .setPositiveButton("知道了",object: DialogInterface.OnClickListener{
//                        override fun onClick(dialog: DialogInterface?, which: Int) {
//                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                        }
//                    })
//                    .show()
// //           Toast.makeText(this,"帳號密碼錯誤",Toast.LENGTH_SHORT).show()
//        }
    }
}
