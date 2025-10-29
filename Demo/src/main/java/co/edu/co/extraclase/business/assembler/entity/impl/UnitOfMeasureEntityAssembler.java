package co.edu.co.extraclase.business.assembler.entity.impl;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.UnitOfMeasureDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.UnitOfMeasureEntity;

public final class UnitOfMeasureEntityAssembler implements EntityAssembler<UnitOfMeasureEntity, UnitOfMeasureDomain>{
	
	private static final EntityAssembler<UnitOfMeasureEntity, UnitOfMeasureDomain> instance = new UnitOfMeasureEntityAssembler();
	
	private UnitOfMeasureEntityAssembler() {
		}
	
	public static EntityAssembler<UnitOfMeasureEntity, UnitOfMeasureDomain> getUnitOfMeasureEntityAssembler() {
		return instance;
	}

	@Override
	public UnitOfMeasureEntity toEntity(UnitOfMeasureDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UnitOfMeasureDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new UnitOfMeasureEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
	}

	@Override
	public UnitOfMeasureDomain toDomain(UnitOfMeasureEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new UnitOfMeasureEntity());
		return new UnitOfMeasureDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription());
	}
}
