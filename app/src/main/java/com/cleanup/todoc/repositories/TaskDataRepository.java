package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;


import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

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
