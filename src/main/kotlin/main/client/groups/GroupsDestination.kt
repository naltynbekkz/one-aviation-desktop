package main.client.groups

import com.arkivanov.essenty.parcelable.Parcelable

sealed class GroupsDestination : Parcelable {
    object Groups : GroupsDestination()
}