package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class TaskEntity  {
	
	private UUID id;
	private String title;
	private String description;
	private LocalDateTime creationDate;
	private LocalDateTime expiryDate;
	private ListEntity list;
	private StatusEntity status;
	private PriorityEntity priority;
	
	public TaskEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setTitle(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
		setList(ListEntity.getDefault());
		setStatus(StatusEntity.getDefault());
		setPriority(PriorityEntity.getDefault());
	}
	
	public TaskEntity(final UUID id) {
		setId(id);
		setTitle(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
		setList(ListEntity.getDefault());
		setStatus(StatusEntity.getDefault());
		setPriority(PriorityEntity.getDefault());
	}
	
	public  TaskEntity(final UUID id, final String title, final String description, final LocalDateTime creationDate, final LocalDateTime expiryDate, final ListEntity list, final StatusEntity status, final PriorityEntity priority) {
		setId(id);
		setTitle(title);
		setDescription(description);
		setCreationDate(creationDate);
		setExpiryDate(expiryDate);
		setList(list);
		setStatus(status);
		setPriority(priority);
	}
	
	static TaskEntity getDefault() {
		return new TaskEntity();
	}
	
	static TaskEntity getDefault(final TaskEntity task) {
		return ObjectHelper.getDefault(task, getDefault());
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

	public ListEntity getList() {
		return list;
	}

	public void setList(ListEntity list) {
		this.list = ListEntity.getDefault(list);
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = StatusEntity.getDefault(status);
	}

	public PriorityEntity getPriority() {
		return priority;
	}

	public void setPriority(PriorityEntity priority) {
		this.priority = PriorityEntity.getDefault(priority);
	}
}
