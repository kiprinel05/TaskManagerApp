package com.example.taskmanagerapp.viewmodel

import com.example.taskmanagerapp.data.Task
import com.example.taskmanagerapp.data.TaskDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun getAllTasks() = withContext(Dispatchers.IO) { taskDao.getAllTasks() }

    suspend fun insertTask(task: Task) = withContext(Dispatchers.IO) { taskDao.insertTask(task) }

    suspend fun updateTask(task: Task) = withContext(Dispatchers.IO) { taskDao.updateTask(task) }

    suspend fun deleteTask(task: Task) = withContext(Dispatchers.IO) { taskDao.deleteTask(task) }
}
