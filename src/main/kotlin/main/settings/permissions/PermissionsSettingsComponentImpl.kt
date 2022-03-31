package main.settings.permissions

import com.arkivanov.decompose.ComponentContext

class PermissionsSettingsComponentImpl(
    componentContext: ComponentContext,
) : PermissionsSettingsComponent, ComponentContext by componentContext