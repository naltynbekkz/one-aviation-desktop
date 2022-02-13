package main.client.notifications

import com.arkivanov.decompose.ComponentContext

class NotificationsComponentImpl(
    componentContext: ComponentContext,
) : NotificationsComponent, ComponentContext by componentContext