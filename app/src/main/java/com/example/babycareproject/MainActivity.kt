package com.example.babycareproject

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.babycareproject.Pantallas.LoginActivity
import android.view.WindowManager




@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private val DURACION_SPLASH = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            startActivity(
                Intent(this,LoginActivity::class.java)
            )
            this.finish()
        }, DURACION_SPLASH.toLong())
    }
}
