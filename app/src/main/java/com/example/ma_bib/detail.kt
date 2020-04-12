package com.example.ma_bib

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_detail.*






class detail() : Fragment() {




     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         val vv = inflater.inflate(R.layout.fragment_detail, container, false)
         val book = vv.findViewById<View>(R.id.book) as TextView
         val writer = vv.findViewById<View>(R.id.writer) as TextView
         val resume = vv.findViewById<View>(R.id.resume) as TextView
         val photo = vv.findViewById<View>(R.id.photo) as ImageView

         book.text = arguments?.getString("title")
         writer.text = arguments?.getString("writer")
         resume.text = arguments?.getString("resume")
         var photos:Int = 0
         if (arguments?.getInt("photo") != null){
              photos = arguments?.getInt("photo")!!
         }

         photo.setImageResource(photos)

         return vv

     }

    companion object {

        @JvmStatic
        fun newInstance(title:String,writer:String,photo:Int,resume:String) = detail().apply {
            arguments = Bundle().apply {
                putString("title",title)
                putString("writer",writer)
                putString("resume",resume)
                putInt("photo",photo)
            }
        }
    }
}
