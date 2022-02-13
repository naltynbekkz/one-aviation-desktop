package main.staff.workingHours

import com.arkivanov.essenty.parcelable.Parcelable

sealed class WorkingHoursDestination : Parcelable {
    object WorkingHours : WorkingHoursDestination()
}