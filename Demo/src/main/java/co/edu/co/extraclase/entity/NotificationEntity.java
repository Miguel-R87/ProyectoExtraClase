package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class NotificationEntity  {
	
	private UUID id;
	private TaskUserEntity taskUser;
    private String message;
    private LocalDateTime triggerDate;
    private NotificationTypeEntity notificationType;
    
    public NotificationEntity() {
    	setId(UUIDHelper.getUUIDHelper().getDefault());
    	setTaskUser(TaskUserEntity.getDefault());
    	setMessage(TextHelper.getDefault());
    	setTriggerDate(DateTimeHelper.getDefault());
    	setNotificationType(NotificationTypeEntity.getDefault());
    }
    
    public NotificationEntity(final UUID id) {
		setId(id);
		setTaskUser(TaskUserEntity.getDefault());
		setMessage(TextHelper.getDefault());
		setTriggerDate(DateTimeHelper.getDefault());
		setNotificationType(NotificationTypeEntity.getDefault());
	}
    
    public  NotificationEntity(final UUID id, final TaskUserEntity taskUser, final String message, final LocalDateTime triggerDate, final NotificationTypeEntity notificationType) {
    	setId(id);
    	setTaskUser(taskUser);
    	setMessage(message);
    	setTriggerDate(triggerDate);
    	setNotificationType(notificationType);
    }
    
    static NotificationEntity getDefault() {
		return new NotificationEntity();
	}
    
    static NotificationEntity getDefault(final NotificationEntity notification) {
    	return ObjectHelper.getDefault(notification, getDefault());
    }

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public TaskUserEntity getTaskUser() {
		return taskUser;
	}

	public void setTaskUser(final TaskUserEntity taskUser) {
		this.taskUser = TaskUserEntity.getDefault(taskUser);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = TextHelper.getDefaultWithTrim(message);
	}

	public LocalDateTime getTriggerDate() {
		return triggerDate;
	}

	public void setTriggerDate(final LocalDateTime triggerDate) {
		this.triggerDate = DateTimeHelper.getDefault(triggerDate);
	}

	public NotificationTypeEntity getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(final NotificationTypeEntity notificationType) {
		this.notificationType = NotificationTypeEntity.getDefault(notificationType);
	}
}
