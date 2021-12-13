package settings

interface SettingsProvider {
    val settings: List<BaseSettings>
    fun start()
    fun stop()
}

inline fun <reified T> SettingsProvider.get(): T {
    return settings.filterIsInstance<T>().first()
}