package main.help.documentation

import com.arkivanov.decompose.ComponentContext

class DocumentationComponentImpl(
    componentContext: ComponentContext,
) : DocumentationComponent, ComponentContext by componentContext