package com.example.taskmanagerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanagerapp.ui.screens.TaskListScreen
import com.example.taskmanagerapp.ui.screens.AddEditTaskScreen
import com.example.taskmanagerapp.viewmodel.TaskViewModel
import com.example.taskmanagerapp.viewmodel.TaskViewModelFactory
import com.example.taskmanagerapp.ui.theme.TaskManagerAppTheme

class MainActivity : ComponentActivity() {

    private val taskViewModel: TaskViewModel by viewModels {
        TaskViewModelFactory((application as TaskManagerApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TaskManagerApp(taskViewModel)
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp(taskViewModel: TaskViewModel) {
    val tasks = taskViewModel.tasks
    var currentScreen by remember { mutableStateOf("taskList") }

    when (currentScreen) {
        "taskList" -> {
            TaskListScreen(
                tasks = tasks.map { it.title },
                onAddTaskClick = {
                    currentScreen = "addEditTask"
                },
                onTaskClick = { taskTitle ->
                    // Logica de editare task
                    currentScreen = "addEditTask"
                }
            )
        }
        "addEditTask" -> {
            AddEditTaskScreen(
                initialTask = "", // Poți pune o valoare preexistentă pentru editare
                onSaveClick = { taskTitle ->
                    taskViewModel.addTask(Task(title = taskTitle, description = ""))
                    currentScreen = "taskList"
                },
                onCancelClick = {
                    currentScreen = "taskList"
                }
            )
        }
    }
}
