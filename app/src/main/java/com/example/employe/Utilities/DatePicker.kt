package com.example.employe.Utilities

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePicker(val listener: (year: Int, mount: Int, day: Int) -> Unit) : DialogFragment(),
    DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(
        view: DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        listener(year, month, dayOfMonth)
    }
}