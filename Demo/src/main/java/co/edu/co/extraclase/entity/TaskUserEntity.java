package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class TaskUserEntity  {
	
	private UUID id;
	private ProjectUserEntity projectUser;
    private TaskEntity task;
    private LocalDateTime assignmentDate;
    private LocalDateTime completionDate;
    private boolean isCreator;
    private String comment;
    
    public TaskUserEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setProjectUser(ProjectUserEntity.getDefault());
		setTask(TaskEntity.getDefault());
		setAssignmentDate(DateTimeHelper.getDefault());
		setCompletionDate(DateTimeHelper.getDefault());
		setCreator(BooleanHelper.getDefault());
		setComment(TextHelper.getDefault());
    }
    
    public TaskUserEntity(final UUID id) {
    	setId(id);
    	setProjectUser(ProjectUserEntity.getDefault());
		setTask(TaskEntity.getDefault());
		setAssignmentDate(DateTimeHelper.getDefault());
		setCompletionDate(DateTimeHelper.getDefault());
		setCreator(BooleanHelper.getDefault());
		setComment(TextHelper.getDefault());
    }
    
    public  TaskUserEntity(final UUID id, final ProjectUserEntity projectUser, final TaskEntity task,
						   final LocalDateTime assignmentDate, final LocalDateTime completionDate, final boolean isCreator,
						   final String comment) {
		setId(id);
		setProjectUser(projectUser);
		setTask(task);
		setAssignmentDate(assignmentDate);
		setCompletionDate(completionDate);
		setCreator(isCreator);
		setComment(comment);
    }
    
    static TaskUserEntity getDefault() {
		return new TaskUserEntity();
    }
    
    static TaskUserEntity getDefault(final TaskUserEntity taskUser) {
		return ObjectHelper.getDefault(taskUser, getDefault());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public ProjectUserEntity getProjectUser() {
		return projectUser;
	}

	public void setProjectUser(ProjectUserEntity projectUser) {
		this.projectUser = ProjectUserEntity.getDefault(projectUser);
	}

	public TaskEntity getTask() {
		return task;
	}

	public void setTask(TaskEntity task) {
		this.task = TaskEntity.getDefault(task);
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

	public void setCreator(boolean isCreator) {
		this.isCreator = BooleanHelper.getDefault(isCreator);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = TextHelper.getDefaultWithTrim(comment);
	}
}
