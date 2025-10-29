package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;


public final class ListEntity  {
	
	private UUID id;
	private String name;
	private ProjectEntity project;
	private LocalDateTime creationDate;
	
	
	public ListEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setProject(ProjectEntity.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
	}
	
	public ListEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setProject(ProjectEntity.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
	}
	
	public  ListEntity(final UUID id, final String name, final ProjectEntity project, final LocalDateTime creationDate) {
		setId(id);
		setName(name);
		setProject(project);
		setCreationDate(creationDate);
	}
	
	
	
	static ListEntity getDefault() {
		return new ListEntity();
	}
	
	static ListEntity getDefault(final ListEntity list) {
		return ObjectHelper.getDefault(list, getDefault());
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

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = ProjectEntity.getDefault(project);
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = DateTimeHelper.getDefault(creationDate);
	}
	
}
