package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.ColorEntityAssembler.getColorEntityAssembler;
import java.util.ArrayList;
import java.util.List;
import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.StatusDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.StatusEntity;

public final class StatusEntityAssembler implements EntityAssembler<StatusEntity, StatusDomain> {
	
	private static final EntityAssembler<StatusEntity, StatusDomain> instance = new StatusEntityAssembler();
	
	private StatusEntityAssembler() {
		
	}
	
	public static EntityAssembler<StatusEntity, StatusDomain> getStatusEntityAssembler() {
		return instance;
	}

	@Override
	public StatusEntity toEntity(StatusDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new StatusDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var colorTmp = getColorEntityAssembler().toEntity(domainTmp.getColor());
		return new StatusEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), colorTmp);
	}

	@Override
	public StatusDomain toDomain(StatusEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new StatusEntity());
		var colorDomainTmp = getColorEntityAssembler().toDomain(entityTmp.getColor());
		return new StatusDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription(), colorDomainTmp);
	}

	@Override
	public List<StatusDomain> toDomain(List<StatusEntity> entityList) {
		var statusDomainList = new ArrayList<StatusDomain>();
		
		for (var statusEntity : entityList) {
			statusDomainList.add(toDomain(statusEntity));
		}
		return statusDomainList;
	}
}
