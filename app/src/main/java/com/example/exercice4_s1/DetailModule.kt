package com.example.exercice4_s1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import java.io.Serializable


class DetailModule : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_module)
        val intent = intent
        val title=intent.getStringExtra("intitule")
        val duree=intent.getStringExtra("duree")
        val ens = intent.extras.get("ens") as Enseignant

        val receiver_intitule =  findViewById<TextView>(R.id.intitule);
        val receiver_duree =  findViewById<TextView>(R.id.duree);
        val receiver_ens =  findViewById<TextView>(R.id.ens);

        receiver_intitule.setText(title)
      receiver_duree.setText("Durée:  "+duree+" h")
       receiver_ens.setText("Enseignant: "+ens.nom)

        val button = findViewById<Button>(R.id.details)
        button.setOnClickListener{
            val intent = Intent(this, DetailsEnseignant::class.java)
            intent.putExtra("ens",ens as Serializable)
            startActivity(intent)
        }

    }
}


