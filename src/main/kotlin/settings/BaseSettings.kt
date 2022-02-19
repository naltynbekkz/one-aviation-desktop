package settings

import java.util.prefs.PreferenceChangeListener
import java.util.prefs.Preferences

abstract class BaseSettings(
    val preferences: Preferences
) {

    abstract val listener: PreferenceChangeListener

    fun get(key: String) = preferences.get(key, null)

    fun set(key: String, value: String?) {
        if (value == null) {
            preferences.remove(key)
        } else {
            preferences.put(key, value)
        }
        preferences.flush()
    }

}