package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;


public final class NotificationEntity {
	
	private UUID notificationId;
	private TaskUserEntity taskUser;
    private String message;
    private LocalDateTime triggerDate;
    private NotificationTypeEntity notificationType;
    
    
    public NotificationEntity() {
    	setNotificationId(UUIDHelper.getUUIDHelper().getDefault());
    	setTaskUser(TaskUserEntity.getDefault());
    	setMessage(TextHelper.getDefault());
    	setTriggerDate(DateTimeHelper.getDefault());
    	setNotificationType(NotificationTypeEntity.getDefault());
    }
    
    public NotificationEntity(final UUID notificationId) {
		setNotificationId(notificationId);
		setTaskUser(TaskUserEntity.getDefault());
		setMessage(TextHelper.getDefault());
		setTriggerDate(DateTimeHelper.getDefault());
		setNotificationType(NotificationTypeEntity.getDefault());
	}
    
    private  NotificationEntity(final UUID notificationId, final TaskUserEntity taskUser, final String message, final LocalDateTime triggerDate, final NotificationTypeEntity notificationType) {
    	setNotificationId(notificationId);
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

    
    
    
	public UUID getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(UUID notificationId) {
		this.notificationId = UUIDHelper.getUUIDHelper().getDefault(notificationId);
	}

	public TaskUserEntity getTaskUser() {
		return taskUser;
	}

	public void setTaskUser(TaskUserEntity taskUser) {
		this.taskUser = TaskUserEntity.getDefault(taskUser);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = TextHelper.getDefaultWithTrim(message);
	}

	public LocalDateTime getTriggerDate() {
		return triggerDate;
	}

	public void setTriggerDate(LocalDateTime triggerDate) {
		this.triggerDate = DateTimeHelper.getDefault(triggerDate);
	}

	public NotificationTypeEntity getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationTypeEntity notificationType) {
		this.notificationType = NotificationTypeEntity.getDefault(notificationType);
	}
    

}
