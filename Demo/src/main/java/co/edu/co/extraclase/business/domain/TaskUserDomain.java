package co.edu.co.extraclase.business.domain;

import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskUserDomain extends Domain{
    private ProjectUserDomain projectUser;
    private TaskDomain task;
    private LocalDateTime assignmentDate;
    private LocalDateTime completionDate;
    private boolean isCreator;
    private String comment;

    public TaskUserDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setProjectUser(ProjectUserDomain.getDefaultValue());
        setTask(TaskDomain.getDefaultValue());
        setAssignmentDate(DateTimeHelper.getDefault());
        setCompletionDate(DateTimeHelper.getDefault());
        setCreator(BooleanHelper.getDefault());
        setComment(TextHelper.getDefault());
        

    }
    public TaskUserDomain(final UUID id, final ProjectUserDomain projectUser, final TaskDomain task, final LocalDateTime assignmentDate, final LocalDateTime completionDate, final boolean isCreator, final String comment) {
		super(id);
		setProjectUser(projectUser);
		setTask(task);
		setAssignmentDate(assignmentDate);
		setCompletionDate(completionDate);
		setCreator(isCreator);
		setComment(comment);
	}

    public static TaskUserDomain getDefaultValue() {
        return new TaskUserDomain();
    }

    static TaskUserDomain getDefaultValue(final TaskUserDomain taskuser) {
        return ObjectHelper.getDefault(taskuser, getDefaultValue());
    }

    public ProjectUserDomain getProjectUser() {
        return projectUser;
    }

    public void setProjectUser(ProjectUserDomain projectUser) {
        this.projectUser = ObjectHelper.getDefault(projectUser, ProjectUserDomain.getDefaultValue());
    }

    public TaskDomain getTask() {
        return task;
    }

    public void setTask(TaskDomain task) {
        this.task = ObjectHelper.getDefault(task, TaskDomain.getDefaultValue());
    }

    public LocalDateTime getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(LocalDateTime assignmentDate) {
        this.assignmentDate = DateTimeHelper.getDefault(assignmentDate);
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = DateTimeHelper.getDefault(completionDate);
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = BooleanHelper.getDefault(creator);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = TextHelper.getDefaultWithTrim(comment);
    }
}




