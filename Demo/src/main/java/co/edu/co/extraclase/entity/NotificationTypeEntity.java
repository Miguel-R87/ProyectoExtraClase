package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class NotificationTypeEntity {
	
	private UUID notificationTypeId;
	private String name;
	private String description;
	
	public NotificationTypeEntity() {
		setNotificationTypeId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public NotificationTypeEntity(final UUID notificationTypeId) {
		setNotificationTypeId(notificationTypeId);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public  NotificationTypeEntity(UUID notificationTypeId, String name, String description) {
		setNotificationTypeId(notificationTypeId);
		setName(name);
		setDescription(description);
	}
	
	
	static NotificationTypeEntity getDefault() {
		return new NotificationTypeEntity();
	}
	
	static NotificationTypeEntity getDefault(final NotificationTypeEntity notificationType) {
		return ObjectHelper.getDefault(notificationType, getDefault());
	}

	public UUID getNotificationTypeId() {
		return notificationTypeId;
	}

	public void setNotificationTypeId(UUID notificationTypeId) {
		this.notificationTypeId = UUIDHelper.getUUIDHelper().getDefault(notificationTypeId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}
	
}
