package co.edu.co.extraclase.business.domain;


import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ColorDomain extends Domain {

	private String name;
	private String hexCode;
	
	public ColorDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	public ColorDomain(final UUID id, final String name, final String hexCode) {
		super(id);
		setName(name);
		setHexCode(hexCode);
	}
	
	public ColorDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	public static ColorDomain getDefaultValue() {
		return new ColorDomain();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(final String hexCode) {
		this.hexCode = TextHelper.getDefaultWithTrim(hexCode);
	}
}
