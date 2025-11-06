package co.edu.co.extraclase.dto;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UnitOfMeasureDto {
	private UUID id;
	private String name;
	private String description;

	public UnitOfMeasureDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName (TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}

	public UnitOfMeasureDto(final UUID id){
		setId(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}

	public UnitOfMeasureDto(final UUID id, final String name, final String description) {
		setId(id);
		setName(name);
		setDescription(description);
	}

	void setId(UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	
	public UUID  getId() {
		return id;
	}

	void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public String getName() {
		return name;
	}

	void setDescription(final String description) {
		this.description = TextHelper.getDefaultWithTrim(description);
	}

	public String  getDescription() {
		return description;
	}

	public static UnitOfMeasureDto getDefaultValue() {
		return new UnitOfMeasureDto();
	}
}

