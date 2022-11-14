package com.dev.calculatorapp.event

sealed class CalculatorOperation(
    val symbol: String
) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
}