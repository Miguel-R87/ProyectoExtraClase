package co.edu.co.extraclase.business.domain;

import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ProjectStatusDomain extends Domain {

	private String name;
	private String description;

	public ProjectStatusDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}
	
	public ProjectStatusDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
	}

	public ProjectStatusDomain(final UUID id, final String name, final String description) {
		super(id);
		setName(name);
		setDescription(description);
	}

	public static ProjectStatusDomain getDefaultValue() {
		return new ProjectStatusDomain();
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
