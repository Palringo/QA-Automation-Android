package com.palringo.qa_automation_android

data class ScreenState(
    val label: String,
    val onClickButton: () -> Unit
) {
    companion object {
        val EMPTY = ScreenState(
            label = "",
            onClickButton = {}
        )
    }
}