package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.PriorityDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.PriorityDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.ColorDTOAssembler.getColorDtoAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.UnitOfMeasureDTOAssembler.getUnitOfMeasureDtoAssembler;

import java.util.ArrayList;
import java.util.List;


public final class PriorityDTOAssembler implements DTOAssembler<PriorityDto, PriorityDomain> {
    private static final DTOAssembler <PriorityDto, PriorityDomain> instance = new PriorityDTOAssembler();
    private PriorityDTOAssembler() {

    }

    public static DTOAssembler<PriorityDto, PriorityDomain> getPriorityDTOAssembler() {
        return instance;
    }

    @Override
    public PriorityDto toDTO(PriorityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new PriorityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var colorTmp = getColorDtoAssembler().toDTO(domainTmp.getColor());
        var unitOfMeasureTmp = getUnitOfMeasureDtoAssembler().toDTO(domainTmp.getUnitOfMeasure());
        return new PriorityDto(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), domainTmp.getResponseTime(), unitOfMeasureTmp, colorTmp);
    }

    @Override
    public PriorityDomain toDomain(PriorityDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new PriorityDto(UUIDHelper.getUUIDHelper().getDefault()));
        var colorDomainTmp = getColorDtoAssembler().toDomain(dtoTmp.getColor());
        var unitOfMeasureDomainTmp = getUnitOfMeasureDtoAssembler().toDomain(dtoTmp.getUnitOfMeasure());
        return new PriorityDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription(), dtoTmp.getResponseTime(),colorDomainTmp,unitOfMeasureDomainTmp);
    }

    @Override
    public List<PriorityDto> toDTO(List<PriorityDomain> domainList) {
        if(ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var priorityDtoList = new ArrayList<PriorityDto>();
        for(var PriorityDomain : domainList) {
            priorityDtoList.add(toDTO(PriorityDomain));
        }

        return priorityDtoList;
    }
}
