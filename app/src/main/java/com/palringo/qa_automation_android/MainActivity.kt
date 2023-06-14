package com.palringo.qa_automation_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenState = ScreenState(
            label = "0",
            onClickButton = {}
        )

        setContent {
            MainScreen.Screen(MutableStateFlow(screenState))
        }
    }

}