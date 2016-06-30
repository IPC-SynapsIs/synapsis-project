package org.ipc.synapsis.project.dao;

import org.ipc.synapsis.project.bean.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface IProjectRepository extends CrudRepository<Project, UUID> {}