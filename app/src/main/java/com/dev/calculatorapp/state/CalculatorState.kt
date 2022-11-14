package com.dev.calculatorapp.state

import com.dev.calculatorapp.event.CalculatorOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null
)
