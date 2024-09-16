package com.example.project01.reinoso1165606.android2_lab01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity(), SurveyFragment.SendToActivity {

    var selectionLabel: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        selectionLabel = findViewById(R.id.happyLevel)

        val takeSurveyBtn = findViewById<Button>(R.id.takeSurveyBtn)
        takeSurveyBtn.setOnClickListener {
            val surveyFrag: DialogFragment = SurveyFragment()
            surveyFrag.show(supportFragmentManager, "survey")
        }

    }

    override fun selectOption(option:Int?){
        selectionLabel?.text = SurveyFragment.options[option!!]
    }

}