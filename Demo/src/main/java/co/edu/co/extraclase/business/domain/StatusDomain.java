package co.edu.co.extraclase.business.domain;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class StatusDomain extends Domain {
	
	private String name;
	private String description;
	private ColorDomain color;
	
	public StatusDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setColor(ColorDomain.getDefaultValue());
	}
	
	public StatusDomain(final UUID id, final String name, final String description, final ColorDomain color) {
		super(id);
		setName(name);
		setDescription(description);
		setColor(color);
	}
	
	public static StatusDomain getDefaultValue() {
		return new StatusDomain();
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

	public ColorDomain getColor() {
		return color;
	}

	public void setColor(final ColorDomain color) {
		this.color = ObjectHelper.getDefault(color, ColorDomain.getDefaultValue());
	}
}
