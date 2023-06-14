package com.palringo.qa_automation_android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val INITIAL_STATE = ScreenState(
        label = "0",
        onClickButton = ::onButtonClick
    )

    private val _screenState = MutableStateFlow(INITIAL_STATE)
    val screenState = _screenState.asStateFlow()

    private fun onButtonClick() {
        _screenState.value = when (_screenState.value.label) {
            "0" -> "1"
            "1" -> "2"
            else -> "MAX"
        }.let { newLabel ->
            ScreenState(
                label = newLabel,
                onClickButton = ::onButtonClick
            )
        }
    }

}