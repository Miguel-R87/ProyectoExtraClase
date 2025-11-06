package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.TaskUserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.TaskUserDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.ProjectUserDTOAssembler.getProjectUserDTOAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.TaskDTOAssembler.getTaskDTOAssembler;
import java.util.ArrayList;
import java.util.List;

public final class TaskUserDTOAssembler implements DTOAssembler<TaskUserDto, TaskUserDomain> {
    
	private static final DTOAssembler<TaskUserDto, TaskUserDomain> instance = new TaskUserDTOAssembler();
    
	private TaskUserDTOAssembler() {

    }

    public static DTOAssembler<TaskUserDto, TaskUserDomain> getTaskUserDTOAssembler() {
        return instance;
    }
    
    @Override
    public TaskUserDto toDTO(final TaskUserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new TaskUserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var projectUserTmp = getProjectUserDTOAssembler().toDTO(domainTmp.getProjectUser());
        var taskTmp = getTaskDTOAssembler().toDTO(domainTmp.getTask());
        return new TaskUserDto(domainTmp.getId(),projectUserTmp,taskTmp,domainTmp.getAssignmentDate(),
                domainTmp.getCompletionDate(),domainTmp.isCreator(), domainTmp.getComment());
    }

    @Override
    public TaskUserDomain toDomain(final TaskUserDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new TaskUserDto(UUIDHelper.getUUIDHelper().getDefault()));
        var projectUserTmpDomain = getProjectUserDTOAssembler().toDomain(dtoTmp.getProjectUser());
        var taskTmpDomain = getTaskDTOAssembler().toDomain(dtoTmp.getTask());
        return new TaskUserDomain(dtoTmp.getId(),projectUserTmpDomain,taskTmpDomain,dtoTmp.getAssignmentDate(),
                dtoTmp.getCompletionDate(),dtoTmp.isCreator(), dtoTmp.getComment());
    }

    @Override
    public List<TaskUserDto> toDTO(final List<TaskUserDomain> domainList) {
        var taskUserDtoList = new ArrayList<TaskUserDto>();
        
        for(TaskUserDomain domain : domainList) {
            taskUserDtoList.add(toDTO(domain));
        }
        return taskUserDtoList;
    }
}
