
package co.edu.co.extraclase.dto;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import java.time.LocalDateTime;
import java.util.UUID;

public final class TaskDto {

    private UUID id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime expiryDate;
    private ListDto list;
    private StatusDto status;
    private PriorityDto priority;

 
    public TaskDto() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setTitle(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setCreationDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());
        setList(ListDto.getDefaultValue());
        setStatus(StatusDto.getDefaultValue());
        setPriority(PriorityDto.getDefaultValue());
    }


    public TaskDto(final UUID id, final String title, final String description,
                   final LocalDateTime creationDate, final LocalDateTime expiryDate,
                   final ListDto list, final StatusDto status, final PriorityDto priority) {
        setId(id);
        setTitle(title);
        setDescription(description);
        setCreationDate(creationDate);
        setExpiryDate(expiryDate);
        setList(list);
        setStatus(status);
        setPriority(priority);
    }

    public TaskDto(UUID id) {
        setId(id);
        setTitle(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setCreationDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());
        setList(ListDto.getDefaultValue());
        setStatus(StatusDto.getDefaultValue());
        setPriority(PriorityDto.getDefaultValue());
    }


    public static TaskDto getDefaultValue() {
        return new TaskDto();
    }

    public static TaskDto getDefaultValue(final TaskDto dto) {
        return ObjectHelper.getDefault(dto, getDefaultValue());
    }

   
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = DateTimeHelper.getDefault(creationDate);
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = DateTimeHelper.getDefault(expiryDate);
    }

    public ListDto getList() {
        return list;
    }

    public void setList(ListDto list) {
        this.list = ObjectHelper.getDefault(list, ListDto.getDefaultValue());
    }

    public StatusDto getStatus() {
        return status;
    }

    public void setStatus(StatusDto status) {
        this.status = ObjectHelper.getDefault(status, StatusDto.getDefaultValue());
    }

    public PriorityDto getPriority() {
        return priority;
    }

    public void setPriority(PriorityDto priority) {
        this.priority = ObjectHelper.getDefault(priority, PriorityDto.getDefaultValue());
    }
}
