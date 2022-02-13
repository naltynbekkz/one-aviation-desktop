package main.staff.salaries

import com.arkivanov.decompose.ComponentContext

class SalariesComponentImpl(
    componentContext: ComponentContext,
) : SalariesComponent, ComponentContext by componentContext