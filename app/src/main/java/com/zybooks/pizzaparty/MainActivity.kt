package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8

/**
 * Sets the screen layout.
 * Creates variables for storing number of people and setting total number of pizzas.
 * Contains a function to calculate the total number of pizzas.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView

    /**
     * Sets the screen's layout imported from activity_main.xml.
     * Assigns and creates view for the string collected from edit text and text view to respective variables.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
    }

    /**
     * Converts the string to int for the number of people variable.
     * Implements a formula to calculate total number of pizzas by multiplying the number of people with the fixed number of slices per person and then dividing it by slices per pizza.
     */
    fun calculateClick(view: View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toInt()
        val slicesPerPerson = 4
        val totalPizzas = ceil(numAttend * slicesPerPerson /
                SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}