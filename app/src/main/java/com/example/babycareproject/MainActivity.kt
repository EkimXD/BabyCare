package com.example.babycareproject

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.babycareproject.pantallas.LoginActivity
import android.view.WindowManager
import android.widget.Toast
import com.example.babycareproject.comprobaciones.Conexion
import com.example.babycareproject.comprobaciones.Validaciones
import com.example.babycareproject.pantallas.AppActivity


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private val DURACION_SPLASH = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            startActivity(
                if (Conexion().getCurrentUser() != null
                ) {
                    Intent(this, AppActivity::class.java)
                    //TODO corregir direccionamiento dependiendo si es ninera o usuario normal
                } else {
                    Intent(this, LoginActivity::class.java)
                }
            )
            this.finish()
        }, DURACION_SPLASH.toLong())
    }
}
