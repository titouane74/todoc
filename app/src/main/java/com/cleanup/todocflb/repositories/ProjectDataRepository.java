package com.cleanup.todocflb.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todocflb.database.dao.ProjectDao;
import com.cleanup.todocflb.model.Project;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
public class ProjectDataRepository {

    private ProjectDao mProjectDao;

    public ProjectDataRepository(ProjectDao pProjectDao) { mProjectDao = pProjectDao; }

    public LiveData<List<Project>> getProjects() { return mProjectDao.getProjects(); }

}
