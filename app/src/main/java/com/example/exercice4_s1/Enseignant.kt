package com.example.exercice4_s1

import java.io.Serializable


class Enseignant(nom:String,prenom:String,grade:String,mail:String):Serializable{
    val nom="$nom"
    val prenom="$prenom"
    val grade="$grade"
    val mail="$mail"
}