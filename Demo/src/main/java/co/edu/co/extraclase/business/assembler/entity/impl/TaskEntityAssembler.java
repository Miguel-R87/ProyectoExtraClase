package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.ListEntityAssembler.getListEntityAssembler;
import static co.edu.co.extraclase.business.assembler.entity.impl.StatusEntityAssembler.getStatusEntityAssembler;
import java.util.ArrayList;
import java.util.List;
import static co.edu.co.extraclase.business.assembler.entity.impl.PriorityEntityAssembler.getPriorityEntityAssembler;
import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.TaskDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.TaskEntity;

public final class TaskEntityAssembler implements EntityAssembler<TaskEntity, TaskDomain> {
	
	private static final EntityAssembler<TaskEntity, TaskDomain> instance = new TaskEntityAssembler();
	
	private TaskEntityAssembler() {
		
	}
	
	public static EntityAssembler<TaskEntity, TaskDomain> getTaskEntityAssembler() {
		return instance;
	}

	@Override
	public TaskEntity toEntity(TaskDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new TaskDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var listTmp = getListEntityAssembler().toEntity(domainTmp.getList());
		var statusTmp = getStatusEntityAssembler().toEntity(domainTmp.getStatus());
		var priorityTmp = getPriorityEntityAssembler().toEntity(domainTmp.getPriority());
		return new TaskEntity(domainTmp.getId(), domainTmp.getTitle(), domainTmp.getDescription(), domainTmp.getCreationDate(),
		domainTmp.getExpiryDate(), listTmp, statusTmp, priorityTmp );
	}

	@Override
	public TaskDomain toDomain(TaskEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new TaskEntity());
		var listDomainTmp = getListEntityAssembler().toDomain(entityTmp.getList());
		var statusDomainTmp = getStatusEntityAssembler().toDomain(entityTmp.getStatus());
		var priorityDomainTmp = getPriorityEntityAssembler().toDomain(entityTmp.getPriority());
		return new TaskDomain(entityTmp.getId(), entityTmp.getTitle(), entityTmp.getDescription(),
		entityTmp.getCreationDate(), entityTmp.getExpiryDate(), listDomainTmp, statusDomainTmp, priorityDomainTmp );
	}

	@Override
	public List<TaskDomain> toDomain(List<TaskEntity> entityList) {
		var taskDomainList = new ArrayList<TaskDomain>();
		
		for (var taskEntity : entityList) {
			taskDomainList.add(toDomain(taskEntity));
		}
		return taskDomainList;
	}
}
