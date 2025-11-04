package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.UnitOfMeasureDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.UnitOfMeasureDto;

import java.util.ArrayList;
import java.util.List;

public final class UnitOfMeasureDTOAssembler implements DTOAssembler<UnitOfMeasureDto, UnitOfMeasureDomain>{
    private static final DTOAssembler<UnitOfMeasureDto, UnitOfMeasureDomain> instance = new UnitOfMeasureDTOAssembler();

    private UnitOfMeasureDTOAssembler(){
    }

    public static DTOAssembler<UnitOfMeasureDto, UnitOfMeasureDomain> getUnitOfMeasureDtoAssembler() {
        return instance;
    }

    @Override
    public UnitOfMeasureDto toDTO(UnitOfMeasureDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UnitOfMeasureDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitOfMeasureDto(domainTmp.getId(),domainTmp.getName(),domainTmp.getDescription());
    }

    @Override
    public UnitOfMeasureDomain toDomain(UnitOfMeasureDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UnitOfMeasureDto(UUIDHelper.getUUIDHelper().getDefault()));
        return new UnitOfMeasureDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription());
    }

    @Override
    public List<UnitOfMeasureDto> toDTO(List<UnitOfMeasureDomain> domainList) {
        if(ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }
        var unitOfMeasureDtoList = new ArrayList<UnitOfMeasureDto>();
        for(var unitOfMeasureDomain : domainList){
            unitOfMeasureDtoList.add(toDTO(unitOfMeasureDomain));
        }

        return unitOfMeasureDtoList;
    }
}


