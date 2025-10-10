package co.edu.co.extraclase.entity;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ColorEntity {
	
	private UUID colorId;
	private String name;
	private String hexCode;
	
	
	public ColorEntity() {
		setColorId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	public ColorEntity(final UUID colorId) {
		setColorId(colorId);
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	private ColorEntity(UUID colorId, String name, String hexCode) {
		setColorId(colorId);
		setName(name);
		setHexCode(hexCode);
	}
	
	
	
	static ColorEntity getDefault() {
		return new ColorEntity();
	}
	
	static ColorEntity getDefault(final ColorEntity color) {
		return ObjectHelper.getDefault(color, getDefault()); 
	}
	
	

	public UUID getColorId() {
		return colorId;
	}

	public void setColorId(UUID colorId) {
		this.colorId = UUIDHelper.getUUIDHelper().getDefault(colorId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = TextHelper.getDefaultWithTrim(hexCode);
	}
	
	
	

}
