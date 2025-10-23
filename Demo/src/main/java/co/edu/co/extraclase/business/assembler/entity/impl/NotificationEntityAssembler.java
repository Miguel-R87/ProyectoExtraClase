package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.TaskUserEntityAssembler.getTaskUserEntityAssembler;
import static co.edu.co.extraclase.business.assembler.entity.impl.NotificationTypeEntityAssembler.getNotificationTypeEntityAssembler;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.NotificationDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.NotificationEntity;

public class NotificationEntityAssembler implements EntityAssembler<NotificationEntity, NotificationDomain> {
	private static final EntityAssembler<NotificationEntity, NotificationDomain> instance = new NotificationEntityAssembler();
	
	private NotificationEntityAssembler() {
		
	}
	
	public static EntityAssembler<NotificationEntity, NotificationDomain> getNotificationEntityAssembler() {
		return instance;
	}

	@Override
	public NotificationEntity toEntity(NotificationDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new NotificationDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var taskUserTmp = getTaskUserEntityAssembler().toEntity(domainTmp.getTaskUser());
		var notificationTypeTmp = getNotificationTypeEntityAssembler().toEntity(domainTmp.getNotificationType());
		return new NotificationEntity(domainTmp.getId(), taskUserTmp, domainTmp.getMessage(), domainTmp.getTriggerDate(), 
		notificationTypeTmp);
	}

	@Override
	public NotificationDomain toDomain(NotificationEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new NotificationEntity());
		var taskUserDomainTmp = getTaskUserEntityAssembler().toDomain(entityTmp.getTaskUser());
		var notificationTypeDomainTmp = getNotificationTypeEntityAssembler().toDomain(entityTmp.getNotificationType());
		return new NotificationDomain(entityTmp.getNotificationId(), taskUserDomainTmp, entityTmp.getMessage(), entityTmp.getTriggerDate(), 
		notificationTypeDomainTmp);
	}
}
