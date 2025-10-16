package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UserEntity  {
	
	private UUID userId;
	private String firstName;
    private String lastName;
    private String username;
    private String email;
    private boolean emailConfirmation;
    private LocalDateTime registrationDate;
    private String passwordHash;
    private boolean accountStatus;
    private boolean isSuperUser;
    private boolean superUserConfirmation;
	
	
	
    public UserEntity() {
    	setUserId(UUIDHelper.getUUIDHelper().getDefault());
    	setFirstName(TextHelper.getDefault());
    	setLastName(TextHelper.getDefault());
    	setUsername(TextHelper.getDefault());
    	setEmail(TextHelper.getDefault());
    	setEmailConfirmation(BooleanHelper.getDefault());
    	setRegistrationDate(DateTimeHelper.getDefault());
    	setPasswordHash(TextHelper.getDefault());
    	setAccountStatus(BooleanHelper.getDefault());
    	setSuperUser(BooleanHelper.getDefault());
    	setSuperUserConfirmation(BooleanHelper.getDefault());
    }
    
    public UserEntity(final UUID id) {
    	setUserId(id);
    	setFirstName(TextHelper.getDefault());
    	setLastName(TextHelper.getDefault());
    	setUsername(TextHelper.getDefault());
    	setEmail(TextHelper.getDefault());
    	setEmailConfirmation(BooleanHelper.getDefault());
    	setRegistrationDate(DateTimeHelper.getDefault());
    	setPasswordHash(TextHelper.getDefault());
    	setAccountStatus(BooleanHelper.getDefault());
    	setSuperUser(BooleanHelper.getDefault());
    	setSuperUserConfirmation(BooleanHelper.getDefault());
    }
    
    private  UserEntity(UUID userId, String firstName, String lastName, String username, String email,
 boolean emailConfirmation, LocalDateTime registrationDate, String passwordHash, boolean accountStatus,
 boolean isSuperUser, boolean superUserConfirmation) {
		setUserId(userId);
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setEmail(email);
		setEmailConfirmation(emailConfirmation);
		setRegistrationDate(registrationDate);
		setPasswordHash(passwordHash);
		setAccountStatus(accountStatus);
		setSuperUser(isSuperUser);
		setSuperUserConfirmation(superUserConfirmation);
	}
    
    

	static UserEntity getDefault() {
		return new UserEntity();
	}
	
	static UserEntity getDefault(final UserEntity user) {
		return ObjectHelper.getDefault(user, getDefault());
	}

	
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = UUIDHelper.getUUIDHelper().getDefault(userId);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = TextHelper.getDefaultWithTrim(username);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}

	public boolean isEmailConfirmation() {
		return emailConfirmation;
	}

	public void setEmailConfirmation(boolean emailConfirmation) {
		this.emailConfirmation = BooleanHelper.getDefault(emailConfirmation);
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = DateTimeHelper.getDefault(registrationDate);
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = BooleanHelper.getDefault(accountStatus);
	}

	public boolean isSuperUser() {
		return isSuperUser;
	}

	public void setSuperUser(boolean isSuperUser) {
		this.isSuperUser = BooleanHelper.getDefault(isSuperUser);
	}

	public boolean isSuperUserConfirmation() {
		return superUserConfirmation;
	}

	public void setSuperUserConfirmation(boolean superUserConfirmation) {
		this.superUserConfirmation = BooleanHelper.getDefault(superUserConfirmation);
	}
	
	

}

