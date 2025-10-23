package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.ProjectStatusEntityAssembler.getProjectStatusEntityAssembler;


import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.ProjectDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.ProjectEntity;

public final class ProjectEntityAssembler implements EntityAssembler<ProjectEntity, ProjectDomain> {
	private static final EntityAssembler<ProjectEntity, ProjectDomain> instance = new ProjectEntityAssembler();
	
	private ProjectEntityAssembler() {
		
	}
	
	public static EntityAssembler<ProjectEntity, ProjectDomain> getProjectEntityAssembler() {
		return instance;
	}

	@Override
	public ProjectEntity toEntity(ProjectDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ProjectDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var projectStatusTmp = getProjectStatusEntityAssembler().toEntity(domainTmp.getProjectstatus());
		return new ProjectEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(),
		domainTmp.getCreationDate(), projectStatusTmp);
	}

	@Override
	public ProjectDomain toDomain(ProjectEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ProjectEntity());
		var projectStatusDomainTmp = getProjectStatusEntityAssembler().toDomain(entity.getProjectStatus());
		return new ProjectDomain(entityTmp.getProjectId(), entityTmp.getName(), entityTmp.getDescription(),
		entityTmp.getCreationDate(), projectStatusDomainTmp);
	}
}
