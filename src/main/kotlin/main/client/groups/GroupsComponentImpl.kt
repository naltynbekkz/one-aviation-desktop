package main.client.groups

import com.arkivanov.decompose.ComponentContext

class GroupsComponentImpl(
    componentContext: ComponentContext,
) : GroupsComponent, ComponentContext by componentContext