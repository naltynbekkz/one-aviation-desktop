package main.client.notifications

import com.arkivanov.essenty.parcelable.Parcelable

sealed class NotificationsDestination : Parcelable {
    object Notifications : NotificationsDestination()
}