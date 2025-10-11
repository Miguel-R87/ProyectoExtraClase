package co.edu.co.extraclase.business.domain;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDomain extends Domain {
    private TaskUserDomain taskUser;
    private String message;
    private LocalDateTime triggerDate;
    private NotificationTypeDomain notificationType;

    public NotificationDomain(){
        super(UUIDHelper.getUUIDHelper().getDefault());
        setTaskUser(TaskUserDomain.getDefaultValue());
        setMessage(TextHelper.getDefault());
        setTriggerDate(DateTimeHelper.getDefault());
        setNotificationType(NotificationTypeDomain.getDefaultValue());
    }
    
    public NotificationDomain(final UUID id) {
		super(id);
		setTaskUser(TaskUserDomain.getDefaultValue());
		setMessage(TextHelper.getDefault());
		setTriggerDate(DateTimeHelper.getDefault());
		setNotificationType(NotificationTypeDomain.getDefaultValue());
	}

    public NotificationDomain(final UUID id, final TaskUserDomain taskUser,
                              final String message, final LocalDateTime triggerDate,
                              final NotificationTypeDomain notificationType) {
        super(id);
        setTaskUser(taskUser);
        setMessage(message);
        setTriggerDate(triggerDate);
        setNotificationType(notificationType);
    }

    public TaskUserDomain getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(TaskUserDomain taskUser) {
        this.taskUser = ObjectHelper.getDefault(taskUser, TaskUserDomain.getDefaultValue());
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

    public NotificationTypeDomain getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationTypeDomain notificationType) {
        this.notificationType = ObjectHelper.getDefault(notificationType, NotificationTypeDomain.getDefaultValue());
    }
}
