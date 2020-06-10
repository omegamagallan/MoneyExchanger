package com.example.myfirstappl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var rub_or_dol: String = "dol"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (editTextNumber.text.toString() != "") {
                    val countString = editTextNumber.text.toString()
                    var count = Integer.parseInt(countString)
                    if (rub_or_dol == "dol") {
                        count *= 74
                    }
                    else {
                        if (count != 0) {
                            count /= 74
                        }
                    }
                    textViewNum.setText(count.toString())
                } else {
                    editTextNumber.setText("0")
                }
            }
        })
    }

    fun on_press_button(view: View) {
        if (rub_or_dol == "dol") {
            rub_or_dol = "rub"
        } else {
            rub_or_dol = "dol"
        }
        val gap = editTextNumber.text.toString()
        var gap2 = textViewNum.text.toString()
        textViewNum.text = gap
        editTextNumber.setText(gap2)
        val gap3 = textView1.text.toString()
        gap2 = textView2.text.toString()
        textView1.text = gap2
        textView2.text = gap3
    }
}