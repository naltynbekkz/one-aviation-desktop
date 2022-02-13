package main.staff.salaries

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SalariesDestination : Parcelable {
    object Salaries : SalariesDestination()
}