package core

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

private const val JOB_KEY = "CoroutineScope.JOB_KEY"

val ComponentContext.scope: CoroutineScope
    get() = instanceKeeper.get(JOB_KEY) as CloseableCoroutineScope?
        ?: CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
            .also { instanceKeeper.put(JOB_KEY, it) }

internal class CloseableCoroutineScope(context: CoroutineContext) : InstanceKeeper.Instance, CoroutineScope {
    override val coroutineContext: CoroutineContext = context

    override fun onDestroy() {
        coroutineContext.cancel()
    }
}