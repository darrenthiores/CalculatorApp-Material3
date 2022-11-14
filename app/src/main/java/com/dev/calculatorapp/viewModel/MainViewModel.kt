package com.dev.calculatorapp.viewModel

import androidx.lifecycle.ViewModel
import com.dev.calculatorapp.event.CalculatorAction
import com.dev.calculatorapp.event.CalculatorOperation
import com.dev.calculatorapp.state.CalculatorState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    fun onAction(action: CalculatorAction) {
        when(action) {
            CalculatorAction.Calculate -> performCalculation()
            CalculatorAction.Clear -> _state.value = CalculatorState()
            CalculatorAction.Decimal -> enterDecimal()
            CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }
    }

    private fun performDeletion() {
        when {
            state.value.number2.isNotBlank() -> _state.value = state.value.copy(
                number2 = state.value.number2.dropLast(1)
            )
            state.value.operation != null -> _state.value = state.value.copy(
                operation = null
            )
            state.value.number1.isNotBlank() -> _state.value = state.value.copy(
                number1 = state.value.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.value.number1.toDoubleOrNull()
        val number2 = state.value.number2.toDoubleOrNull()

        if(number1 != null && number2 != null) {
            val result = when(state.value.operation) {
                CalculatorOperation.Add -> number1 + number2
                CalculatorOperation.Divide -> number1 / number2
                CalculatorOperation.Multiply -> number1 * number2
                CalculatorOperation.Subtract -> number1 - number2
                null -> return
            }

            _state.value = state.value.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if(state.value.number1.isNotBlank()) {
            _state.value = state.value.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if(
            state.value.operation == null
            && !state.value.number1.contains(".")
            && state.value.number1.isNotBlank()
        ) {
            _state.value = state.value.copy(
                number1 = state.value.number1 + "."
            )
            return
        }

        if(
            !state.value.number2.contains(".")
            && state.value.number2.isNotBlank()
        ) {
            _state.value = state.value.copy(
                number2 = state.value.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.value.operation == null) {
            if(state.value.number1.length >= MAX_NUM_LENGTH) {
                return
            }

            _state.value = state.value.copy(
                number1 = state.value.number1 + number
            )
            return
        }

        if(state.value.number2.length >= MAX_NUM_LENGTH) {
            return
        }

        _state.value = state.value.copy(
            number2 = state.value.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}