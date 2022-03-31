package core

class NavigationResult(
    private var consumed: Boolean = false
) {
    fun isConsumed(): Boolean {
        return if (consumed) {
            true
        } else {
            consumed = true
            false
        }
    }
}

fun NavigationResult?.isNotConsumed(): Boolean {
    return this?.isConsumed() ?: false
}