package com.example.appextra2_dado

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var ivResultado:ImageView
    private lateinit var btnDado:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()
        initListeners()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents()
    {
        ivResultado = findViewById(R.id.iv_dado)
        btnDado = findViewById(R.id.btn_dado)
    }

    private fun initListeners()
    {
        btnDado.setOnClickListener()
        {
            Toast.makeText(this, "¡Dado tirado!", Toast.LENGTH_SHORT).show()
            tirarDado()
        }
    }

    private fun initUI()
    {
        tirarDado()
    }

    private fun tirarDado()
    {
        val dado = Dado(6)
        val tirada = dado.tirada()

        val imagenDado = when (tirada) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        ivResultado.setImageResource(imagenDado)
        ivResultado.contentDescription = tirada.toString()
    }
}

class Dado(private val numLados:Int)
{
    fun tirada():Int
    {
        return (1..numLados).random()
    }
}