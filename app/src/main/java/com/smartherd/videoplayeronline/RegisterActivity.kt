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
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    var firebaseAuth:FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        firebaseAuth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener {
            RegisterUsers()
        }
    }
    private fun RegisterUsers(){

        val email = email_text.text.toString()
        val password = password_text.text.toString()

        if (TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){

            Toast.makeText(applicationContext, "this can't be empty", Toast.LENGTH_SHORT).show()
        }else{

            firebaseAuth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener(object : OnCompleteListener<AuthResult>{
                override fun onComplete(task: Task<AuthResult>) {

                    if (task.isSuccessful){
                        Toast.makeText(applicationContext, "Account Created", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    }else{
                        Toast.makeText(applicationContext,"ERROR", Toast.LENGTH_SHORT).show()
                    }

                }


            })
        }

    }
}
