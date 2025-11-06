package co.edu.co.extraclase.entity;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.NumberHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class PriorityEntity {
	
	private UUID id;
	private String name;
	private String description;
	private Integer responseTime;
	private UnitOfMeasureEntity unitOfMeasure;
	private ColorEntity color;
	
	public PriorityEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureEntity.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public PriorityEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureEntity.getDefault());
		setColor(ColorEntity.getDefault());
	}
	
	public  PriorityEntity(final UUID id, final String name, final String description, final Integer responseTime,
						   final UnitOfMeasureEntity unitOfMeasure, final ColorEntity color) {
		setId(id);
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

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(final Integer responseTime) {
		this.responseTime = NumberHelper.getDefault(responseTime);
	}

	public UnitOfMeasureEntity getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(final UnitOfMeasureEntity unitOfMeasure) {
		this.unitOfMeasure = UnitOfMeasureEntity.getDefault(unitOfMeasure);
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(final ColorEntity color) {
		this.color = ColorEntity.getDefault(color);
	}
}
