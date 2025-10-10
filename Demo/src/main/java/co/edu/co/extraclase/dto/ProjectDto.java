package co.edu.co.extraclase.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectDto {
	
	private UUID id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
	private ProjectStatusDto projectStatus;
	
	public ProjectDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		setProjectStatus(ProjectStatusDto.getDefaultValue());
	}
	
	public ProjectDto(final UUID id, final String name, final String description, final LocalDateTime creationDate, final ProjectStatusDto projectStatus) {
		setId(id);
		setName(name);
		setDescription(description);
		setCreationDate(creationDate);
		setProjectStatus(projectStatus);
	}
	
	public static ProjectDto getDefaultValue() {
		return new ProjectDto();
	}
	
	public static ProjectDto getDefaultValue(final ProjectDto project) {
		return ObjectHelper.getDefault(project, getDefaultValue());
	}
	

	
	public UUID getId() {
		return id;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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
	
	public ProjectStatusDto getProjectStatus() {
		return projectStatus;
	}
	
	public void setProjectStatus(final ProjectStatusDto projectStatus) {
		this.projectStatus = ObjectHelper.getDefault(projectStatus, ProjectStatusDto.getDefaultValue());
	}
}
