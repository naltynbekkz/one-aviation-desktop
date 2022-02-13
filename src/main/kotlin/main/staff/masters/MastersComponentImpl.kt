package main.staff.masters

import com.arkivanov.decompose.ComponentContext

class MastersComponentImpl(
    componentContext: ComponentContext,
) : MastersComponent, ComponentContext by componentContext