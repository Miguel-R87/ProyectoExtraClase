package co.edu.co.extraclase.business.assembler.entity.impl;

import co.edu.co.extraclase.business.assembler.entity.EntityAssembler;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain>{
	
	private static final EntityAssembler<UserEntity, UserDomain> instance = new UserEntityAssembler();
	private UserEntityAssembler() {
		
	}
	
	public static EntityAssembler<UserEntity, UserDomain> getUserEntityAssembler() {
		return instance;
	}

	@Override
	public UserEntity toEntity(UserDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
		return new UserEntity(domainTmp.getId(), domainTmp.getFirstName(), domainTmp.getLastName(), domainTmp.getUsername(),
		domainTmp.getEmail(), domainTmp.isEmailConfirmation(), domainTmp.getRegistrationDate(), domainTmp.getPasswordHash(),
		domainTmp.isAccountStatus(), domainTmp.isSuperUser(), domainTmp.isSuperUserConfirmation());
	}

	@Override
	public UserDomain toDomain(UserEntity entity) {
		var entityTmp =  ObjectHelper.getDefault(entity, new UserEntity());
		return new UserDomain(entityTmp.getId(), entityTmp.getFirstName(), entityTmp.getLastName(), entityTmp.getUsername(),
		entityTmp.getEmail(), entityTmp.isEmailConfirmation(), entityTmp.getRegistrationDate(), entityTmp.getPasswordHash(), 
		entityTmp.isAccountStatus(), entityTmp.isSuperUser(), entityTmp.isSuperUserConfirmation());
	}
}
