package co.edu.co.extraclase.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.ColorDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.ColorDto;

public final class ColorDTOAssembler implements DTOAssembler<ColorDto, ColorDomain> {
    private static final DTOAssembler<ColorDto, ColorDomain> instance = new ColorDTOAssembler();

    private ColorDTOAssembler() {
    }

    public static DTOAssembler<ColorDto, ColorDomain> getColorDtoAssembler() {
        return instance;
    }

    @Override
    public ColorDto toDTO(final ColorDomain domain) {
       var domainTmp = ObjectHelper.getDefault(domain, new ColorDomain(UUIDHelper.getUUIDHelper().getDefault()));
       return new ColorDto(domainTmp.getId(),domainTmp.getName(),domainTmp.getHexCode());
    }

    @Override
    public ColorDomain toDomain(final ColorDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new ColorDto());
        return new ColorDomain(dtoTmp.getId(),dtoTmp.getName(),dtoTmp.getHexCode());
    }

    @Override
    public List<ColorDto> toDTO(final List<ColorDomain> domainList) {
        if(ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }
        var colorDtoList  =new ArrayList<ColorDto>();

        for(var colorDomain : domainList) {
            colorDtoList.add(toDTO(colorDomain));
        }

        return colorDtoList;
    }

}
