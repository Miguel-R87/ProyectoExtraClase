package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.ProjectUserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.ProjectUserDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.ProjectDTOAssembler.getProjectDTOAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.UserDTOAssembler.getUserDTOAssembler;
import java.util.ArrayList;
import java.util.List;

public final class ProjectUserDTOAssembler implements DTOAssembler<ProjectUserDto, ProjectUserDomain> {
    
	private static final DTOAssembler<ProjectUserDto, ProjectUserDomain> instance = new ProjectUserDTOAssembler();

    private ProjectUserDTOAssembler() {

    }

    public static DTOAssembler<ProjectUserDto, ProjectUserDomain> getProjectUserDTOAssembler() {
        return instance;
    }

    @Override
    public ProjectUserDto toDTO(ProjectUserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ProjectUserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var projectTmp = getProjectDTOAssembler().toDTO(domainTmp.getProject());
        var userTmp = getUserDTOAssembler().toDTO(domainTmp.getUser());
        return new ProjectUserDto(domainTmp.getId(), userTmp, projectTmp, domainTmp.isAdmin(),
                domainTmp.getEntryDate(), domainTmp.getExpiryDate());
    }

    @Override
    public ProjectUserDomain toDomain(ProjectUserDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ProjectUserDto(UUIDHelper.getUUIDHelper().getDefault()));
        var projectTmpDomain = getProjectDTOAssembler().toDomain(dtoTmp.getProject());
        var userTmpDomain = getUserDTOAssembler().toDomain(dtoTmp.getUser());
        return new ProjectUserDomain(dtoTmp.getId(), userTmpDomain, projectTmpDomain, dtoTmp.isAdmin(),
                dtoTmp.getEntryDate(), dtoTmp.getExpiryDate());
    }

    @Override
    public List<ProjectUserDto> toDTO(List<ProjectUserDomain> domainList) {
        var projectUserDtoList = new ArrayList<ProjectUserDto>();
        
        for(ProjectUserDomain domain : domainList) {
        	projectUserDtoList.add(toDTO(domain));
        }
        return projectUserDtoList;
    }
}


