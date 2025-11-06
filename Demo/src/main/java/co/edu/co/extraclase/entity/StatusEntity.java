package co.edu.co.extraclase.entity;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class StatusEntity  {
	
	private UUID id;
	private String name;
	private String description;
	private ColorEntity color;
	
	public StatusEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public StatusEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public  StatusEntity(final UUID id, final String name, final String description, final ColorEntity color) {
		setId(id);
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

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
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

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(final ColorEntity color) {
		this.color = ColorEntity.getDefault(color);
	}
}
