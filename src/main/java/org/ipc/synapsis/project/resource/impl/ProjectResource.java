package org.ipc.synapsis.project.resource.impl;

import io.swagger.annotations.*;

import org.ipc.synapsis.project.bean.Project;
import org.ipc.synapsis.project.resource.IProjectResource;
import org.ipc.synapsis.project.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;






import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/project")
@Api( value = "Project API")
public class ProjectResource implements IProjectResource{

	
	  @Autowired
	  IProjectService projectService;

	  @Autowired
	  Environment env;
	    
	    
	  @RequestMapping(
			  value = "/{id}",
			  method = RequestMethod.GET,
			  produces = MediaType.APPLICATION_JSON_VALUE )
	  @ApiOperation(value = "Find a project by ID")
	  @ApiResponses(value = { 
			  @ApiResponse(code = 200, message = "Project Found", response = Project.class),
	          @ApiResponse(code = 404, message = "Project not found", response = void.class)})
	    public ResponseEntity get(
	    		@ApiParam(value = "Project ID", required = true) @PathVariable("id") String id) {
	        Project project = projectService.get(id);
	        return (project==null) ? ResponseEntity.noContent().build() : ResponseEntity.ok(project);
	    }

	    @RequestMapping(
	    		method = RequestMethod.GET,
	            produces = MediaType.APPLICATION_JSON_VALUE )
	    @ApiOperation(value = "Return Projects list")
	    @ApiResponses(value = { 
	    		@ApiResponse(code = 200, message = "Return Projects List", response = Iterable.class)})
	    public ResponseEntity getAll() {
	        Iterable<Project> projectList = projectService.gelAll();
	        return ResponseEntity.ok(projectList);
	    }

	    @RequestMapping(
	    		method = RequestMethod.POST,
	    		consumes = MediaType.APPLICATION_JSON_VALUE,
	    		produces = MediaType.APPLICATION_JSON_VALUE )
	    @ApiOperation(value = "Add a new Project")
	    @ApiResponses(value = { 
	    		@ApiResponse(code = 201, message = "Project created : Done", response = URI.class)})
	    public ResponseEntity add(
	    		@RequestParam(value = "Project Name", required = true) String projectName) {
	        UUID projectUUID = projectService.add(projectName);
	        return ResponseEntity.created(URI.create("/project/"+projectUUID)).build();
	    }


	    @RequestMapping(
	    		value = "/{id}",
	    		method = RequestMethod.PUT,
	            consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE )
	    @ApiOperation(value = "Update an existant project")
	    @ApiResponses(value = { 
	    		@ApiResponse(code = 201, message = "Project updated : Done", response = void.class)})
	    public ResponseEntity update(
	    		@ApiParam(value = "Project ID", required = true) @PathVariable("id") String id,
	    		@RequestParam(value = "Project Name", required = true) String projectName,
	    		@RequestBody(required = false) String description) {
			projectService.update(id, projectName, description);
	        return ResponseEntity.ok().build();
	    }


	    @RequestMapping(
	    		value = "/{id}",
	    		method = RequestMethod.DELETE,
	    		produces = MediaType.APPLICATION_JSON_VALUE )
	    @ApiOperation(value = "Delete a project")
	    @ApiResponses(value = { @ApiResponse(code = 200, message = "Project Deleted : Done", response = void.class)})
	    public ResponseEntity remove(@ApiParam(value = "Project ID", required = true) @PathVariable("id") String id) {
	        projectService.remove(id);
	        return ResponseEntity.ok().build();
	    }


}
