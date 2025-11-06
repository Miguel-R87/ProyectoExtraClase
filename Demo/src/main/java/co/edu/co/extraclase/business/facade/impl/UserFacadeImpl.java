package co.edu.co.extraclase.business.facade.impl;

import java.util.List;
import java.util.UUID;
import co.edu.co.extraclase.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.co.extraclase.business.business.impl.UserBusinessImpl;
import co.edu.co.extraclase.business.domain.UserDomain;
import co.edu.co.extraclase.business.facade.UserFacade;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;
import co.edu.co.extraclase.data.dao.factory.DAOFactory;
import co.edu.co.extraclase.dto.UserDto;

public final class UserFacadeImpl implements UserFacade {
	
	@Override
	public void registerNewUserInformation(final UserDto userDto) {
		var daoFactory = DAOFactory.getFactory();
		
		var business=new UserBusinessImpl(daoFactory);

       try {
    	   daoFactory.initTransaction();   
    	   var domain=UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
    	   business.registerNewUserInformation(domain);
    	   
    	   
    	   daoFactory.commitTransaction();
    	   
       } catch(final ExtraClaseException exception) {
		   daoFactory.rollbackTransaction();
		   throw exception;
       } catch(final Exception exception) {
		   daoFactory.rollbackTransaction();
		   var  userMessage=MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER.getContent();
		   var technicalMessage=MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER.getContent();
		   throw ExtraClaseException.create(exception, userMessage, technicalMessage);
	
       } finally {
		   daoFactory.closeConnection();
       }
	}

	@Override
	public UserDomain loginUser(String Email, String passwordHash) {
throw ExtraClaseException.create(
				MessagesEnum.USER_ERROR_METHOD_NOT_IMPLEMENTED.getContent(),
				MessagesEnum.TECHNICAL_ERROR_METHOD_NOT_IMPLEMENTED.getContent());
	}

	@Override
	public void updateUserInformation(final UUID id, final UserDto userDto) {
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDto);
			
			business.updateUserInformation(id, userDomain);
			
			daoFactory.commitTransaction();
			
		} catch (final ExtraClaseException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER.getContent();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void sendUserEmailConfirmationCode(UUID id) {
		throw ExtraClaseException.create(
				MessagesEnum.USER_ERROR_METHOD_NOT_IMPLEMENTED.getContent(),
				MessagesEnum.TECHNICAL_ERROR_METHOD_NOT_IMPLEMENTED.getContent());		
	}

	@Override
	public void sendSuperUserConfirmationCode(UUID id) {
		throw ExtraClaseException.create(
				MessagesEnum.USER_ERROR_METHOD_NOT_IMPLEMENTED.getContent(),
				MessagesEnum.TECHNICAL_ERROR_METHOD_NOT_IMPLEMENTED.getContent());		
	}

	@Override
	public boolean confirmCode(UUID id, String code, String confirmationType) {
		throw ExtraClaseException.create(
				MessagesEnum.USER_ERROR_METHOD_NOT_IMPLEMENTED.getContent(),
				MessagesEnum.TECHNICAL_ERROR_METHOD_NOT_IMPLEMENTED.getContent());
	}

	@Override
	public List<UserDto> findUsersByFilter(final UserDto userFilters) {
		
		var daoFactory = DAOFactory.getFactory();
		var business = new UserBusinessImpl(daoFactory);
		
		try {
			
			daoFactory.initTransaction();
			
			var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userFilters);
			
			return UserDTOAssembler.getUserDTOAssembler().toDTO(business.findUsersByFilter(userDomain));
			
		} catch (final ExtraClaseException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER.getContent();
			throw ExtraClaseException.create(exception, userMessage, technicalMessage);
			
		} finally {
			daoFactory.closeConnection();
		}
	}
}
