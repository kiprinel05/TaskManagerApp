package com.example.taskmanagerapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddEditTaskScreen(
    initialTask: String = "",
    onSaveClick: (String) -> Unit,
    onCancelClick: () -> Unit
) {
    var text by remember { mutableStateOf(TextFieldValue(initialTask)) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Add/Edit Task") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Task Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(
                    onClick = { onSaveClick(text.text) },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("Save")
                }

                OutlinedButton(onClick = onCancelClick) {
                    Text("Cancel")
                }
            }
        }
    }
}
