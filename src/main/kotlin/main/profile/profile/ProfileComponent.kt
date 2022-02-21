package main.profile.profile

import core.Component
import core.NullableInteractor

interface ProfileComponent : Component {

    val signOut: NullableInteractor<Unit, Unit>

}