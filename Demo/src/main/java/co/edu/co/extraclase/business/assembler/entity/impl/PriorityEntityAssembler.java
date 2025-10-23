package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.UnitOfMeasureEntityAssembler.getUnitOfMeasureEntityAssembler;
import static co.edu.co.extraclase.business.assembler.entity.impl.ColorEntityAssembler.getColorEntityAssembler;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.PriorityDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import co.edu.co.extraclase.entity.PriorityEntity;

public final class PriorityEntityAssembler implements EntityAssembler<PriorityEntity, PriorityDomain> {
	private static final EntityAssembler<PriorityEntity, PriorityDomain> instance = new PriorityEntityAssembler();
	
	private PriorityEntityAssembler() {
		
	}
	
	public static EntityAssembler<PriorityEntity, PriorityDomain> getPriorityEntityAssembler() {
		return instance;
	}

	@Override
	public PriorityEntity toEntity(PriorityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PriorityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var unitOfMeasureTmp = getUnitOfMeasureEntityAssembler().toEntity(domainTmp.getUnitOfMeasure());
		var colorTmp = getColorEntityAssembler().toEntity(domainTmp.getColor());
		return new PriorityEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), 
		domainTmp.getResponseTime(), unitOfMeasureTmp, colorTmp);
	}

	@Override
	public PriorityDomain toDomain(PriorityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new PriorityEntity());
		var unitOfMeasureDomainTmp = getUnitOfMeasureEntityAssembler().toDomain(entityTmp.getUnitOfMeasure());
		var colorDomainTmp = getColorEntityAssembler().toDomain(entityTmp.getColor());
		return new PriorityDomain(entityTmp.getPriorityId(), entityTmp.getName(), entityTmp.getDescription(), 
				entityTmp.getResponseTime(), unitOfMeasureDomainTmp, colorDomainTmp);
	}
}
