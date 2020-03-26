package com.cleanup.todocflb.database;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cleanup.todocflb.model.Project;
import com.cleanup.todocflb.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Florence LE BOURNOT on 14/03/2020
 */
@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {

    private TodocDatabase mTodocDatabase;

    private Project[] mListProjects = Project.getAllProjects();
    private List<Task> mTasks;
    private List<Project> mProjects;

    private Task mTaskDemo1 = new Task(mListProjects[0].getId(),"Test 1",new Date().getTime());
    private Task mTaskDemo2 = new Task(mListProjects[1].getId(),"Test 2",new Date().getTime());

    @Rule
    public InstantTaskExecutorRule mInstantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        mTodocDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                TodocDatabase.class)
                .allowMainThreadQueries()
                .build();
        mTodocDatabase.ProjectDao().insertProject(mListProjects);

        mTasks = LiveDataTestUtil.getValue(mTodocDatabase.TaskDao().getTasks());
        assertTrue(mTasks.isEmpty());

        mProjects = LiveDataTestUtil.getValue(mTodocDatabase.ProjectDao().getProjects());

    }

    @After
    public void closeDb() {
        mTodocDatabase.close();
    }

    @Test
    public void insertTasks() throws InterruptedException {
        mTodocDatabase.TaskDao().insertTask(mTaskDemo1);

        mTasks = LiveDataTestUtil.getValue(mTodocDatabase.TaskDao().getTasks());
        assertFalse(mTasks.isEmpty());
        assertEquals(1,mTasks.size());

        assertEquals(mTaskDemo1.getName(),mTasks.get(0).getName());
        assertEquals("Projet Tartampion", mTaskDemo1.getProject().getName());
        assertEquals(mProjects.get(0).getName(), mTaskDemo1.getProject().getName());

    }

    @Test
    public void deleteTasks() throws InterruptedException {
        mTodocDatabase.TaskDao().insertTask(mTaskDemo1);
        mTodocDatabase.TaskDao().insertTask(mTaskDemo2);

        mTasks = LiveDataTestUtil.getValue(mTodocDatabase.TaskDao().getTasks());
        assertFalse(mTasks.isEmpty());
        assertEquals(2,mTasks.size());

        assertEquals(mTaskDemo1.getName(),mTasks.get(0).getName());
        assertEquals(mTaskDemo2.getName(),mTasks.get(1).getName());
        assertEquals("Projet Tartampion", mTaskDemo1.getProject().getName());
        assertEquals(mProjects.get(0).getName(), mTaskDemo1.getProject().getName());
        assertEquals("Projet Lucidia", mTaskDemo2.getProject().getName());
        assertEquals(mProjects.get(1).getName(), mTaskDemo2.getProject().getName());

        mTodocDatabase.TaskDao().deleteTask(mTasks.get(0));
        mTasks = LiveDataTestUtil.getValue(mTodocDatabase.TaskDao().getTasks());
        assertEquals(1,mTasks.size());

        assertEquals(mTaskDemo2.getName(),mTasks.get(0).getName());
        assertEquals("Projet Lucidia", mTaskDemo2.getProject().getName());
        assertEquals(mProjects.get(1).getName(), mTaskDemo2.getProject().getName());

    }

}
