package com.example.project01.reinoso1165606.android2_lab01

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView

class InstructionsActivity : AppCompatActivity(), ListFrag.OnItemClick {

    private var fragTwo:DescriptionFrag? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instructions)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // instantiation of fragments
        val fragOne = ListFrag()
        fragTwo = DescriptionFrag()

        // adding the fragments with the fragment manager
        val fragManager = supportFragmentManager
        fragManager.beginTransaction()
            .replace(R.id.listContainer,fragOne)
            .replace(R.id.descriptionContainer, fragTwo!!)
            .commit()

    }

    override fun changeDataWithIndex(index: Int) {
        fragTwo?.changeData(index)
    }
}