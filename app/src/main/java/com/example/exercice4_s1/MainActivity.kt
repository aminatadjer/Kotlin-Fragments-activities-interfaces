package com.example.exercice4_s1

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.provider.Settings.System.getConfiguration
import android.view.Display
import android.view.WindowManager
import java.io.Serializable
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Surface
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (newConfig != null) {
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                setContentView(R.layout.activity_main)
                val ens1 = Enseignant("Batata", "Sofiane", "Enseignant Chercheur", "s_batata@esi.dz")
                val ens2 =
                    Enseignant("chebieb", "AbdElkrim", "Enseignant Chercheur", "k_chebieb@esi.dz")
                val ens3 = Enseignant("benatchba", "Karima", "Maitre Conférence", "k_benatchba@esi.dz")
                val seance1 = Seance("Mobile", 4, ens1)
                val seance2 = Seance("Projet", 4, ens1)
                val seance3 = Seance("Alog", 2, ens2)
                val seance4 = Seance("ML", 2, ens3)
                var tab = arrayOf(seance1, seance2, seance3, seance4)
                val intitule =  findViewById<TextView>(R.id.intitule);
                val duree =  findViewById<TextView>(R.id.duree);
                val nom =  findViewById<TextView>(R.id.nom);
                val prenom =  findViewById<TextView>(R.id.prenom);
                val grade =  findViewById<TextView>(R.id.grade);
                val mail =  findViewById<TextView>(R.id.mail);
                for (i in 1..4) {
                    val butt = "button" + i
                    val resID = resources.getIdentifier(butt, "id", packageName)
                    val button = findViewById<Button>(resID)
                    button.setOnClickListener {
                        intitule.setText(tab[i - 1].intitule)
                        duree.setText("Durée:  "+tab[i - 1].duree.toString()+" h")
                        nom.setText(tab[i - 1].ens.nom .toString() )
                        prenom.setText(tab[i - 1].ens.prenom .toString() )
                        grade.setText(tab[i - 1].ens.grade .toString() )
                        mail.setText(tab[i - 1].ens.mail .toString() )


                    }
                }



                Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();

            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                setContentView(R.layout.activity_main)
                val ens1 = Enseignant("Batata", "Sofiane", "Enseignant Chercheur", "s_batata@esi.dz")
                val ens2 =
                    Enseignant("chebieb", "AbdElkrim", "Enseignant Chercheur", "k_chebieb@esi.dz")
                val ens3 = Enseignant("benatchba", "Karima", "Maitre Conférence", "k_benatchba@esi.dz")
                val seance1 = Seance("Mobile", 4, ens1)
                val seance2 = Seance("Projet", 4, ens1)
                val seance3 = Seance("Alog", 2, ens2)
                val seance4 = Seance("ML", 2, ens3)
                var tab = arrayOf(seance1, seance2, seance3, seance4)
                for (i in 1..4) {
                    val butt = "button" + i
                    val resID = resources.getIdentifier(butt, "id", packageName)
                    val button = findViewById<Button>(resID)
                    button.setOnClickListener {
                        val intent = Intent(this, DetailModule::class.java)
                        intent.putExtra("intitule", tab[i - 1].intitule)
                        intent.putExtra("duree", tab[i - 1].duree.toString())
                        intent.putExtra("ens", tab[i - 1].ens as Serializable)
                        startActivity(intent)

                    }
                }


                Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            }
        }
    }




}
