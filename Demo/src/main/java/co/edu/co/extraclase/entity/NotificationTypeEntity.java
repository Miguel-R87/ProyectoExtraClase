package co.edu.co.extraclase.entity;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class NotificationTypeEntity {
	
	private UUID id;
	private String name;
	private String description;
	
	public NotificationTypeEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public NotificationTypeEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public  NotificationTypeEntity(final UUID id, final String name, final String description) {
		setId(id);
		setName(name);
		setDescription(description);
	}
	
	static NotificationTypeEntity getDefault() {
		return new NotificationTypeEntity();
	}
	
	static NotificationTypeEntity getDefault(final NotificationTypeEntity notificationType) {
		return ObjectHelper.getDefault(notificationType, getDefault());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}
}
