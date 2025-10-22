package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.NotificationTypeDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.NotificationTypeDto;

import java.util.ArrayList;
import java.util.List;

public final class NotificationTypeDTOAssembler implements DTOAssembler<NotificationTypeDto, NotificationTypeDomain>{
    private static final DTOAssembler<NotificationTypeDto, NotificationTypeDomain> instance =  new NotificationTypeDTOAssembler();

    private NotificationTypeDTOAssembler() {

    }

    public static DTOAssembler<NotificationTypeDto, NotificationTypeDomain> getNotificationTypeDtoAssembler() {
        return instance;
    }
    @Override
    public NotificationTypeDto toDTO(NotificationTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain , new NotificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new NotificationTypeDto(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
    }

    @Override
    public NotificationTypeDomain toDomain(NotificationTypeDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new NotificationTypeDto(UUIDHelper.getUUIDHelper().getDefault()));
        return new NotificationTypeDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription());
    }

    @Override
    public List<NotificationTypeDto> toDTO(List<NotificationTypeDomain> domainList) {
        if(ObjectHelper.isNull(domainList)){
            return new ArrayList<>();
        }
        var notificationTypeDtoList = new ArrayList<NotificationTypeDto>();
        for (var notificationTypeDomain : domainList) {
            notificationTypeDtoList.add(toDTO(notificationTypeDomain));
        }
        return notificationTypeDtoList;

    }
}
