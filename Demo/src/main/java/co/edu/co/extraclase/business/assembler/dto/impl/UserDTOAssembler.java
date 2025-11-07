package co.edu.co.extraclase.business.assembler.dto.impl;

import co.edu.co.extraclase.business.assembler.dto.DTOAssembler;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.dto.UserDto;
import java.util.ArrayList;
import java.util.List;

public final class UserDTOAssembler implements DTOAssembler<UserDto,UserDomain> {
    
	private static final DTOAssembler<UserDto,UserDomain> instance = new UserDTOAssembler();

    private UserDTOAssembler(){
    	
    }

    public static DTOAssembler<UserDto,UserDomain> getUserDTOAssembler(){
        return instance;
    }

    @Override
    public UserDto toDTO(final UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UserDto(domainTmp.getId(), domainTmp.getFirstName(), domainTmp.getLastName(), domainTmp.getUsername(),
                domainTmp.getEmail(), domainTmp.isEmailConfirmed(), domainTmp.getPasswordHash(),
                domainTmp.isAccountStatus(), domainTmp.isSuperUser(), domainTmp.isSuperUserConfirmed(),
                domainTmp.getRegistrationDate());
    }

    @Override
    public UserDomain toDomain(final UserDto dto) {
    	var dtoTmp = ObjectHelper.getDefault(dto, new UserDto(UUIDHelper.getUUIDHelper().getDefault()));
    	return new UserDomain(dtoTmp.getId(), dtoTmp.getFirstName(), dtoTmp.getLastName(), dtoTmp.getUsername(),
                dtoTmp.getEmail(), dtoTmp.isEmailConfirmed(), dtoTmp.getRegistrationDate(), dtoTmp.getPasswordHash(), dtoTmp.isAccountStatus(),
                dtoTmp.isSuperUser(), dtoTmp.isSuperUserConfirmed());
    }

    @Override
    public List<UserDto> toDTO(final List<UserDomain> domainList) {
        var userDtoList = new ArrayList<UserDto>();
        
        for(UserDomain domain : domainList) {
        	userDtoList.add(toDTO(domain));
        }
        return userDtoList;
    }
}
