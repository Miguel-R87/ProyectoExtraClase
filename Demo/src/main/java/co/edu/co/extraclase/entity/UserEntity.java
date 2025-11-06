package co.edu.co.extraclase.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

 public final class UserEntity {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private LocalDateTime registrationDate;
    private String passwordHash;
    private boolean accountStatus;
    private boolean isSuperUser;
    private boolean superUserConfirmed;
    private boolean emailConfirmed;
    private boolean accountStatusIsDefaultValue;
    private boolean isSuperUserIsDefaultValue;
    private boolean superUserConfirmedIsDefaultValue;
    private boolean emailConfirmedIsDefaultValue;
	
    public UserEntity() {
    	setId(UUIDHelper.getUUIDHelper().getDefault());
    	setFirstName(TextHelper.getDefault());
        setLastName(TextHelper.getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setRegistrationDate(DateTimeHelper.getDefault());
        setPasswordHash(TextHelper.getDefault());
        setAccountStatus(false);
        setSuperUser(false);
        setSuperUserConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setAccountStatusIsDefaultValue(true);
        setSuperUserIsDefaultValue(true);
        setSuperUserConfirmedIsDefaultValue(true);
    }
    
	public UserEntity(final UUID id) {
    	setId(id);
    	setFirstName(TextHelper.getDefault());
        setLastName(TextHelper.getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setRegistrationDate(DateTimeHelper.getDefault());
        setPasswordHash(TextHelper.getDefault());
        setAccountStatus(false);
        setSuperUser(false);
        setSuperUserConfirmed(false);
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setAccountStatusIsDefaultValue(true);
        setSuperUserIsDefaultValue(true);
        setSuperUserConfirmedIsDefaultValue(true);
    }
    
    public UserEntity(final UUID id, final String firstName, final String lastName, final String username, final String email,
final boolean emailConfirmed, final LocalDateTime registrationDate, final String passwordHash, final boolean accountStatus,
final boolean isSuperUser, final boolean superUserConfirmed) {
		setId(id);
		setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setEmail(email);
        setEmailConfirmed(emailConfirmed);
        setPasswordHash(passwordHash);
        setAccountStatus(accountStatus);
        setSuperUser(isSuperUser);
        setSuperUserConfirmed(superUserConfirmed);
        setRegistrationDate(registrationDate);
	}
    
	static UserEntity getDefault() {
		return new UserEntity();
	}
	
	static UserEntity getDefault(final UserEntity user) {
		return user == null ? getDefault() : user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID userId) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(userId);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = TextHelper.getDefaultWithTrim(username);
	}

	public String getEmail() {
        return email;
    }

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(final LocalDateTime registrationDate) {
		this.registrationDate = DateTimeHelper.getDefault(registrationDate);
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(final String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
    public boolean isSuperUser() {
        return isSuperUser;
    }

    public boolean isSuperUserDefaultValue() {
        return isSuperUserIsDefaultValue;
    }

    public void setSuperUserConfirm(final boolean isSuperUser) {
        this.isSuperUser = isSuperUser;
        setSuperUserIsDefaultValue(false);
    }

    public void setSuperUser(final boolean isSuperUser) {
        setSuperUserConfirm(isSuperUser);
    }

    public void setSuperUserIsDefaultValue(final boolean isSuperUserDefaultValue) {
        this.isSuperUserIsDefaultValue = isSuperUserDefaultValue;
    }

    public boolean isSuperUserConfirmed() {
        return superUserConfirmed;
    }

    public boolean isSuperUserConfirmedDefaultValue() {
        return superUserConfirmedIsDefaultValue;
    }

    public void setSuperUserConfirmed(final boolean superUserConfirmed) {
        this.superUserConfirmed = superUserConfirmed;
        setSuperUserConfirmedIsDefaultValue(false);
    }

    public void setSuperUserConfirmedIsDefaultValue(final boolean superUserConfirmedIsDefaultValue) {
        this.superUserConfirmedIsDefaultValue = superUserConfirmedIsDefaultValue;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public boolean isAccountStatusDefaultValue() {
        return accountStatusIsDefaultValue;
    }

    public void setAccountStatus(final boolean accountStatus) {
        this.accountStatus = accountStatus;
        setAccountStatusIsDefaultValue(false);
        setEmailConfirmedIsDefaultValue(false);
    }

    public void setAccountStatusIsDefaultValue(final boolean accountStatusDefaultValue) {
        this.accountStatusIsDefaultValue = accountStatusDefaultValue;
    }
    
    public void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public boolean isEmailConfirmedIsDefaultValue() {
        return emailConfirmedIsDefaultValue;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
        setEmailConfirmedIsDefaultValue(false);
        
    }
    
    public void setEmailConfirmedIsDefaultValue(final boolean emailConfirmedIsDefaultValue) {
        this.emailConfirmedIsDefaultValue = emailConfirmedIsDefaultValue;
    }
}