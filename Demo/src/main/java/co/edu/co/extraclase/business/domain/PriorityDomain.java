package co.edu.co.extraclase.business.domain;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class PriorityDomain extends Domain {

	private String name;
	private String description;
	private float responseTime;
	private UnitOfMeasureDomain unitOfMeasure;
	private ColorDomain color;

	public PriorityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(0);
		setUnitOfMeasure(UnitOfMeasureDomain.getDefaultValue());
		setColor(ColorDomain.getDefaultValue());
	}

	public PriorityDomain(final UUID id, final String name, final String description, final float responseTime,
						  final ColorDomain color, UnitOfMeasureDomain unitOfMeasure) {
		super(id);
		setName(name);
		setDescription(description);
		setResponseTime(responseTime);
		setUnitOfMeasure(unitOfMeasure);
		setColor(color);
	}

	public static PriorityDomain getDefaultValue() {
		return new PriorityDomain();
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

	public float getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(final float responseTime) {
		this.responseTime = responseTime;
	}

	public UnitOfMeasureDomain getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(final UnitOfMeasureDomain unitOfMeasure) {
		this.unitOfMeasure = ObjectHelper.getDefault(unitOfMeasure, UnitOfMeasureDomain.getDefaultValue());
	}
	
	public ColorDomain getColor() {
		return color;
	}
	
	public void setColor(final ColorDomain color) {
		this.color = ObjectHelper.getDefault(color, ColorDomain.getDefaultValue());
	}
}
