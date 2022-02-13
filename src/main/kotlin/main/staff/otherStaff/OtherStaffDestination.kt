package main.staff.otherStaff

import com.arkivanov.essenty.parcelable.Parcelable

sealed class OtherStaffDestination : Parcelable {
    object OtherStaff : OtherStaffDestination()
}