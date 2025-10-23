package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.NotificationDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.NotificationDto;
import static co.edu.co.extraclase.business.assembler.dto.impl.TaskUserDTOAssembler.getTaskUserDTOAssembler;
import static co.edu.co.extraclase.business.assembler.dto.impl.NotificationTypeDTOAssembler.getNotificationTypeDtoAssembler;

import java.util.ArrayList;
import java.util.List;

public final class NotificationDTOAssembler implements DTOAssembler<NotificationDto, NotificationDomain> {
    private static final DTOAssembler<NotificationDto, NotificationDomain> instance = new NotificationDTOAssembler();
    private NotificationDTOAssembler() {

    }

    public static DTOAssembler<NotificationDto, NotificationDomain> getNotificationDTOAssembler() {
        return instance;
    }

    @Override
    public NotificationDto toDTO(NotificationDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new NotificationDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var taskUserTmp = getTaskUserDTOAssembler().toDTO(domainTmp.getTaskUser());
        var notificationTypeTmp = getNotificationTypeDtoAssembler().toDTO(domainTmp.getNotificationType());
        return new NotificationDto(domainTmp.getId(),taskUserTmp, domainTmp.getMessage(),domainTmp.getTriggerDate(),notificationTypeTmp);

    }

    @Override
    public NotificationDomain toDomain(NotificationDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new NotificationDto(UUIDHelper.getUUIDHelper().getDefault()));
        var taskUserTmpDomain = getTaskUserDTOAssembler().toDomain(dtoTmp.getTaskUser());
        var notificationTypeTmp = getNotificationTypeDtoAssembler().toDomain(dtoTmp.getNotificationType());
        return new NotificationDomain(dtoTmp.getId(), taskUserTmpDomain, dtoTmp.getMessage(),dtoTmp.getTriggerDate(),notificationTypeTmp);
    }

    @Override
    public List<NotificationDto> toDTO(List<NotificationDomain> domainList) {
        if(ObjectHelper.isNull(domainList)) {
            return new ArrayList<>();
        }

        var notificationDtoList = new ArrayList<NotificationDto>();
        for (NotificationDomain domain : domainList) {
            notificationDtoList.add(toDTO(domain));
        }
        return notificationDtoList;
    }
}
