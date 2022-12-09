package com.example.employe.Utilities

import android.content.Context
import android.widget.ArrayAdapter
import com.example.employe.R

class UI {
    companion object {
        fun adapterAcademico(context: Context): ArrayAdapter<String> {
            return ArrayAdapter(
                context,
                R.layout.item,
                context.resources.getStringArray(R.array.gradoAcademico)
            )
        }

        fun adapterGenero(context: Context): ArrayAdapter<String> {
            return ArrayAdapter(
                context,
                R.layout.item,
                context.resources.getStringArray(R.array.genero)
            )
        }
    }
}