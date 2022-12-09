package com.example.employe.Models

class CalculateFortnight private constructor(
    private val dateOfPayment: String,
    private val owner: Employee,
    private val listWorkSchedules: MutableList<WorkSchedules>,
) {
    data class Builder(
        val id: String,
        val owner: Employee,
        val dateOfPayment: String,
    ) {

        private val listWorkingSchedules = mutableListOf<WorkSchedules>()

        fun addWorkSchedules(workSchedules: WorkSchedules) = apply {
            listWorkingSchedules.add(workSchedules)
        }

        fun addAllWorkSchedules(workSchedules: List<WorkSchedules>) = apply {
            listWorkingSchedules.addAll(workSchedules)
        }

        fun build() = CalculateFortnight(dateOfPayment, owner, listWorkingSchedules)

    }

    fun getDetails(): Map<String, Int> {
        val details = mutableMapOf<String, Int>()
        listWorkSchedules.let {
            details["Falta"] = it.filter { it.getAttendance() == "Absense" }.size
            details["Asistencia"] = it.filter { it.getAttendance() == "Assistance" }.size
            details["Permiso"] = it.filter { it.getAttendance() == "Permission" }.size
            details["Retardo"] = it.filter { it.getAttendance() == "Delay" }.size
        }
        return details
    }

    fun getSeniority() = owner.getSeniority()

}