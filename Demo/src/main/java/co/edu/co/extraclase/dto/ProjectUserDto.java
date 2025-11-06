package co.edu.co.extraclase.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectUserDto {
    
    private UUID id;
    private UserDto user;
    private ProjectDto project;
    private boolean isAdmin;
    private LocalDateTime entryDate;
    private LocalDateTime expiryDate;

    public ProjectUserDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setUser(UserDto.getDefaultValue());
        setProject(ProjectDto.getDefaultValue());
        setAdmin(BooleanHelper.getDefault());
        setEntryDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());
    }

    public ProjectUserDto(UUID id) {
        setId(id);
        setUser(UserDto.getDefaultValue());
        setProject(ProjectDto.getDefaultValue());
        setAdmin(BooleanHelper.getDefault());
        setEntryDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());
    }

    public ProjectUserDto(final UUID id, final UserDto user, final ProjectDto project, 
                          final boolean isAdmin, final LocalDateTime entryDate, final LocalDateTime expiryDate) {
        setId(id);
        setUser(user);
        setProject(project);
        setAdmin(isAdmin);
        setEntryDate(entryDate);
        setExpiryDate(expiryDate);
    }

    public static ProjectUserDto getDefaultValue() {
        return new ProjectUserDto();
    }

    public static ProjectUserDto getDefaultValue(final ProjectUserDto projectUser) {
        return ObjectHelper.getDefault(projectUser, getDefaultValue());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(final UserDto user) {
        this.user = ObjectHelper.getDefault(user, UserDto.getDefaultValue());
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(final ProjectDto project) {
        this.project = ObjectHelper.getDefault(project, ProjectDto.getDefaultValue());
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(final boolean admin) {
        this.isAdmin = BooleanHelper.getDefault(admin);
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(final LocalDateTime entryDate) {
        this.entryDate = DateTimeHelper.getDefault(entryDate);
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(final LocalDateTime expiryDate) {
        this.expiryDate = DateTimeHelper.getDefault(expiryDate);
    }
}
