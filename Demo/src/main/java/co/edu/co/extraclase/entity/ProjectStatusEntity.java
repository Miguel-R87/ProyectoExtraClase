package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectStatusEntity {
	
	private UUID projectStatusId;
	private String name;
	private String description;
	
	public ProjectStatusEntity() {
		setProjectStatusId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public ProjectStatusEntity(final UUID projectStatusId) {
		setProjectStatusId(projectStatusId);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	private  ProjectStatusEntity(UUID projectStatusId, String name, String description) {
		setProjectStatusId(projectStatusId);
		setName(name);
		setDescription(description);
	}
	
	static ProjectStatusEntity getDefault() {
		return new ProjectStatusEntity();
	}
	
	static ProjectStatusEntity getDefault(final ProjectStatusEntity projectStatus) {
		return ObjectHelper.getDefault(projectStatus, getDefault());
	}

	public UUID getProjectStatusId() {
		return projectStatusId;
	}

	public void setProjectStatusId(UUID projectStatusId) {
		this.projectStatusId = UUIDHelper.getUUIDHelper().getDefault(projectStatusId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}
	
}
