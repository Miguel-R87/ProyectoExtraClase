package co.edu.co.extraclase.business.domain;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UnitOfMeasureDomain extends Domain {
	
	private String name;
	private String description;
	
	public UnitOfMeasureDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public UnitOfMeasureDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public UnitOfMeasureDomain(final UUID id, final String name, final String description) {
		super(id);
		setName(name);
		setDescription(description);
	}
	
	public static UnitOfMeasureDomain getDefaultValue() {
		return new UnitOfMeasureDomain();
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

	public void setDescription(final String descrition) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}
}