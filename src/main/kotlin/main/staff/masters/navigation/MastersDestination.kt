package main.staff.masters.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MastersDestination : Parcelable {
    object Masters : MastersDestination()

    object AddMaster: MastersDestination()
}