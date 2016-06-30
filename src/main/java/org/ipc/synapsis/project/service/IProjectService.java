package org.ipc.synapsis.project.service;

import java.util.UUID;

import org.ipc.synapsis.project.bean.Project;


public interface IProjectService {
    Project get(String id);
    Iterable<Project> gelAll();
    UUID add(String name);
    void update(String id, String name, String description);
    void remove(String id);
    
}
