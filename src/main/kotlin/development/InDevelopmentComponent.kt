package development

import com.arkivanov.decompose.ComponentContext

class InDevelopmentComponent(
    componentContext: ComponentContext,
) : InDevelopment, ComponentContext by componentContext