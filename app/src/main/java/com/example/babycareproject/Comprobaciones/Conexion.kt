package com.example.babycareproject.Comprobaciones

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull
import android.R.attr.password




class Conexion{

    lateinit var mAuth: FirebaseAuth

    fun iniciarConexion(){
        mAuth = FirebaseAuth.getInstance()
    }

    fun getInstance(): FirebaseAuth{
        return mAuth
    }

    fun getCurrentUser(): FirebaseUser? {
        iniciarConexion()
        return mAuth.currentUser
    }

    fun createNewUser(email:String,password:String):FirebaseUser?{
        var ban= mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    Log.d("CREAR_USER", "createUserWithEmail:success")
                } else {
                    Log.w("CREAR_USER", "createUserWithEmail:failure", task.exception)
                }
            }
//        while (!ban.isComplete){}
        return getCurrentUser()
    }

    fun logginNewUser(email:String,password:String):FirebaseUser?{
        var ban=mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("CREAR_USER", "signInWithEmail:success")
                    } else {
                        Log.w("CREAR_USER", "signInWithEmail:failure", task.exception)
                    }
                }
//        while (!ban.isComplete){}
        return getCurrentUser()
    }
}