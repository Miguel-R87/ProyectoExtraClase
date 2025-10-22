package co.edu.co.extraclase.dto;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectStatusDto {
    
    private UUID id;
    private String name;
    private String description;

    public ProjectStatusDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ProjectStatusDto(final UUID id){
        setId(id);
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
    }

    public ProjectStatusDto(final UUID id, final String name, final String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public static ProjectStatusDto getDefaultValue() {
        return new ProjectStatusDto();
    }

    public static ProjectStatusDto getDefaultValue(final ProjectStatusDto status) {
        return ObjectHelper.getDefault(status, getDefaultValue());
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
}
