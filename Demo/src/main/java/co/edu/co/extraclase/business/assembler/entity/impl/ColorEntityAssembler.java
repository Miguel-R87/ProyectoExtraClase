package co.edu.co.extraclase.business.assembler.entity.impl;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.ColorDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.ColorEntity;

public final class ColorEntityAssembler implements EntityAssembler<ColorEntity, ColorDomain> {
	private static final EntityAssembler<ColorEntity, ColorDomain> instance = new ColorEntityAssembler();
	
	private ColorEntityAssembler() {
	}
	
	public static EntityAssembler<ColorEntity, ColorDomain> getColorEntityAssembler() {
		return instance;
	}

	@Override
	public ColorEntity toEntity(ColorDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ColorDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new ColorEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getHexCode());
	}

	@Override
	public ColorDomain toDomain(ColorEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ColorEntity());
		return new ColorDomain(entityTmp.getColorId(), entityTmp.getName(), entityTmp.getHexCode());
	}
}
