package com.cleanup.todoc.injection;

import android.content.Context;

import com.cleanup.todoc.database.TodocDatabase;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Florence LE BOURNOT on 13/03/2020
 */
public class Injection {

    public static ProjectDataRepository provideProjectDataSource(Context context) {
        TodocDatabase database = TodocDatabase.getInstance(context);
        return new ProjectDataRepository(database.ProjectDao());
    }

    public static TaskDataRepository provideTaskDataSource(Context context) {
        TodocDatabase database = TodocDatabase.getInstance(context);
        return new TaskDataRepository(database.TaskDao());
    }

    public static Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        ProjectDataRepository projectDataSource = provideProjectDataSource(context);
        TaskDataRepository taskDataSource = provideTaskDataSource(context);
        Executor executor = provideExecutor();
        return new ViewModelFactory(projectDataSource, taskDataSource, executor);
    }
}
