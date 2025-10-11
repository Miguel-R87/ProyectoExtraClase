package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.NumberHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;


public final class PriorityEntity {
	
	private UUID priorityId;
	private String name;
	private String description;
	private Integer responseTime;
	private UnitOfMeasureEntity unitOfMeasure;
	private ColorEntity color;
	
	public PriorityEntity() {
		setPriorityId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureEntity.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public PriorityEntity(final UUID priorityId) {
		setPriorityId(priorityId);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureEntity.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	private  PriorityEntity(UUID priorityId, String name, String description, Integer responseTime, UnitOfMeasureEntity unitOfMeasure, ColorEntity color) {
		setPriorityId(priorityId);
		setName(name);
		setDescription(description);
		setResponseTime(responseTime);
		setUnitOfMeasure(unitOfMeasure);
		setColor(color);
	}
	
	
	
	
	static PriorityEntity getDefault() {
		return new PriorityEntity();
	}
	
	static PriorityEntity getDefault(final PriorityEntity priority) {
		return ObjectHelper.getDefault(priority, getDefault());
	}

	public UUID getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(UUID priorityId) {
		this.priorityId = UUIDHelper.getUUIDHelper().getDefault(priorityId);
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

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Integer responseTime) {
		this.responseTime = NumberHelper.getDefault(responseTime);
	}

	public UnitOfMeasureEntity getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasureEntity unitOfMeasure) {
		this.unitOfMeasure = UnitOfMeasureEntity.getDefault(unitOfMeasure);
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = ColorEntity.getDefault(color);
	}

}
