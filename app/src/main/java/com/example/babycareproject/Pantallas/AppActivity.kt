package com.example.babycareproject.Pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.babycareproject.Comprobaciones.Conexion
import com.example.babycareproject.MainActivity
import com.example.babycareproject.R
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        button.setOnClickListener{logOutAction()}
    }

    private fun logOutAction() {
        Conexion().closeConetion()
        startActivity(
            Intent(this, MainActivity::class.java)
        )
        this.finish()
    }


}
