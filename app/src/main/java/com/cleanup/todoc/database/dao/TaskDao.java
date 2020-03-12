package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task WHERE id = :id")
    LiveData<List<Task>> getTask(long id);

    @Insert
    long insertTask(Task pTask);

    @Update
    int updateTask(Task pTask);

    @Query("DELETE FROM Task WHERE id = :id")
    int deleteTask(long id);

}
