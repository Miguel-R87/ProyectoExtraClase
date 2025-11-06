package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.ProjectDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.ProjectDto;

import static co.edu.co.extraclase.business.assembler.dto.impl.ProjectStatusDTOAssembler.getProjectStatusDTOAssembler;
import java.util.ArrayList;
import java.util.List;

public final class ProjectDTOAssembler implements DTOAssembler <ProjectDto, ProjectDomain> {
    
	private static final DTOAssembler <ProjectDto,ProjectDomain> instance = new ProjectDTOAssembler();
    
	private ProjectDTOAssembler(){

    }

    public static DTOAssembler <ProjectDto,ProjectDomain> getProjectDTOAssembler(){
        return instance;
    }
    @Override
    public ProjectDto toDTO(ProjectDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProjectDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var projectStatusTmp = getProjectStatusDTOAssembler().toDTO(domainTmp.getProjectstatus());
        return new ProjectDto(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(),
                domainTmp.getCreationDate(), projectStatusTmp);
    }

    @Override
    public ProjectDomain toDomain(ProjectDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProjectDto(UUIDHelper.getUUIDHelper().getDefault()));
        var projectStatusDomainTmp = getProjectStatusDTOAssembler().toDomain(dtoTmp.getProjectStatus());
        return new ProjectDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription(),
                dtoTmp.getCreationDate(), projectStatusDomainTmp);
    }

    @Override
    public List<ProjectDto> toDTO(List<ProjectDomain> domainList) {
        var projectDtoList = new ArrayList<ProjectDto>();
        
        for(ProjectDomain domain : domainList) {
        	projectDtoList.add(toDTO(domain));
        }
        return projectDtoList;
    }
}
