package main.client.smsMailing

import com.arkivanov.essenty.parcelable.Parcelable

sealed class SmsMailingDestination : Parcelable {
    object SmsMailing : SmsMailingDestination()
}