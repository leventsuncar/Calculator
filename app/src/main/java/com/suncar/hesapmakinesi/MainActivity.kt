package com.suncar.hesapmakinesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun textClick(view: View) {
        try {
            var conclusion = findViewById<EditText>(R.id.editTextConclusion)
            var btn = view as Button;
            var btnTextValue: String = conclusion.text.toString()

            if ( !btnTextValue.startsWith("-")) {
                if (btnTextValue.replace("""[+|\-|x|/]""".toRegex(), "").toDouble()
                        .equals("0".toDouble())
                ) {
                    btnTextValue = ""
                }
            }

            when (btn.id) {
                R.id.button_0 -> {
                    btnTextValue += "0";
                }
                R.id.button_1 -> {
                    btnTextValue += "1";
                }
                R.id.button_2 -> {
                    btnTextValue += "2";
                }
                R.id.button_3 -> {
                    btnTextValue += "3";
                }
                R.id.button_4 -> {
                    btnTextValue += "4";
                }
                R.id.button_5 -> {
                    btnTextValue += "5";
                }
                R.id.button_6 -> {
                    btnTextValue += "6";
                }
                R.id.button_7 -> {
                    btnTextValue += "7";
                }
                R.id.button_8 -> {
                    btnTextValue += "8";
                }
                R.id.button_9 -> {
                    btnTextValue += "9";
                }
                R.id.button_positiveNegative -> {
                    btnTextValue = if (btnTextValue.contains("-")) {
                        btnTextValue.replace("-", "")
                    } else {
                        "-$btnTextValue"
                    };
                }
            }
            conclusion.setText(btnTextValue);
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    var operator = 0;
    var oldTextNum = ""
    fun btnMathOperation(view: View) {
        try {
            var conclusion = findViewById<EditText>(R.id.editTextConclusion)
            var operationBtn = view as Button
            when (operationBtn.id) {
                R.id.button_division -> {
                    operator = R.id.button_division
                }
                R.id.button_plus -> {
                    operator = R.id.button_plus
                }
                R.id.button_X -> {
                    operator = R.id.button_X
                }
                R.id.button_minus -> {
                    operator = R.id.button_minus
                }
            }
            oldTextNum = conclusion.text.toString()

            when (operationBtn.id) {
                R.id.button_division -> {
                    oldTextNum += "/"
                }
                R.id.button_plus -> {
                    oldTextNum += "+"
                }
                R.id.button_X -> {
                    oldTextNum += "x"
                }
                R.id.button_minus -> {
                    oldTextNum += "-"
                }
            }
            conclusion.setText(oldTextNum)
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    fun equals(view: View) {
        var conclusion = findViewById<EditText>(R.id.editTextConclusion)
        var textBox = conclusion.text.toString().split("+", "-", "/", "x")
        var oldNum = textBox[0]
        var newNumber = textBox[textBox.size - 1]
        var finalNumber: Double? = null //null olabilir js gibi

        try {
            when (operator) {
                R.id.button_division -> {
                    finalNumber = oldNum.toDouble() / newNumber.toDouble()
                }
                R.id.button_X -> {
                    finalNumber = oldNum.toDouble() * newNumber.toDouble()
                }
                R.id.button_plus -> {
                    finalNumber = oldNum.toDouble() + newNumber.toDouble()
                }
                R.id.button_minus -> {
                    finalNumber = oldNum.toDouble() - newNumber.toDouble()
                }
            }
            findViewById<EditText>(R.id.editTextConclusion).setText(finalNumber.toString())
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun allClear(view: View) {
        try {
            var buttonClear = view as Button
            var number = findViewById<EditText>(R.id.editTextConclusion)

            when (buttonClear.id) {
                R.id.button_AC -> {
                    number.setText("0")
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT)
        }

    }

}