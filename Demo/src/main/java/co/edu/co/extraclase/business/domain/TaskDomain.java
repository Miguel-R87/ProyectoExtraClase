package co.edu.co.extraclase.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;	
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;	

public final  class TaskDomain extends Domain{
	private String title;
	private String description;
	private LocalDateTime creationDate;
	private LocalDateTime expiryDate;
	private ListDomain list;
	private StatusDomain status;
	private PriorityDomain priority;
	
	public TaskDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setTitle(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setList(ListDomain.getDefaultValue());
        setStatus(StatusDomain.getDefaultValue());
        setPriority(PriorityDomain.getDefaultValue());
        setCreationDate(DateTimeHelper.getDefault());
        setExpiryDate(DateTimeHelper.getDefault());	
	 } 
	
	public TaskDomain(final UUID id) {
		super(id);
		setTitle(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setList(ListDomain.getDefaultValue());
		setStatus(StatusDomain.getDefaultValue());
		setPriority(PriorityDomain.getDefaultValue());
		setCreationDate(DateTimeHelper.getDefault());
		setExpiryDate(DateTimeHelper.getDefault());
	 }
	
	public TaskDomain(final UUID id, final String title, final String description, final LocalDateTime creationDate, final LocalDateTime expiryDate,
					  final ListDomain list, final StatusDomain status, final PriorityDomain priority) {
		super(id);
		setTitle(title);
		setDescription(description);
		setList(list);
		setCreationDate(creationDate);
		setExpiryDate(expiryDate);
		setStatus(status);
		setPriority(priority);
		
	 }
	
	static TaskDomain getDefaultValue() {
		return new TaskDomain();
	 }

	static TaskDomain getDefaultValue(final TaskDomain task) {
		return ObjectHelper.getDefault(task, getDefaultValue());
	 }
	 
	public String getTitle() {
		return title;
	 }
	 public String getDescription() {
		 return description;
	 }
	 public ListDomain getList() {
		 return list;
	 }
	 public StatusDomain getStatus() {
		 return status;
	 }
	 public PriorityDomain getPriority() {
		 return priority;
	 }
	 public LocalDateTime getCreationDate() {
		 return creationDate;
	 }
	 public LocalDateTime getExpiryDate() {
		 return expiryDate;
	 }	
	
	 public void setTitle(final String title){
		this.title=TextHelper.getDefaultWithTrim(title);
	 }
	 
	 public void setDescription(final String description) {
		 this.description=TextHelper.getDefaultWithTrim(description);
	 }
	 
	 public void setList(final ListDomain list) {
		this.list = ObjectHelper.getDefault(list, ListDomain.getDefaultValue());
	 }
	 
	 public void setStatus (final StatusDomain status) {
		 this.status=ObjectHelper.getDefault(status, StatusDomain.getDefaultValue());
	 }
	 
	 public void setPriority(final PriorityDomain priority) {
		 this.priority=ObjectHelper.getDefault(priority, PriorityDomain.getDefaultValue()); 
	 }
	 
	 public void setCreationDate(final LocalDateTime creationDate) {
		 this.creationDate= DateTimeHelper.getDefault(creationDate);
	 }
	 
	 public void setExpiryDate(final LocalDateTime	 ExpiryDate) {
		 this.expiryDate = DateTimeHelper.getDefault(expiryDate);
	 }
}