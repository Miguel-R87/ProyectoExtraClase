package co.edu.co.extraclase.business.domain;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectDomain extends Domain {
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private ProjectStatusDomain projectstatus;

    public ProjectDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setCreationDate(DateTimeHelper.getDefault());
        setProjectStatus(ProjectStatusDomain.getDefaultValue());
    }
    
    public ProjectDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		setProjectStatus(ProjectStatusDomain.getDefaultValue());
	}

    public ProjectDomain(final UUID id, final String name, final String description, final LocalDateTime creationDate, 
    	final ProjectStatusDomain projectstatus) {
        super(id);
        setName(name);
        setDescription(description);
        setCreationDate(creationDate);
        setProjectStatus(projectstatus);
    }

    public static ProjectDomain getDefaultValue() {
        return new ProjectDomain(); 
    }
    
    static ProjectDomain getDefaultValue(final ProjectDomain project) {
        return ObjectHelper.getDefault(project, getDefaultValue());
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = DateTimeHelper.getDefault(creationDate);
    }

    public ProjectStatusDomain getProjectstatus() {
        return projectstatus;
    }

    public void setProjectStatus(ProjectStatusDomain projectstatus) {
        this.projectstatus = ObjectHelper.getDefault(projectstatus, ProjectStatusDomain.getDefaultValue());
    }

}