package org.ipc.synapsis.project.resource;

import org.springframework.http.ResponseEntity;


public interface IProjectResource {
    ResponseEntity add(String projectName);
    ResponseEntity update(String id, String projectName, String description);
    ResponseEntity get(String id);
    ResponseEntity getAll();
    ResponseEntity remove(String id);
}
