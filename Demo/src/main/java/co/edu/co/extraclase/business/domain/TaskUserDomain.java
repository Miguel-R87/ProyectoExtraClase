package co.edu.co.extraclase.business.domain;

import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskUserDomain {
    private ProjectUserDomain projectUser;
    private TaskDomain task;
    private LocalDateTime assignmentDate;
    private LocalDateTime completionDate;
    private boolean isCreator;
    private String comment;

    public TaskUserDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProjectUser(ProjectUserDomain.getDefaultValue());
        setTask(TaskDomain.

    }

    static TaskUserDomain getDefaultValue() {
        return new TaskUserDomain();
    }

    static TaskUserDomain getDefaultValue(final TaskUserDomain taskuser) {
        return ObjectHelper.getDefault(taskuser, getDefaultValue());
    }

    public ProjectUserDomain getProjectUser() {
        return projectUser;
    }

    public void setProjectUser(ProjectUserDomain projectUser) {
        this.projectUser = projectUser;
    }

    public TaskDomain getTask() {
        return task;
    }

    public void setTask(TaskDomain task) {
        this.task = task;
    }

    public LocalDateTime getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(LocalDateTime assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}




