package com.example.employe.Models

data class WorkSchedules(
    val day: String,
    val permissiomForAbsence: Boolean,
    val start: String,
    val end: String,
    val date: String,
) {
    fun getAttendance() = when {
        permissiomForAbsence -> "Permission"
        isAssistance() -> "Assistance"
        isADelay() -> "Delay"
        isAbsense() -> "Absense"
        else -> "Absense"
    }

    fun isAssistance() = start <= WorkingHours.startLimit && end >= WorkingHours.endLimit

    fun isADelay() = start >= WorkingHours.startLimit && start <= WorkingHours.lateEndLimit

    fun isAbsense() = start > WorkingHours.lateEndLimit || end <= WorkingHours.endLimit

}