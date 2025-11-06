package co.edu.co.extraclase.dto;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class StatusDto {
    private UUID id;
    private String name;
    private String description;
    private ColorDto color;

    public StatusDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setColor(ColorDto.getDefaultValue());
    }

    public StatusDto(final UUID id, final String name, final String description, final ColorDto color) {
        setId(id);
        setName(name);
        setDescription(description);
        setColor(color);
    }

    public StatusDto(UUID id) {
        setId(id);
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setColor(ColorDto.getDefaultValue());
    }

    public static StatusDto getDefaultValue() {
        return new StatusDto();
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

    public ColorDto getColor() {
        return color;
    }

    public void setColor(final ColorDto color) {
        this.color = ObjectHelper.getDefault(color, ColorDto.getDefaultValue());
    }
}
