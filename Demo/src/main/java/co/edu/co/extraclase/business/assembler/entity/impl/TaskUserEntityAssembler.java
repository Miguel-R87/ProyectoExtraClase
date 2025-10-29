package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.ProjectUserEntityAssembler.getProjectUserEntityAssembler;
import static co.edu.co.extraclase.business.assembler.entity.impl.TaskEntityAssembler.getTaskEntityAssembler;


import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.TaskUserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.TaskUserEntity;

public final class TaskUserEntityAssembler implements EntityAssembler<TaskUserEntity, TaskUserDomain>{

	private static final EntityAssembler<TaskUserEntity, TaskUserDomain> instance = new TaskUserEntityAssembler();
	
	private TaskUserEntityAssembler() {
		}
	
	public static EntityAssembler<TaskUserEntity, TaskUserDomain> getTaskUserEntityAssembler() {
		return instance;
				
	}
	
	
	@Override
	public TaskUserEntity toEntity(TaskUserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new TaskUserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var projectUserTmp = getProjectUserEntityAssembler().toEntity(domainTmp.getProjectUser());
		var taskTmp = getTaskEntityAssembler().toEntity(domainTmp.getTask());
		return new TaskUserEntity(domainTmp.getId(), projectUserTmp, taskTmp, domainTmp.getAssignmentDate(), 
		domainTmp.getCompletionDate(), domainTmp.isCreator(), domainTmp.getComment());
	}

	@Override
	public TaskUserDomain toDomain(TaskUserEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new TaskUserEntity());
		var projectUserDomainTmp = getProjectUserEntityAssembler().toDomain(entityTmp.getProjectUser());
		var taskDomainTmp = getTaskEntityAssembler().toDomain(entityTmp.getTask());
		return new TaskUserDomain(entityTmp.getId(), projectUserDomainTmp,
		taskDomainTmp, entityTmp.getAssignmentDate(), entityTmp.getCompletionDate(), entityTmp.isCreator(), 
		entityTmp.getComment());
	}
}
