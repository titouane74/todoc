package com.cleanup.todocflb.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cleanup.todocflb.model.Task;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Insert
    long insertTask(Task pTask);

    @Delete
    int deleteTask(Task pTask);
}
