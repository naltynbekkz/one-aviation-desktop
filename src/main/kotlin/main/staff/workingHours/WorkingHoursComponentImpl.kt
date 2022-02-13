package main.staff.workingHours

import com.arkivanov.decompose.ComponentContext

class WorkingHoursComponentImpl(
    componentContext: ComponentContext,
) : WorkingHoursComponent, ComponentContext by componentContext