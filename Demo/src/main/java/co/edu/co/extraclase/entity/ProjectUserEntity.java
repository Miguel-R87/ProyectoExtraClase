package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;


public final class ProjectUserEntity  {
	
	private UUID projectUserId;
	private UserEntity user;
    private ProjectEntity project;
    private boolean isAdmin;
    private LocalDateTime entryDate;
    private LocalDateTime expiryDate;
    
    public ProjectUserEntity() {
		setProjectUserId(UUIDHelper.getUUIDHelper().getDefault());
		setUser(UserEntity.getDefault());
		setProject(ProjectEntity.getDefault());
		setAdmin(BooleanHelper.getDefault());
		setEntryDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
    }
    
    public ProjectUserEntity(final UUID projectUserId) {
		setProjectUserId(projectUserId);
		setUser(UserEntity.getDefault());
		setProject(ProjectEntity.getDefault());
		setAdmin(BooleanHelper.getDefault());
		setEntryDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
    }
    
    public  ProjectUserEntity(final UUID projectUserId, final UserEntity user, final ProjectEntity project, final boolean isAdmin, final LocalDateTime entryDate, final LocalDateTime expiryDate) {
		setProjectUserId(projectUserId);
		setUser(user);
		setProject(project);
		setAdmin(isAdmin);
		setEntryDate(entryDate);
		setExpiryDate(expiryDate);
    }
    
    
    
    
    static ProjectUserEntity getDefault() {
		return new ProjectUserEntity();
	}
    
    static ProjectUserEntity getDefault(final ProjectUserEntity projectUser) {
    	return ObjectHelper.getDefault(projectUser, getDefault());
    }

    
    
    
	public UUID getProjectUserId() {
		return projectUserId;
	}

	public void setProjectUserId(UUID projectUserId) {
		this.projectUserId = UUIDHelper.getUUIDHelper().getDefault(projectUserId);
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = UserEntity.getDefault(user);
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = ProjectEntity.getDefault(project);
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = BooleanHelper.getDefault(isAdmin);
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = DateTimeHelper.getDefault(entryDate);
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = DateTimeHelper.getDefault(expiryDate);
	}

}
