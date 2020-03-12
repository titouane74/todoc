package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
@Dao
public interface ProjectDao {

    @Query("SELECT * FROM Project WHERE id = :id")
    LiveData<List<Project>> getProjects(long id);

}
