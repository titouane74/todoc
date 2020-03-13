package com.cleanup.todoc.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */

@Database(entities = {Project.class, Task.class}, version = 1 , exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    private static TodocDatabase INSTANCE;

    public abstract ProjectDao ProjectDao();
    public abstract TaskDao TaskDao();

    public static TodocDatabase getInstance(Context pContext) {
        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(pContext.getApplicationContext(),
                            TodocDatabase.class, "Todoc.db")
                            .addCallback(roomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new PopulateDbAsyncTask(INSTANCE).execute();
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private ProjectDao  lProjectDao;

        private PopulateDbAsyncTask(TodocDatabase db) {
            lProjectDao = db.ProjectDao();
        }

        @Override
        protected Void doInBackground(Void... pVoids) {
            Project[] projects = Project.getAllProjects();
            for (Project project : projects) {
                lProjectDao.insertProject(project);
            }
            return null;
        }
    }
}
