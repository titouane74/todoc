package com.cleanup.todocflb.repositories;

import androidx.lifecycle.LiveData;


import com.cleanup.todocflb.database.dao.TaskDao;
import com.cleanup.todocflb.model.Task;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
public class TaskDataRepository {

    private TaskDao  mTaskDao;

    public TaskDataRepository(TaskDao pTaskDao) { mTaskDao = pTaskDao; }

    public LiveData<List<Task>> getTasks() { return mTaskDao.getTasks(); }

    public void createTask(Task pTask) { mTaskDao.insertTask(pTask); }

    public void deleteTask(Task pTask) { mTaskDao.deleteTask(pTask); }
}
