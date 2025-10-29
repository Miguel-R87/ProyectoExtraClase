package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UnitOfMeasureEntity  {
	
	private UUID id;
	private String name;
	private String description;
	
	
	public UnitOfMeasureEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public UnitOfMeasureEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public  UnitOfMeasureEntity(UUID id, String name, String description) {
		setId(id);
		setName(name);
		setDescription(description);
	}
	
	
	public static UnitOfMeasureEntity getDefault() {
		return new UnitOfMeasureEntity();
	}
	
	static UnitOfMeasureEntity getDefault(final UnitOfMeasureEntity unitOfMeasure) {
		return ObjectHelper.getDefault(unitOfMeasure, getDefault());
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
