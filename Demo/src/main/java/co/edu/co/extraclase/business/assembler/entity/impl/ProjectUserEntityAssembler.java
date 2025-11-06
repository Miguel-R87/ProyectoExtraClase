package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.UserEntityAssembler.getUserEntityAssembler;
import java.util.ArrayList;
import java.util.List;
import static co.edu.co.extraclase.business.assembler.entity.impl.ProjectEntityAssembler.getProjectEntityAssembler;
import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.ProjectUserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.ProjectUserEntity;

public final class ProjectUserEntityAssembler implements EntityAssembler<ProjectUserEntity, ProjectUserDomain> {
	
	private static final EntityAssembler<ProjectUserEntity, ProjectUserDomain> instance = new ProjectUserEntityAssembler();
	
	private ProjectUserEntityAssembler() {
		
	}
	
	public static  EntityAssembler<ProjectUserEntity, ProjectUserDomain> getProjectUserEntityAssembler() {
		return instance;
	}

	@Override
	public ProjectUserEntity toEntity(final ProjectUserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ProjectUserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var userTmp = getUserEntityAssembler().toEntity(domainTmp.getUser());
		var projectTmp = getProjectEntityAssembler().toEntity(domainTmp.getProject());
		return new ProjectUserEntity(domainTmp.getId(), userTmp, projectTmp, domainTmp.isAdmin(), 
		domainTmp.getEntryDate(), domainTmp.getExpiryDate());
	}

	@Override
	public ProjectUserDomain toDomain(final ProjectUserEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ProjectUserEntity());
		var userDomainTmp = getUserEntityAssembler().toDomain(entityTmp.getUser());
		var projectDomainTmp = getProjectEntityAssembler().toDomain(entityTmp.getProject());
		return new ProjectUserDomain(entityTmp.getId(), userDomainTmp, projectDomainTmp, entityTmp.isAdmin(),
		entityTmp.getEntryDate(), entityTmp.getExpiryDate());
	}

	@Override
	public List<ProjectUserDomain> toDomain(final List<ProjectUserEntity> entityList) {
		var projectUserDomainList = new ArrayList<ProjectUserDomain>();
		
		for (var projectUserEntity : entityList) {
			projectUserDomainList.add(toDomain(projectUserEntity));
		}
		return projectUserDomainList;
	}
}
