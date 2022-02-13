package main.help.documentation

import com.arkivanov.essenty.parcelable.Parcelable

sealed class DocumentationDestination : Parcelable {
    object Documentation : DocumentationDestination()
}