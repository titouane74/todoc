package com.cleanup.todoc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */

@Database(entities = {Project.class, Task.class}, version = 1 , exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    private static volatile TodocDatabase INSTANCE;

    public abstract ProjectDao mProjectDao();
    public abstract TaskDao mTaskDao();

    public static TodocDatabase getInstance(Context pContext) {
        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(pContext.getApplicationContext(),
                            TodocDatabase.class, "Todoc.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
