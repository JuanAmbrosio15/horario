package com.example.employe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.employe.Utilities.DatePicker
import com.example.employe.Utilities.UI.Companion.adapterAcademico
import com.example.employe.Utilities.UI.Companion.adapterGenero
import com.example.employe.databinding.ActivityMainBinding
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.supportActionBar?.hide()
        with(binding) {
            spGradoAcademico.setAdapter(adapterAcademico(this@MainActivity))
            spGenero.setAdapter(adapterGenero(this@MainActivity))
            btnSend.setOnClickListener { showData(spGradoAcademico.text.toString()) }
            btnFecha.setOnClickListener { showDatePicker(edtFecha) }
        }
    }

    fun showData(str: String) {
        AlertDialog.Builder(this)
            .setTitle("Es correcto ?")
            .setMessage("Grado academico: $str")
            .setPositiveButton("Okay") { _, _ ->
            }.setNegativeButton("Cancel") { _, _ ->
            }.show()
    }

    private fun showDatePicker(date: TextInputEditText) {
        DatePicker { year, month, day ->
            val day = day.toString().padStart(2, '0')
            val month = month.toString().padStart(2, '0')
            date.setText("$year-$month-$day")
        }.show(supportFragmentManager, "DatePicker")
    }

    private fun showItemSelected(sp: MaterialAutoCompleteTextView) {
        sp.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this@MainActivity, item, Toast.LENGTH_SHORT).show()
        }
    }
    
}