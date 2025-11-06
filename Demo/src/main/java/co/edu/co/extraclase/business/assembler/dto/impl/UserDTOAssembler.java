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
    public UserDto toDTO(UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UserDto(domainTmp.getId(), domainTmp.getFirstName(), domainTmp.getLastName(), domainTmp.getUsername(),
                domainTmp.getEmail(), domainTmp.isEmailConfirmation(), domainTmp.getPasswordHash(),
                domainTmp.isAccountStatus(), domainTmp.isSuperUser(), domainTmp.isSuperUserConfirmation(),
                domainTmp.getRegistrationDate());
    }

    @Override
    public UserDomain toDomain(UserDto dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UserDto(UUIDHelper.getUUIDHelper().getDefault()));
        return new UserDomain(dtoTmp.getId(), dtoTmp.getFirstName(), dtoTmp.getLastName(), dtoTmp.getUsername(),
                dtoTmp.getEmail(), dtoTmp.isEmailConfirmation(), dtoTmp.getRegistrationDate(), dtoTmp.getPasswordHash(), dtoTmp.isAccountStatus(),
                dtoTmp.isSuperUser(), dtoTmp.isSuperUserConfirmation());
    }

    @Override
    public List<UserDto> toDTO(List<UserDomain> domainList) {
        var UserDtoList = new ArrayList<UserDto>();
        
        for(UserDomain domain : domainList) {
        	UserDtoList.add(toDTO(domain));
        }
        return UserDtoList;
    }
}
