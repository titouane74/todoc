package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

/**
 * Created by Florence LE BOURNOT on 12/03/2020
 */
public class ProjectDataRepository {

    private ProjectDao mProjectDao;

    public void ProjectDataRepository(ProjectDao pProjectDao) { this.mProjectDao = pProjectDao; }

    public LiveData<List<Project>> getProjects(long pId) { return this.mProjectDao.getProjects(pId); }

}
