package com.example.exo03tdm

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = "Activity 1"
    var calendar = Calendar.getInstance();
    var taskList = ArrayList<Task>();
    var listb= taskList;
    var list = ArrayList<Task>();
    val taskAdapter = ToDoList(list,this);
    var defautCombox = "Toutes"


    fun Today() // Afficher les taches d'ajourd'hui
    {
        val calendar = Calendar.getInstance()
        var today = ArrayList<Task>();
        val formatDate = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(formatDate, Locale.US)
        taskList.forEach{
            if (sdf.format(calendar.time).equals(sdf.format(it.taskdate.time)))
            {
                today.add(it)
            }
        }
        listb = today
        update()
    }

    fun Week() // Afficher les taches d'une semaine
    {
        val debSem = Calendar.getInstance()
        val finSem = Calendar.getInstance()
        finSem.add(Calendar.DATE,7)
        var weeklyList = ArrayList<Task>();
        val formatDate = "dd-MM-yyy"
        val sdf = SimpleDateFormat(formatDate, Locale.US)
        taskList.forEach{
            if (sdf.format(finSem.time)>sdf.format(it.taskdate.time))
            {
                if (sdf.format(debSem.time)<=sdf.format(it.taskdate.time))
                    weeklyList.add(it)
            }
        }
        listb = weeklyList
        update()
    }

    fun All() // Tous afficher
    {
        listb = taskList
        update()
    }

    fun update(){ // Mise à jour de la liste
        list.clear()
        listb.forEach{
            list.add(it)
        }
        taskAdapter.notifyDataSetChanged()
    }
    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.liste)
        recycler.layoutManager = LinearLayoutManager(this);
        recycler.adapter = taskAdapter;
        if (combox != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                listOf("Toutes", "Aujourd'hui", "Cette semaine")
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            combox.adapter = adapter
            combox.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Today()
                }

                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    val item = adapter.getItem(position)
                    if (item!=null)
                    {
                        updateItem(item)
                        defautCombox = item
                    }
                }
            }

        }
        if (today!=null)
        {
            today.setOnClickListener{
                updateItem("Aujourd'hui")
            }
        }
        if (week!=null){
            week.setOnClickListener{
                updateItem("Cette semaine")
            }
        }

        if (all!=null)
        {
            all.setOnClickListener{
                updateItem("Toutes")
            }
        }


        buttonAdd.setOnClickListener{
            DatePickerDialog(
                this@MainActivity,
                dateSetListener,
                // initialize with calendar's date for conveniece
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    val dateSetListener = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(
            view: DatePicker, year: Int, monthOfYear: Int,
            dayOfMonth: Int
        ) {
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            addTask()
            calendar = Calendar.getInstance()
        }
    }

    fun updateItem(item:String)
    {
        if (item=="Aujourd'hui")
        {
            Today()
        }
        else if (item == "Cette semaine")
        {
            Week()
        }
        else
        {
            All()
        }
    }

    fun addTask()
    {
        taskList.add(Task(enterTask.text.toString(),calendar))
        updateItem(defautCombox)
        update()
    }

}
