package com.example.babycareproject.comprobaciones

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult


class Conexion{

    var mAuth: FirebaseAuth=FirebaseAuth.getInstance()

    fun iniciarConexion(){
        mAuth = FirebaseAuth.getInstance()
    }

    fun getInstance(): FirebaseAuth{
        return mAuth
    }

    fun getCurrentUser(): FirebaseUser? {
        return mAuth.currentUser
    }

    fun createNewUser(email:String,password:String): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(email, password)
    }

    fun logginNewUser(email:String,password:String): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(email, password)
    }

    fun logOutUser(){
        mAuth.signOut()
    }

    fun addUserExtraInformation(){

    }
}