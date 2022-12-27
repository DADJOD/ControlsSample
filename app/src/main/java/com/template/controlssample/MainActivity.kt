package com.template.controlssample

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.template.controlssample.R.string.*

class MainActivity : AppCompatActivity() {
    private lateinit var prefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    companion object {
        const val PREFS = "PREFS"
        const val EXTRA_SELECTED = "EXTRA_SELECTED"
    }

    fun onButtonClicked(view: View) {
        doToast(getString(button_pressed))
    }

    fun onCheckboxClicked(view: View) {
        prefs = getSharedPreferences(PREFS, MODE_PRIVATE)
        val editor: Editor = prefs.edit()

        if ((view as CheckBox).isChecked) {
            editor.putString(EXTRA_SELECTED, savedStateRegistry.toString()).apply()

            doToast(getString(checked))
        } else {
            doToast(getString(unchecked))
        }
    }

    fun onToggleClicked(view: View) {
        if ((view as ToggleButton).isChecked) {
            doToast(getString(text_on_act))
        } else {
            doToast(getString(text_off_act))
        }
    }

    fun onRadioButtonClicked(view: View) {
        val rb = view as RadioButton
        doToast("Выбрано животное: ${rb.text}")
    }

    fun onClearButtonClicked(view: View) {
        doToast(getString(cleared))

    }

    private fun doToast(text: String) {
        return Toast.makeText(this, text, Toast.LENGTH_SHORT)
            .show()
    }


}
