package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.UnitOfMeasureEntityAssembler.getUnitOfMeasureEntityAssembler;
import java.util.ArrayList;
import java.util.List;
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
	public PriorityEntity toEntity(final PriorityDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new PriorityDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var unitOfMeasureTmp = getUnitOfMeasureEntityAssembler().toEntity(domainTmp.getUnitOfMeasure());
		var colorTmp = getColorEntityAssembler().toEntity(domainTmp.getColor());
		return new PriorityEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), 
		domainTmp.getResponseTime(), unitOfMeasureTmp, colorTmp);
	}

	@Override
	public PriorityDomain toDomain(final PriorityEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new PriorityEntity());
		var unitOfMeasureDomainTmp = getUnitOfMeasureEntityAssembler().toDomain(entityTmp.getUnitOfMeasure());
		var colorDomainTmp = getColorEntityAssembler().toDomain(entityTmp.getColor());
		return new PriorityDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription(),
				entityTmp.getResponseTime(), unitOfMeasureDomainTmp, colorDomainTmp);
	}

	@Override
	public List<PriorityDomain> toDomain(final List<PriorityEntity> entityList) {
		var priorityDomainList = new ArrayList<PriorityDomain>();
		
		for (var priorityEntity : entityList) {
			priorityDomainList.add(toDomain(priorityEntity));
		}
		return priorityDomainList;
	}
}
