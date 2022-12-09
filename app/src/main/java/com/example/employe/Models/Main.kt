package com.example.employe.Models

fun main() {

    val personaA = Employee(
        "SEP99", "URIEL AMBROSIO CRUZ",
        "Maestria", "AUCJ980715HOMRN02",
        "2019-01-01", "Masculino",
        "SEP2022"
    )

    val personaB = Employee(
        "SEP9999", "GABRIELA AMBROSIO CRUZ",
        "Doctorado", "AUMC783647MOMS02",
        "2019-01-02", "Femenino",
        "SEP2022"
    )

    val semanaOne = listOf(
        WorkSchedules("Monday", false, "07:00", "17:00", "2021-01-01"),
        WorkSchedules("Tuesday", false, "07:00", "17:00", "2021-01-01"),
        WorkSchedules("Wednesday", false, "07:00", "17:00", "2021-01-01"),
        WorkSchedules("Thursday", false, "07:00", "17:00", "2021-01-01"),
        WorkSchedules("Friday", false, "07:00", "17:00", "2021-01-01"),
    )
    val semanaTwo = listOf(
        WorkSchedules("Monday", false, "07:00", "17:00", "2021-01-01"),
        WorkSchedules("Tuesday", false, "08:00", "17:00", "2021-01-01"),
        WorkSchedules("Wednesday", false, "09:00", "17:00", "2021-01-01"),
        WorkSchedules("Thursday", false, "10:00", "17:00", "2021-01-01"),
        WorkSchedules("Friday", false, "11:00", "17:00", "2021-01-01"),
    )

    val listas = mutableListOf(semanaOne, semanaTwo)

    val details = CalculateFortnight.Builder(
        "REG-0001",
        personaA,
        "2021-01-01",
    ).addWorkSchedules(
        WorkSchedules("Monday", false, "07:00", "17:00", "2021-01-01"),
    ).build()

    println("El detalle del usuario: ${ personaB.fullName } es ${ details.getDetails() }")

}
