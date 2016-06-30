package org.ipc.synapsis.project.service.impl;
import java.util.Map;
import java.util.UUID;

import org.ipc.synapsis.project.bean.Project;
import org.ipc.synapsis.project.dao.IProjectRepository;
import org.ipc.synapsis.project.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProjectService implements IProjectService {

    @Autowired
    IProjectRepository projectRepository;
  
    public Project get(String id) {
    	Project project = projectRepository.findOne(UUID.fromString(id));
        return project;
    }

    public Iterable<Project> gelAll() {
        Iterable<Project> projectList = projectRepository.findAll();
        return projectList;
    }

    public UUID add(String name) {
    	Project project = new Project(name);
    	projectRepository.save(project);
    	return project.getId();
    }

    public void update(String id, String name, String description) {
    	Project project = projectRepository.findOne(UUID.fromString(id));
    	project.setName(name);
    	project.setDescription(description);
    	projectRepository.save(project);
    	
    }

    public void remove(String id) {
    	projectRepository.delete(UUID.fromString(id));

    }
}

