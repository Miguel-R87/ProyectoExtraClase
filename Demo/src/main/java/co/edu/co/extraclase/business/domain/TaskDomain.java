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
	
	String getTitle() {
		return title;
	}
	 String getDescription() {
		 return description;
	 }
	 ListDomain getList() {
		 return list;
	 }
	 StatusDomain getStatus() {
		 return status;
	 }
	 PriorityDomain getPriority() {
		 return priority;
	 }
	 LocalDateTime getCreationDate() {
		 return creationDate;
	 }
	 LocalDateTime getExpiryDate() {
		 return expiryDate;
	 }	
	
    void setTitle(final String title){
		this.title=TextHelper.getDefaultWithTrim(title);
	}
	void setDescription(final String description) {
		 this.description=TextHelper.getDefaultWithTrim(description);
	 }
	 void setList(final ListDomain list) {
		this.list = ObjectHelper.getDefault(list, ListDomain.getDefaultValue());
	 }
	 void setStatus (final StatusDomain status) {
		 this.status=ObjectHelper.getDefault(status, StatusDomain.getDefaultValue());
	 }
	 void setPriority(final PriorityDomain priority) {
		 this.priority=ObjectHelper.getDefault(priority, PriorityDomain.getDefaultValue());
		 
	 }
	 void setCreationDate(final LocalDateTime creationDate) {
		 this.creationDate= DateTimeHelper.getDefault(creationDate);
	 }
	 void setExpiryDate(final LocalDateTime	 ExpiryDate) {
		 this.expiryDate = DateTimeHelper.getDefault(expiryDate);
	 }

	static TaskDomain getDefaultValue() {
		return new TaskDomain();
	}

	static TaskDomain getDefaultValue(final TaskDomain task) {
		return ObjectHelper.getDefault(task, getDefaultValue());
	}
	 
	 
	 
	


}