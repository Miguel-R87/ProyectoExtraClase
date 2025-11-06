package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.TaskDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.TaskDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.ListDTOAssembler.getListDTOAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.StatusDTOAssembler.getStatusDTOAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.PriorityDTOAssembler.getPriorityDTOAssembler;
import java.util.ArrayList;
import java.util.List;

public final class TaskDTOAssembler implements DTOAssembler<TaskDto, TaskDomain> {
    
	private static final DTOAssembler<TaskDto, TaskDomain> instance = new TaskDTOAssembler();
    
	private TaskDTOAssembler() {

    }

    public static DTOAssembler<TaskDto, TaskDomain> getTaskDTOAssembler() {
        return instance;
    }

    @Override
    public TaskDto toDTO(final TaskDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new TaskDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var listTmp = getListDTOAssembler().toDTO(domainTmp.getList());
        var statusTmp = getStatusDTOAssembler().toDTO(domainTmp.getStatus());
        var priorityTmp = getPriorityDTOAssembler().toDTO(domainTmp.getPriority());
        return new TaskDto(domainTmp.getId(),domainTmp.getTitle(),domainTmp.getDescription(),domainTmp.getCreationDate(),
                domainTmp.getExpiryDate(),listTmp,statusTmp,priorityTmp);
    }

    @Override
    public TaskDomain toDomain(final TaskDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new TaskDto(UUIDHelper.getUUIDHelper().getDefault()));
        var listTmpDomain = getListDTOAssembler().toDomain(dtoTmp.getList());
        var statusTmpDomain = getStatusDTOAssembler().toDomain(dtoTmp.getStatus());
        var priorityTmpDomain = getPriorityDTOAssembler().toDomain(dtoTmp.getPriority());
        return new TaskDomain(dtoTmp.getId(),dtoTmp.getTitle(), dtoTmp.getDescription(),dtoTmp.getCreationDate(),
                dtoTmp.getExpiryDate(),listTmpDomain,statusTmpDomain,priorityTmpDomain);
    }

    @Override
    public List<TaskDto> toDTO(final List<TaskDomain> domainList) {
        var taskDtoList = new ArrayList<TaskDto>();
        
        for(TaskDomain domain : domainList) {
            taskDtoList.add(toDTO(domain));
        }
        return taskDtoList;
    }
}
