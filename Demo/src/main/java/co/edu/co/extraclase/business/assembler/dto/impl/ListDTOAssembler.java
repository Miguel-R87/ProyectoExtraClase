package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.ListDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.ListDto;

import static co.edu.co.extraclase.business.assembler.dto.impl.ProjectDTOAssembler.getProjectDTOAssembler;
import java.util.ArrayList;
import java.util.List;

public final class ListDTOAssembler implements DTOAssembler<ListDto, ListDomain> {
    
	private static final DTOAssembler <ListDto, ListDomain> instance= new ListDTOAssembler();
    
	private ListDTOAssembler() {

    }

    public static DTOAssembler<ListDto, ListDomain> getListDTOAssembler() {
        return instance;
    }

    @Override
    public ListDto toDTO(ListDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new ListDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var projectTmp = getProjectDTOAssembler().toDTO(domainTmp.getProject());
        return new ListDto(domainTmp.getId(),domainTmp.getName(),projectTmp,domainTmp.getCreationDate());
    }

    @Override
    public ListDomain toDomain(ListDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ListDto(UUIDHelper.getUUIDHelper().getDefault()));
        var projectTmpDomain = getProjectDTOAssembler().toDomain(dtoTmp.getProject());
        return new ListDomain(dtoTmp.getId(), dtoTmp.getName(), projectTmpDomain, dtoTmp.getCreationDate());
    }

    @Override
    public List<ListDto> toDTO(List<ListDomain> domainList) {
        var listDtoList = new ArrayList<ListDto>();
        
        for(ListDomain domain : domainList) {
        	listDtoList.add(toDTO(domain));
        }
        return listDtoList;
    }
}
