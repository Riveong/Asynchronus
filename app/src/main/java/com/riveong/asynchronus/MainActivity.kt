package com.riveong.asynchronus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var Tombol: Button
    private lateinit var anu: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Tombol = findViewById(R.id.starT)
        anu = findViewById(R.id.statuS)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        Tombol.setOnClickListener {
            executor.execute {
                try {

                    for (i in 0..10) {
                        Thread.sleep(500)
                        val percentage = i * 10

                        handler.post {
                            if (percentage == 100) {
                                anu.setText(R.string.kelar)
                            } else {
                                anu.text = String.format(getString(R.string.status_d), percentage)
                            }
                        }
                    }


                } catch (e: InterruptedException) {
                    e.printStackTrace()


                }
            }
        }
    }
}