package co.edu.co.extraclase.business.domain;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;	

class Domain {
	
	private UUID id;
	
	protected Domain(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
 }

