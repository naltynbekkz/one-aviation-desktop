package core

import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.ChildAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.child.childAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.animation.page.PageArrangement

@OptIn(ExperimentalDecomposeApi::class)
fun <C : Any, T : Any> slideFade(): ChildAnimation<C, T> =
    childAnimation(animationSpec = spring()) { _, factor, arrangement, _, content ->
        content(
            Modifier
                .offset(
                    x = when (arrangement) {
                        PageArrangement.PREVIOUS -> maxWidth * (factor - 1F) * 0.2f
                        PageArrangement.FOLLOWING -> maxWidth * (1F - factor) * 0.2f
                    }
                )
                .alpha(factor)
        )
    }