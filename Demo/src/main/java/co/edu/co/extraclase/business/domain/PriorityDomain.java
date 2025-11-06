package co.edu.co.extraclase.business.domain;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.NumberHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class PriorityDomain extends Domain {

	private String name;
	private String description;
	private Integer responseTime;
	private UnitOfMeasureDomain unitOfMeasure;
	private ColorDomain color;

	public PriorityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureDomain.getDefaultValue());
		setColor(ColorDomain.getDefaultValue());
	}
	
	public PriorityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setResponseTime(NumberHelper.getDefault());
		setUnitOfMeasure(UnitOfMeasureDomain.getDefaultValue());
		setColor(ColorDomain.getDefaultValue());
	}

	public PriorityDomain(final UUID id, final String name, final String description, final Integer responseTime,  
			UnitOfMeasureDomain unitOfMeasure, final ColorDomain color) {
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

	public Integer getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(final Integer responseTime) {
		this.responseTime = NumberHelper.getDefault();
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
