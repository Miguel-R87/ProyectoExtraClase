package co.edu.co.extraclase.dto;

import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import java.time.LocalDateTime;
import java.util.UUID;

public final class TaskUserDto {
    private UUID id;
    private ProjectUserDto projectUser;
    private TaskDto task;
    private LocalDateTime assignmentDate;
    private LocalDateTime completionDate;
    private boolean isCreator;
    private String comment;

  
    public TaskUserDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setProjectUser(ProjectUserDto.getDefaultValue());
        setTask(TaskDto.getDefaultValue());
        setAssignmentDate(DateTimeHelper.getDefault());
        setCompletionDate(DateTimeHelper.getDefault());
        setCreator(BooleanHelper.getDefault());
        setComment(TextHelper.getDefault());
    }

 
    public TaskUserDto(final UUID id, final ProjectUserDto projectUser, final TaskDto task,
                       final LocalDateTime assignmentDate, final LocalDateTime completionDate,
                       final boolean isCreator, final String comment) {
        setId(id);
        setProjectUser(projectUser);
        setTask(task);
        setAssignmentDate(assignmentDate);
        setCompletionDate(completionDate);
        setCreator(isCreator);
        setComment(comment);
    }

    public TaskUserDto(UUID id) {
        setId(id);
        setProjectUser(ProjectUserDto.getDefaultValue());
        setTask(TaskDto.getDefaultValue());
        setAssignmentDate(DateTimeHelper.getDefault());
        setCompletionDate(DateTimeHelper.getDefault());
        setCreator(BooleanHelper.getDefault());
        setComment(TextHelper.getDefault());
    }


    public static TaskUserDto getDefaultValue() {
        return new TaskUserDto();
    }

    public static TaskUserDto getDefaultValue(final TaskUserDto dto) {
        return ObjectHelper.getDefault(dto, getDefaultValue());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public ProjectUserDto getProjectUser() {
        return projectUser;
    }

    public void setProjectUser(final ProjectUserDto projectUser) {
        this.projectUser = ObjectHelper.getDefault(projectUser, ProjectUserDto.getDefaultValue());
    }

    public TaskDto getTask() {
        return task;
    }

    public void setTask(final TaskDto task) {
        this.task = ObjectHelper.getDefault(task, TaskDto.getDefaultValue());
    }

    public LocalDateTime getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(final LocalDateTime assignmentDate) {
        this.assignmentDate = DateTimeHelper.getDefault(assignmentDate);
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(final LocalDateTime completionDate) {
        this.completionDate = DateTimeHelper.getDefault(completionDate);
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(final boolean creator) {
        this.isCreator = BooleanHelper.getDefault(creator);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = TextHelper.getDefaultWithTrim(comment);
    }
}
