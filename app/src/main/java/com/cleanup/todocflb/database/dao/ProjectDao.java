package com.cleanup.todocflb.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cleanup.todocflb.model.Project;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
@Dao
public interface ProjectDao {

    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getProjects();

    @Insert
    void insertProject(Project... pProjects);
}
