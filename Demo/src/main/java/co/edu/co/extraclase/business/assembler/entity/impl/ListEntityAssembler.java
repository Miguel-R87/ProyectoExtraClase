package co.edu.co.extraclase.business.assembler.entity.impl;

import static co.edu.co.extraclase.business.assembler.entity.impl.ProjectEntityAssembler.getProjectEntityAssembler;
import java.util.ArrayList;
import java.util.List;
import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.ListDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.ListEntity;

public final class ListEntityAssembler implements EntityAssembler<ListEntity, ListDomain> {
	
	private static final EntityAssembler<ListEntity, ListDomain> instance = new ListEntityAssembler();
	
	private ListEntityAssembler() {
	
	}
	
	public static EntityAssembler<ListEntity, ListDomain> getListEntityAssembler() {
		return instance;
	}

	@Override
	public ListEntity toEntity(final ListDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ListDomain(UUIDHelper.getUUIDHelper().getDefault()));
		var projectTmp = getProjectEntityAssembler().toEntity(domainTmp.getProject());
		return new ListEntity(domainTmp.getId(), domainTmp.getName(), projectTmp, domainTmp.getCreationDate());
	}

	@Override
	public ListDomain toDomain(final ListEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ListEntity());
		var projectDomainTmp = getProjectEntityAssembler().toDomain(entityTmp.getProject());
		return new ListDomain(entityTmp.getId(), entityTmp.getName(), projectDomainTmp, entityTmp.getCreationDate());
	}

	@Override
	public List<ListDomain> toDomain(final List<ListEntity> entityList) {
		var listDomainList = new ArrayList<ListDomain>();
		
		for (var listEntity : entityList) {
			listDomainList.add(toDomain(listEntity));
		}
		return listDomainList;
	}
}
