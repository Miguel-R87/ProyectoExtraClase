package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UnitOfMeasureEntity {
	
	private UUID unitOfMeasureId;
	private String name;
	private String description;
	
	
	public UnitOfMeasureEntity() {
		setUnitOfMeasureId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public UnitOfMeasureEntity(final UUID unitOfMeasureId) {
		setUnitOfMeasureId(unitOfMeasureId);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	private UnitOfMeasureEntity(UUID unitOfMeasureId, String name, String description) {
		setUnitOfMeasureId(unitOfMeasureId);
		setName(name);
		setDescription(description);
	}
	
	
	static UnitOfMeasureEntity getDefault() {
		return new UnitOfMeasureEntity();
	}
	
	static UnitOfMeasureEntity getDefault(final UnitOfMeasureEntity unitOfMeasure) {
		return ObjectHelper.getDefault(unitOfMeasure, getDefault());
	}

	public UUID getUnitOfMeasureId() {
		return unitOfMeasureId;
	}

	public void setUnitOfMeasureId(UUID unitOfMeasureId) {
		this.unitOfMeasureId = UUIDHelper.getUUIDHelper().getDefault(unitOfMeasureId);
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
