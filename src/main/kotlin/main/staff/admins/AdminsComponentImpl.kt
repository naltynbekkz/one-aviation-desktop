package main.staff.admins

import com.arkivanov.decompose.ComponentContext

class AdminsComponentImpl(
    componentContext: ComponentContext,
) : AdminsComponent, ComponentContext by componentContext