package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectEntity extends Entity {
	
	private UUID projectId;
	private String name;
    private String description;
    private LocalDateTime creationDate;
    private ProjectStatusEntity projectStatus;
    
    public ProjectEntity() {
		setProjectId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		setProjectStatus(ProjectStatusEntity.getDefault());
	}
    
    public ProjectEntity(final UUID id) {
    	setProjectId(id);
    	setName(TextHelper.getDefault());
    	setDescription(TextHelper.getDefault());
    	setCreationDate(DateTimeHelper.getDefault());
    	setProjectStatus(ProjectStatusEntity.getDefault());
    }
    
    private  ProjectEntity(final UUID projectId, final String name, final String description, final LocalDateTime creationDate, final ProjectStatusEntity projectStatus) {
		setProjectId(projectId);
		setName(name);
		setDescription(description);
		setCreationDate(creationDate);
		setProjectStatus(projectStatus);
	}
    
    
    
    
    static ProjectEntity getDefault() {
    	return new ProjectEntity();
    }
    
    static ProjectEntity getDefault(final ProjectEntity project) {
		return ObjectHelper.getDefault(project, getDefault());
	}
    
    
    

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(final UUID projectId) {
		this.projectId = UUIDHelper.getUUIDHelper().getDefault(projectId);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = DateTimeHelper.getDefault(creationDate);
	}

	public ProjectStatusEntity getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(final ProjectStatusEntity projectStatus) {
		this.projectStatus = ProjectStatusEntity.getDefault(projectStatus);
	}
    

}
