package main.service.technologyMaps

import com.arkivanov.decompose.ComponentContext

class TechnologyMapsComponentImpl(
    componentContext: ComponentContext,
) : TechnologyMapsComponent, ComponentContext by componentContext