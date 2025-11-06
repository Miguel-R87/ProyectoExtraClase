package co.edu.co.extraclase.business.assembler.entity.impl;

import java.util.ArrayList;
import java.util.List;
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
	public UnitOfMeasureEntity toEntity(final UnitOfMeasureDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UnitOfMeasureDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new UnitOfMeasureEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription());
	}

	@Override
	public UnitOfMeasureDomain toDomain(final UnitOfMeasureEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new UnitOfMeasureEntity());
		return new UnitOfMeasureDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription());
	}
	
	@Override
	public List<UnitOfMeasureDomain> toDomain(final List<UnitOfMeasureEntity> entityList) {
		var unitOfMeasureDomainList = new ArrayList<UnitOfMeasureDomain>();
		
		for (var unitOfMeasureEntity : entityList) {
			unitOfMeasureDomainList.add(toDomain(unitOfMeasureEntity));
		}
		return unitOfMeasureDomainList;
	
	}
}
