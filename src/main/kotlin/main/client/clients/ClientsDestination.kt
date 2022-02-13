package main.client.clients

import com.arkivanov.essenty.parcelable.Parcelable

sealed class ClientsDestination : Parcelable {
    object Clients : ClientsDestination()
}