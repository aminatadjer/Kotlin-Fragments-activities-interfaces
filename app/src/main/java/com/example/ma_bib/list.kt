package com.example.ma_bib

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_list.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



class list : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_list, container, false)
        var bool = arguments?.getBoolean("tablet")
        var c = R.id.contaner
        if (bool == false){
             c = R.id.contaner
        }else if (bool == true ){
             c = R.id.c2
        }
        val book1 = v.findViewById<View>(R.id.book1) as ImageView
        val book2 = v.findViewById<View>(R.id.book2) as ImageView
        val book3 = v.findViewById<View>(R.id.book3) as ImageView
        val book4 = v.findViewById<View>(R.id.book4) as ImageView

        book1.setOnClickListener {
            val fragment = detail.newInstance(
                "ce que le jour doit a la nuit",
                "Yasmina Khadra",
                R.drawable.writer1,
                "Ce rêve, le voici, sous la forme d'une fresque émouvante et forte où se dessine, plus encore " +
                        "que l'amour impossible entre un Algérien et une Française, celui de deux peuples qui ont chéri " +
                        "ensemble, pendant plus d'un siècle, la même terre avant de s'entre-déchirer. Pour raviver cette" +
                        " passion commune que l'histoire a trop souvent tendance à oublier"
            )

            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(c, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }




        book2.setOnClickListener {
            val fragment = detail.newInstance(
                "A quoi reve les loups",
                "Yasmina Khadra",
                R.drawable.writer1,
                "À quoi rêvent les loups raconte un itinéraire insensé, et pourtant presque banal, aujourd'hui," +
                        " en Algérie. Nous sommes à la fin des années 80. Nafa Walid est un jeune Algérois d'origine très " +
                        "modeste qui rêve d'une très improbable carrière d'acteur international."   )
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(c, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        book3.setOnClickListener {
            val fragment = detail.newInstance(
                "Lalchimiste",
                "Paulo Coelho",
                R.drawable.writer2,
                "L'alchimiste. Résumé : Santiago, un jeune berger andalou, part à la recherche d'un " +
                        "trésor enfoui au pied des Pyramides. Lorsqu'il rencontre l'Alchimiste dans le désert, " +
                        "celui-ci lui apprend à écouter son cœur, à lire les signes du destin et, par-dessus tout, " +
                        "à aller au bout de son rêve"       )
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(c, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        book4.setOnClickListener {
            val fragment = detail.newInstance(
                "dans la vie tout est signe",
                "Paulo Coelho",
                R.drawable.writer2,
                "Dans la vie tout est signe raconte un itinéraire insensé, et pourtant presque banal," +
                        " aujourd'hui, en Algérie. Nous sommes à la fin des années 80. Nafa Walid est un " +
                        "jeune Algérois d'origine très modeste qui rêve d'une très improbable carrière d'acteur international." )
            val fragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(c, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return v
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "List des livres"
    }

    companion object {

        @JvmStatic
        fun newInstance(isTablet:Boolean) = list().apply {
            arguments = Bundle().apply {
                putBoolean("tablet",isTablet)
            }
        }
    }


}
