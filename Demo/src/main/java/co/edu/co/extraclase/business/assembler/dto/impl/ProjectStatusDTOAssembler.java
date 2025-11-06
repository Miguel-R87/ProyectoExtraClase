package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.ProjectStatusDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.ProjectStatusDto;

import java.util.ArrayList;
import java.util.List;

public final class ProjectStatusDTOAssembler implements DTOAssembler<ProjectStatusDto, ProjectStatusDomain> {
    
	private static final DTOAssembler<ProjectStatusDto, ProjectStatusDomain> instance = new ProjectStatusDTOAssembler();

    private ProjectStatusDTOAssembler() {
    	
    }

    public static DTOAssembler <ProjectStatusDto, ProjectStatusDomain> getProjectStatusDTOAssembler(){
        return instance;
    }

    @Override
    public ProjectStatusDto toDTO(ProjectStatusDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain , new ProjectStatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new ProjectStatusDto(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
    }

    @Override
    public ProjectStatusDomain toDomain(ProjectStatusDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProjectStatusDto(UUIDHelper.getUUIDHelper().getDefault()));
        return new ProjectStatusDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription());
    }

    @Override
    public List<ProjectStatusDto> toDTO(List<ProjectStatusDomain> domainList) {
        var projectStatusDtoList = new ArrayList<ProjectStatusDto>();
        
        for(ProjectStatusDomain domain : domainList) {
        projectStatusDtoList.add(toDTO(domain));
        }
        return projectStatusDtoList;
    }
}
