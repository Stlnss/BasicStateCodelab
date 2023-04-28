package com.still.basicstatecodelab;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.still.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StateFullCounter()
        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onChangedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) },
            onCloseTask = { task -> wellnessViewModel.remove(task) })
    }
}


@Preview
@Composable
fun WellnessScreenPreview() {
    BasicStateCodelabTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            WellnessScreen()
        }
    }
}