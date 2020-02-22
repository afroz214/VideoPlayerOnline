package com.smartherd.videoplayeronline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var firebaseAuth:FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        btn_login?.setOnClickListener {

            LoginUser()
        }
    }
    private fun LoginUser(){

        val email = email_text_login.text.toString()
        val password = password_text_login.text.toString()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){

            Toast.makeText(applicationContext, "This Field can't be empty", Toast.LENGTH_SHORT).show()
        }else{

            firebaseAuth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {

                    if (task.isSuccessful){
                        Toast.makeText(applicationContext, "Login Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, DashBoardActivity::class.java))

                    }else{
                        Toast.makeText(applicationContext, "EEROR", Toast.LENGTH_SHORT).show()
                    }
                }


            })
        }
    }
}
