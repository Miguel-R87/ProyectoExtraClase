package co.edu.co.extraclase.entity;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ColorEntity  {
	
	private UUID id;
	private String name;
	private String hexCode;
	
	public ColorEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	public ColorEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setHexCode(TextHelper.getDefault());
	}
	
	public  ColorEntity(UUID id, String name, String hexCode) {
		setId(id);
		setName(name);
		setHexCode(hexCode);
	}
	
	static ColorEntity getDefault() {
		return new ColorEntity();
	}
	
	static ColorEntity getDefault(final ColorEntity color) {
		return ObjectHelper.getDefault(color, getDefault()); 
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

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = TextHelper.getDefaultWithTrim(hexCode);
	}
}
