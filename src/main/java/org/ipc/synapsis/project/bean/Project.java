package org.ipc.synapsis.project.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(value = "Project", description = "POJO for Projet")
public class Project {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @ApiModelProperty(value = "Project identifier")
    private UUID id;

    @Column
    @ApiModelProperty(value = "Project name")
    private String name;
    
    @Column
    @ApiModelProperty(value = "Project description")
    private String description;
    
    
    @ElementCollection
    @CollectionTable(name = "Participant", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "idParticipant")
    @Column(name = "roleParticipant", length = 100)
    private Map<UUID, String> participantMap;
    

    @ElementCollection
    @CollectionTable(name = "Technology", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "idTechnology")
    @Column(name = "descriptionTechnology", length = 100)
    private Map<UUID, String> technologyMap;
    
    
    @ElementCollection
    @CollectionTable(name = "Chronology", joinColumns = @JoinColumn(name = "id"))
    @MapKeyColumn(name = "idChronology")
    @Column(name = "descriptionChronology", length = 100)
    private Map<UUID, String> chronologyMap;
    
   
    public Project() {

    }
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<UUID, String> getParticipantMap() {
		return participantMap;
	}

	public void setParticipantMap(Map<UUID, String> participantMap) {
		this.participantMap = participantMap;
	}
   
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Map<UUID, String> getTechnologyMap() {
		return technologyMap;
	}

	public void setTechnologyMap(Map<UUID, String> technologyMap) {
		this.technologyMap = technologyMap;
	}

	public Map<UUID, String> getChronologyMap() {
		return chronologyMap;
	}

	public void setChronologyMap(Map<UUID, String> chronologyMap) {
		this.chronologyMap = chronologyMap;
	}

	public Project(String name) {
		this.participantMap = new HashMap<UUID, String>();
    	this.setId(UUID.randomUUID());
        this.setName(name);
    }
    
}
