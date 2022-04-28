package com.mightyhedgehog.doplanner.domain.usecase.task

import com.mightyhedgehog.doplanner.data.local.json.task.TaskStorage
import com.mightyhedgehog.doplanner.data.mapper.task.toJsonTask
import com.mightyhedgehog.doplanner.data.mapper.task.toTask
import com.mightyhedgehog.doplanner.domain.model.task.Task
import com.mightyhedgehog.doplanner.ext.findAndRemove
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(
    private val taskStorage: TaskStorage
) {
    suspend fun execute(task: Task) {
        val jsonTask = task.toJsonTask()
        val currentStorageList = taskStorage.get()
        val newList = currentStorageList.toMutableList().findAndRemove(jsonTask)
        taskStorage.update(newList)
    }
}
