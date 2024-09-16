package com.example.project01.reinoso1165606.android2_lab01

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SurveyFragment: DialogFragment() {

    private var sendToActivity: SendToActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sendToActivity = context as? SendToActivity // implement the interface in context
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBox = AlertDialog.Builder(activity)
            .setTitle(R.string.survey_title)
            .setSingleChoiceItems(options, checkedOption) { dialog, which ->
                // assigning the selected option to the variable in the companion object
                checkedOption = which
            }
            .setPositiveButton("OK") { dialog, which ->
                // calling the function to set the value as implemented in MainActivity
                sendToActivity?.selectOption(checkedOption)
            }
            .setNegativeButton("Cancel") { dialog, which ->
                // Nothing to do here for now
            }
            .create()

        return dialogBox
    }

    companion object {
        val options = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")
        var checkedOption = 0
    }

    interface SendToActivity {
        fun selectOption(option:Int?)
    }
}