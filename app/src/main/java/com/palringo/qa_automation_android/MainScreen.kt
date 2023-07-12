package com.palringo.qa_automation_android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.palringo.qa_automation_android.ui.theme.QAAutomationAndroidTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object MainScreen {
    object TestTags {
        const val BUTTON = "tag_button"
        const val LABEL = "tag_label"
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun Screen(screenStateFlow: StateFlow<ScreenState>) {
        QAAutomationAndroidTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .semantics { testTagsAsResourceId = true },
            ) {
                ScreenContent(screenStateFlow)
            }
        }
    }

    @Composable
    private fun ScreenContent(
        screenStateFlow: StateFlow<ScreenState>, modifier: Modifier = Modifier
    ) {
        val state by screenStateFlow.collectAsState()

        Box(
            modifier = Modifier.then(modifier)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Button(
                    onClick = state.onClickButton,
                    modifier = Modifier.testTag(TestTags.BUTTON),
                ) {
                    Text(text = "Click me")
                }

                Text(
                    text = state.label,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.testTag(TestTags.LABEL),
                )
            }

        }


    }


}

@Preview
@Composable
private fun ContentPreview() {
    MainScreen.Screen(MutableStateFlow(ScreenState.EMPTY.copy(label = "0")))
}