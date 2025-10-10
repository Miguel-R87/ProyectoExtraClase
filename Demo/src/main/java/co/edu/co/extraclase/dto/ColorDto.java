
package co.edu.co.extraclase.dto;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ColorDto {
    private UUID id;
    private String name;
    private String hexCode;

    public ColorDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setHexCode(TextHelper.getDefault());
    }

    public ColorDto(final UUID id, final String name, final String hexCode) {
        setId(id);
        setName(name);
        setHexCode(hexCode);
    }

    public static ColorDto getDefaultValue() {
        return new ColorDto();
    }

    public static ColorDto getDefaultValue(final ColorDto color) {
        return ObjectHelper.getDefault(color, getDefaultValue());
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

    public String getHexCode() {
        return hexCode;
    }

    public void setHexCode(final String hexCode) {
        this.hexCode = TextHelper.getDefaultWithTrim(hexCode);
    }
}
