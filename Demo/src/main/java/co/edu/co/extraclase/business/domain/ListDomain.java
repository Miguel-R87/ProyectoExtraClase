package co.edu.co.extraclase.business.domain;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;



public final class ListDomain extends Domain {
	private String name;
	private ProjectDomain project;
	private LocalDateTime creationDate;
	
	public ListDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCreationDate(DateTimeHelper.getDefault());
		
	}
	public ListDomain(final UUID id, final String name, final LocalDateTime creationDate) {
		super(id);
		setName(name);
		setCreationDate(creationDate);
	}

	static ListDomain getDefaultValue() {
		return new ListDomain();
	}

	static ListDomain getDefaultValue(final ListDomain list) {
		return ObjectHelper.getDefault(list, getDefaultValue());
	}

	void setName(final String name) {
		this.name= TextHelper.getDefaultWithTrim(name);
	}
	void setCreationDate(final LocalDateTime creationDate) {
		this.creationDate = DateTimeHelper.getDefault(creationDate);
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}	

	



}
