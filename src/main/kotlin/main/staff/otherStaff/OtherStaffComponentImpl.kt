package main.staff.otherStaff

import com.arkivanov.decompose.ComponentContext

class OtherStaffComponentImpl(
    componentContext: ComponentContext,
) : OtherStaffComponent, ComponentContext by componentContext