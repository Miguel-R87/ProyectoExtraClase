package co.edu.co.extraclase.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;
import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.ProjectStatusDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.ProjectStatusEntity;

public final class ProjectStatusEntityAssembler implements EntityAssembler<ProjectStatusEntity, ProjectStatusDomain> {
	
	private static final EntityAssembler<ProjectStatusEntity, ProjectStatusDomain> instance = new ProjectStatusEntityAssembler();
	
	private ProjectStatusEntityAssembler() {
		
	}
	
	public static EntityAssembler<ProjectStatusEntity, ProjectStatusDomain> getProjectStatusEntityAssembler() {
		return instance;
	}

	@Override
	public ProjectStatusEntity toEntity(final ProjectStatusDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ProjectStatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new ProjectStatusEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
	}

	@Override
	public ProjectStatusDomain toDomain(final ProjectStatusEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ProjectStatusEntity());
		return new ProjectStatusDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription());
	}

	@Override
	public List<ProjectStatusDomain> toDomain(final List<ProjectStatusEntity> entityList) {
		var projectStatusDomainList = new ArrayList<ProjectStatusDomain>();
		
		for (var projectStatusEntity : entityList) {
			projectStatusDomainList.add(toDomain(projectStatusEntity));
		}
		return projectStatusDomainList;
	}
}
