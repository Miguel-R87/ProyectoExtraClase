package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;


public final class StatusEntity extends Entity {
	
	private UUID statusId;
	private String name;
	private String description;
	private ColorEntity color;
	
	public StatusEntity() {
		setStatusId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public StatusEntity(final UUID statusId) {
		setStatusId(statusId);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	private  StatusEntity(UUID statusId, String name, String description, ColorEntity color) {
		setStatusId(statusId);
		setName(name);
		setDescription(description);
		setColor(color);
	}
	
	
	
	
	static StatusEntity getDefault() {
		return new StatusEntity();
	}
	
	static StatusEntity getDefault(final StatusEntity status) {
		return ObjectHelper.getDefault(status, getDefault());
	}

	
	
	public UUID getStatusId() {
		return statusId;
	}

	public void setStatusId(UUID statusId) {
		this.statusId = UUIDHelper.getUUIDHelper().getDefault(statusId);
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

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = ColorEntity.getDefault(color);
	}
	
	
}
