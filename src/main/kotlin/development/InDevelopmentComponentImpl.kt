package development

import com.arkivanov.decompose.ComponentContext

class InDevelopmentComponentImpl(
    componentContext: ComponentContext,
) : InDevelopmentComponent, ComponentContext by componentContext