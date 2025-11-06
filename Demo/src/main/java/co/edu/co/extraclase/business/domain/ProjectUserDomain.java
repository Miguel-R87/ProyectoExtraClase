package co.edu.co.extraclase.business.domain;

import co.edu.co.extraclase.crosscuting.helper.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectUserDomain extends Domain{
    private UserDomain user;
    private ProjectDomain project;
    private boolean isAdmin;
    private LocalDateTime entryDate;
    private LocalDateTime expiryDate;

    public ProjectUserDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setUser(UserDomain.getDefaultValue());
        setProject(ProjectDomain.getDefaultValue());
        setAdmin(BooleanHelper.getDefault());
        setEntryDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());
    }
    
    public ProjectUserDomain(final UUID id) {
		super(id);
		setUser(UserDomain.getDefaultValue());
		setProject(ProjectDomain.getDefaultValue());
		setAdmin(BooleanHelper.getDefault());
		setEntryDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
    }

    public ProjectUserDomain(final UUID id, final UserDomain user , final ProjectDomain project , final boolean isAdmin,
                             final LocalDateTime entryDate, final LocalDateTime expiryDate) {
        super(id);
        setUser(user);
        setProject(project);
        setAdmin(isAdmin);
        setEntryDate(entryDate);
        setExpiryDate(expiryDate);
    }

    static ProjectUserDomain getDefaultValue() {
        return new ProjectUserDomain();
    }

    static ProjectUserDomain getDefaultValue(final ProjectUserDomain projectuser) {
        return ObjectHelper.getDefault(projectuser, getDefaultValue());
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = ObjectHelper.getDefault(user,UserDomain.getDefaultValue());
    }

    public ProjectDomain getProject() {
        return project;
    }

    public void setProject(ProjectDomain project) {
        this.project = ObjectHelper.getDefault(project,ProjectDomain.getDefaultValue());
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = BooleanHelper.getDefault(admin);
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
