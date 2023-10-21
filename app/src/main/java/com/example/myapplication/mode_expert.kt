package com.example.myapplication

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

import android.os.CountDownTimer
import android.os.Handler


class mode_expert : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer // declarer la viable son
    var secretNumber = 0
    var attempts = 0
    var gameEnded = false
    lateinit var temps:TextView
    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_expert)
        temps=findViewById(R.id.tempss)

        mediaPlayer=MediaPlayer.create(this,R.raw.applaudissement)  //instancier la variable son

        val random = Random()
        secretNumber = random.nextInt(100) // Choisir un nombre aléatoire entre 0 et 99


        // pour afficher le compteur du temps
        val countDownTimer = object : CountDownTimer(20000, 1000) { // 20000 millisecondes = 20 secondes, 1000 millisecondes = 1 seconde
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                temps.text = "$secondsRemaining"
            }

            override fun onFinish() {
                temps.text = "Terminé!"
            }
        }

        countDownTimer.start()

        val intent = Intent(this, MainActivity::class.java)
        val handler = Handler()    // initialiser le compteur du temps
        handler.postDelayed({
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Temps écoulé a la prochaine")
            builder.setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
                startActivity(intent)
            }
            val dialog = builder.create()
            dialog.show()

        }, 20000) // apres 20secandes il va afficher la popup w wa9et nenzel ok yarjaa lel page princiâle



    }

        fun verifier_exp(view: View) {

            println(secretNumber)

            val nbr_input: EditText = findViewById(R.id.nbr)

            val nbr = nbr_input.text.toString().toInt() //convertir le nombre en un entier

            attempts++ // compteur de nbr d'essai

            if (nbr == secretNumber) {

                val builder = AlertDialog.Builder(this)

                mediaPlayer.start() // pour activer le son

                builder.setTitle("Bravo")
                builder.setMessage("Tu as réussi en $attempts essais.")
                builder.setPositiveButton("OK") { dialog, which ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()

                val intent = Intent(this, MainActivity::class.java)
                val handler = Handler()
                handler.postDelayed({
                    startActivity(intent)
                    finish()
                }, 1500)
            } else {
                if(nbr>this.secretNumber)
                {
                    Toast.makeText(this, "Plus Petit", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"Plus Grand",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

