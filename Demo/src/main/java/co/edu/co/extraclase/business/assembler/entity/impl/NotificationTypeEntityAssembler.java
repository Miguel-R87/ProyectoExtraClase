package co.edu.co.extraclase.business.assembler.entity.impl;

import java.util.List;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.NotificationTypeDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.NotificationTypeEntity;

public final class NotificationTypeEntityAssembler implements EntityAssembler<NotificationTypeEntity, NotificationTypeDomain> {
	private static final EntityAssembler<NotificationTypeEntity, NotificationTypeDomain> instance = new NotificationTypeEntityAssembler();
	
	private NotificationTypeEntityAssembler() {
		
	}
	
	public static EntityAssembler<NotificationTypeEntity, NotificationTypeDomain> getNotificationTypeEntityAssembler() {
		return instance;
	}

	@Override
	public NotificationTypeEntity toEntity(NotificationTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new NotificationTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new NotificationTypeEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
	}

	@Override
	public NotificationTypeDomain toDomain(NotificationTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new NotificationTypeEntity());
		return new NotificationTypeDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription());
	}

	@Override
	public List<NotificationTypeDomain> toDomain(List<NotificationTypeEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
