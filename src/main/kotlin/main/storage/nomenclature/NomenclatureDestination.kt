package main.storage.nomenclature

import com.arkivanov.essenty.parcelable.Parcelable

sealed class NomenclatureDestination : Parcelable {
    object Nomenclature : NomenclatureDestination()
}