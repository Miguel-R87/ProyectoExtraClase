package co.edu.co.extraclase.business.domain;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;



public final class ListDomain extends Domain {
	private String name;
	private ProjectDomain project;
	private LocalDateTime creationDate;
	
	public ListDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setProject(ProjectDomain.getDefaultValue());
		setCreationDate(DateTimeHelper.getDefault());
		
	}
	
	public ListDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setProject(ProjectDomain.getDefaultValue());
		setCreationDate(DateTimeHelper.getDefault());
	}
	
	public ListDomain(final UUID id, final String name, final ProjectDomain project, final LocalDateTime creationDate) {
		super(id);
		setName(name);
		setProject(project);
		setCreationDate(creationDate);
	}

	static ListDomain getDefaultValue() {
		return new ListDomain();
	}

	static ListDomain getDefaultValue(final ListDomain list) {
		return ObjectHelper.getDefault(list, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public ProjectDomain getProject() {
		return project;
	}

	public void setProject(ProjectDomain project) {
		this.project = ProjectDomain.getDefaultValue(project);
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = DateTimeHelper.getDefault(creationDate);
	}

	
	}	

	




