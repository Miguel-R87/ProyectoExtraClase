package co.edu.co.extraclase.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ListDto {
	
	private UUID id;
	private String name;
	private ProjectDto project;
	private LocalDateTime creationDate;
	
	public ListDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setProject(ProjectDto.getDefaultValue());
		setCreationDate(DateTimeHelper.getDefault());
	}

	public ListDto( UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setProject(ProjectDto.getDefaultValue());
		setCreationDate(DateTimeHelper.getDefault());
	}
	
	public ListDto(final UUID id, final String name, final ProjectDto project, final LocalDateTime creationDate) {
		setId(id);
		setName(name);
		setProject(project);
		setCreationDate(creationDate);
	}

    public static ListDto getDefaultValue() {
		return new ListDto();
	}
	
	public static ListDto getDefaultValue(final ListDto list) {
		return ObjectHelper.getDefault(list, getDefaultValue());
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

	public ProjectDto getProject() {
		return project;
	}

	public void setProject(final ProjectDto project) {
		this.project = ObjectHelper.getDefault(project, ProjectDto.getDefaultValue());
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = DateTimeHelper.getDefault(creationDate);
	}
}
