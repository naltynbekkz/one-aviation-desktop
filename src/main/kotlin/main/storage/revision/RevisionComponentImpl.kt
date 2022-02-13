package main.storage.revision

import com.arkivanov.decompose.ComponentContext

class RevisionComponentImpl(
    componentContext: ComponentContext,
) : RevisionComponent, ComponentContext by componentContext