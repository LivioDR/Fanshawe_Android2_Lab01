package com.example.project01.reinoso1165606.android2_lab01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DescriptionFrag:Fragment() {
    // Levels of happiness
    val levels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")

    // Description of each level:
    val descriptions = arrayOf("Immediate Gratification: Pleasure and minimize pain",
        "Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage",
        "Contributive: Do good beyond self, Make an optimal positive difference for others",
        "Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love.")

    private var selectedLevel:TextView? = null
    private var selectedDesc:TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.description_fragment, container, false)
        selectedLevel = view.findViewById(R.id.level)
        selectedDesc = view.findViewById(R.id.desc)
        return view
    }
    fun changeData(index:Int){
        selectedLevel?.text = levels[index]
        selectedDesc?.text = descriptions[index]
    }
}