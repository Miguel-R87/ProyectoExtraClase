package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.StatusDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.StatusDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.ColorDTOAssembler.getColorDtoAssembler;
import java.util.ArrayList;
import java.util.List;

public final class StatusDTOAssembler implements DTOAssembler <StatusDto, StatusDomain> {
    
	private static final DTOAssembler <StatusDto,  StatusDomain> instance = new StatusDTOAssembler();
    
	private StatusDTOAssembler() {

    }

    public static DTOAssembler <StatusDto,  StatusDomain> getStatusDTOAssembler() {
        return instance;
    }

    @Override
    public StatusDto toDTO(final StatusDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var colorTmp = getColorDtoAssembler().toDTO(domainTmp.getColor());
        return new StatusDto(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), colorTmp);
    }

    @Override
    public StatusDomain toDomain(final StatusDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new StatusDto(UUIDHelper.getUUIDHelper().getDefault()));
        var colorDomainTmp = getColorDtoAssembler().toDomain(dtoTmp.getColor());
        return new StatusDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription(), colorDomainTmp);
    }

    @Override
    public List<StatusDto> toDTO(final List<StatusDomain> domainList) {
        var statusDtoList = new ArrayList<StatusDto>();
        
        for(StatusDomain domain : domainList) {
        	statusDtoList.add(toDTO(domain));
        }
        return statusDtoList;
    }
}
