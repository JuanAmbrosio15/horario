package com.example.employe.Models

import android.os.Build
import java.time.LocalDate
import java.util.*

data class Employee(
    val id: String,
    val fullName: String,
    val academicLevel: String,
    val curp: String,
    val admissionDate: String, // Format YYYY-MM-DD
    val gender: String,
    val budgetKey: String
) {
    // If the API level is 26 or higher else use the old way
    fun getSeniority() = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
            LocalDate.now().year - LocalDate.parse(admissionDate).year
        }
        else -> {
            Calendar.getInstance().get(Calendar.YEAR) - admissionDate.take(4).toInt()
        }
    }
}