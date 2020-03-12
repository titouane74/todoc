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

    public void TaskDataRepository(TaskDao pTaskDao) { this.mTaskDao = pTaskDao; }

    public LiveData<List<Task>> getTask(long pId) { return this.mTaskDao.getTask(pId); }

    public void createTask(Task pTask) { mTaskDao.insertTask(pTask); }

    public void updateTask(Task pTask) { mTaskDao.updateTask(pTask); }

    public void deleteTask(long pId) { mTaskDao.deleteTask(pId); }
}
