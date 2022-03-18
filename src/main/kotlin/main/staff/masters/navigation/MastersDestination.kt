package main.staff.masters.navigation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class MastersDestination : Parcelable {
    object Masters : MastersDestination()
    data class Master(val id: Long): MastersDestination()
    object AddMaster: MastersDestination()
}