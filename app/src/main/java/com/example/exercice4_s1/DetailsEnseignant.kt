package com.example.exercice4_s1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsEnseignant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_enseignant)

        val intent = intent
        val ens = intent.extras.get("ens") as Enseignant
        val receiver_nom =  findViewById<TextView>(R.id.nom);
        val receiver_prenom =  findViewById<TextView>(R.id.prenom);
        val receiver_grade =  findViewById<TextView>(R.id.grade);
        val receiver_mail =  findViewById<TextView>(R.id.mail);
        receiver_nom.setText(ens.nom)
        receiver_prenom.setText(ens.prenom)
        receiver_grade.setText(ens.grade)
        receiver_mail.setText(ens.mail)


    }
}
