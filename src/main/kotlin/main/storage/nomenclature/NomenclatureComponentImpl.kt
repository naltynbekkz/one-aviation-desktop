package main.storage.nomenclature

import com.arkivanov.decompose.ComponentContext

class NomenclatureComponentImpl(
    componentContext: ComponentContext,
) : NomenclatureComponent, ComponentContext by componentContext