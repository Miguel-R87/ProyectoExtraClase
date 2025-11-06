package co.edu.co.extraclase.dto;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import java.time.LocalDateTime;
import java.util.UUID;

public final class NotificationDto {
    
	private UUID id;
    private TaskUserDto taskUser;
    private String message;
    private LocalDateTime triggerDate;
    private NotificationTypeDto notificationType;

    public NotificationDto(){
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setTaskUser(TaskUserDto.getDefaultValue());
        setMessage(TextHelper.getDefault());
        setTriggerDate(DateTimeHelper.getDefault());
        setNotificationType(NotificationTypeDto.getDefault());
    }

    public NotificationDto(final UUID id){
        setId(id);
        setTaskUser(TaskUserDto.getDefaultValue());
        setMessage(TextHelper.getDefault());
        setTriggerDate(DateTimeHelper.getDefault());
        setNotificationType(NotificationTypeDto.getDefault());
    }

    public NotificationDto(final UUID id, final TaskUserDto taskUser, final String message, final LocalDateTime triggerDate,
                           final NotificationTypeDto notificationType) {
        setId(id);
        setTaskUser(taskUser);
        setMessage(message);
        setTriggerDate(triggerDate);
        setNotificationType(notificationType);
    }

    static NotificationDto getDefault() {
        return new NotificationDto();
    }

    static NotificationDto getDefault(final NotificationDto notification) {
        return ObjectHelper.getDefault(notification, getDefault());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public TaskUserDto getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(final TaskUserDto taskUser) {
        this.taskUser = TaskUserDto.getDefaultValue(taskUser);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = TextHelper.getDefaultWithTrim(message);
    }

    public NotificationTypeDto getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(final NotificationTypeDto notificationType) {
        this.notificationType = NotificationTypeDto.getDefault(notificationType);
    }

    public LocalDateTime getTriggerDate() {
        return triggerDate;
    }

    public void setTriggerDate(final LocalDateTime triggerDate) {
        this.triggerDate = DateTimeHelper.getDefault(triggerDate);
    }
}
