package co.edu.co.extraclase.dto;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.NumberHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class PriorityDto {
    
	private UUID id;
    private String name;
    private String description;
    private Integer responseTime;
    private UnitOfMeasureDto unitOfMeasure;
    private ColorDto color;

    public PriorityDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setResponseTime(NumberHelper.getDefault());
        setUnitOfMeasure(UnitOfMeasureDto.getDefaultValue());
        setColor(ColorDto.getDefaultValue());
    }

    public PriorityDto(final UUID id, final String name, final String description, final Integer responseTime,
                       final UnitOfMeasureDto unitOfMeasure, final ColorDto color) {
        setId(id);
        setName(name);
        setDescription(description);
        setResponseTime(responseTime);
        setUnitOfMeasure(unitOfMeasure);
        setColor(color);
    }

    public PriorityDto(UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setResponseTime(NumberHelper.getDefault());
        setUnitOfMeasure(UnitOfMeasureDto.getDefaultValue());
        setColor(ColorDto.getDefaultValue());
    }

    public static PriorityDto getDefaultValue() {
        return new PriorityDto();
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

    public UnitOfMeasureDto getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(final UnitOfMeasureDto unitOfMeasure) {
        this.unitOfMeasure = ObjectHelper.getDefault(unitOfMeasure, UnitOfMeasureDto.getDefaultValue());
    }

    public ColorDto getColor() {
        return color;
    }

    public void setColor(final ColorDto color) {
        this.color = ObjectHelper.getDefault(color, ColorDto.getDefaultValue());
    }
}
