package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectStatusEntity  {
	
	private UUID id;
	private String name;
	private String description;
	
	public ProjectStatusEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public ProjectStatusEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public  ProjectStatusEntity(UUID id, String name, String description) {
		setId(id);
		setName(name);
		setDescription(description);
	}
	
	static ProjectStatusEntity getDefault() {
		return new ProjectStatusEntity();
	}
	
	static ProjectStatusEntity getDefault(final ProjectStatusEntity projectStatus) {
		return ObjectHelper.getDefault(projectStatus, getDefault());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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
