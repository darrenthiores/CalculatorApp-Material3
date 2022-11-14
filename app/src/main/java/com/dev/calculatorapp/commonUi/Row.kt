package com.dev.calculatorapp.commonUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.calculatorapp.commonUi.CalculatorButton
import com.dev.calculatorapp.event.CalculatorAction
import com.dev.calculatorapp.event.CalculatorOperation

@Composable
fun FirstRow(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiary)
                .aspectRatio(2f)
                .weight(2f),
            symbol = "AC"
        ) {
            onAction(CalculatorAction.Clear)
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseSurface)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "Del"
        ) {
            onAction(CalculatorAction.Delete)
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "/"
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
        }
    }
}

@Composable
fun SecondRow(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "7"
        ) {
            onAction(CalculatorAction.Number(7))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "8"
        ) {
            onAction(CalculatorAction.Number(8))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "9"
        ) {
            onAction(CalculatorAction.Number(9))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "x"
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
        }
    }
}

@Composable
fun ThirdRow(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "4"
        ) {
            onAction(CalculatorAction.Number(4))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "5"
        ) {
            onAction(CalculatorAction.Number(5))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "6"
        ) {
            onAction(CalculatorAction.Number(6))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "-"
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        }
    }
}

@Composable
fun FourthRow(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "1"
        ) {
            onAction(CalculatorAction.Number(1))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "2"
        ) {
            onAction(CalculatorAction.Number(2))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "3"
        ) {
            onAction(CalculatorAction.Number(3))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "+"
        ) {
            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        }
    }
}

@Composable
fun FifthRow(
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(2f)
                .weight(2f),
            symbol = "0"
        ) {
            onAction(CalculatorAction.Number(0))
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "."
        ) {
            onAction(CalculatorAction.Decimal)
        }

        CalculatorButton(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .aspectRatio(1f)
                .weight(1f),
            symbol = "="
        ) {
            onAction(CalculatorAction.Calculate)
        }
    }
}