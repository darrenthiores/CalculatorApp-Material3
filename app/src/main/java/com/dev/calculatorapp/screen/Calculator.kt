package com.dev.calculatorapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.calculatorapp.commonUi.*
import com.dev.calculatorapp.viewModel.MainViewModel

@Composable
fun Calculator(
    viewModel: MainViewModel = viewModel(),
    buttonSpacing: Dp = 8.dp
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Light,
                fontSize = 64.sp,
                lineHeight = 64.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            FirstRow(
                onAction = viewModel::onAction
            )

            SecondRow(
                onAction = viewModel::onAction
            )

            ThirdRow(
                onAction = viewModel::onAction
            )

            FourthRow(
                onAction = viewModel::onAction
            )

            FifthRow(
                onAction = viewModel::onAction
            )
        }
    }
}