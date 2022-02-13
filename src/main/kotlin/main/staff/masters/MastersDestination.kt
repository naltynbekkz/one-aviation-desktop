package main.staff.masters

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MastersDestination : Parcelable {
    object Masters : MastersDestination()
}