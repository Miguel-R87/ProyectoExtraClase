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
    private boolean superUserConfirmation;
    private boolean emailConfirmation;
    private boolean accountStatusDefaultValue;
    private boolean isSuperUserDefaultValue;
    private boolean superUserConfirmationDefaultValue;
    private boolean emailConfirmationDefaultValue;
	
	
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
        setSuperUserConfirmation(false);
        setEmailConfirmation(false);
        setEmailConfirmationDefaultValue(true);
        setAccountStatusDefaultValue(true);
        setSuperUserDefaultValue(true);
        setSuperUserConfirmationDefaultValue(true);
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
        setSuperUserConfirmation(false);
        setEmailConfirmation(false);
        setEmailConfirmationDefaultValue(true);
        setAccountStatusDefaultValue(true);
        setSuperUserDefaultValue(true);
        setSuperUserConfirmationDefaultValue(true);
    }
    
    public UserEntity(UUID id, String firstName, String lastName, String username, String email,
boolean emailConfirmation, LocalDateTime registrationDate, String passwordHash, boolean accountStatus,
boolean isSuperUser, boolean superUserConfirmation) {
		setId(id);
		setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setEmail(email);
        setEmailConfirmation(emailConfirmation);
        setPasswordHash(passwordHash);
        setAccountStatus(accountStatus);
      setSuperUser(isSuperUser);
       setSuperUserConfirmation(superUserConfirmation);
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

	public void setId(UUID userId) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(userId);
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

	
 
	//AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	 // ---------------- SUPER USER ----------------
    public boolean isSuperUser() {
        return isSuperUser;
    }

    public boolean isSuperUserDefaultValue() {
        return isSuperUserDefaultValue;
    }

    public void setSuperUserConfirm(final boolean isSuperUser) {
        this.isSuperUser = isSuperUser;
        setSuperUserDefaultValue(false);
    }

    // compatibility setter used by constructors and external callers
    public void setSuperUser(final boolean isSuperUser) {
        setSuperUserConfirm(isSuperUser);
    }

    public void setSuperUserDefaultValue(final boolean isSuperUserDefaultValue) {
        this.isSuperUserDefaultValue = isSuperUserDefaultValue;
    }

    // ---------------- SUPER USER CONFIRMATION ----------------
    public boolean isSuperUserConfirmation() {
        return superUserConfirmation;
    }

    public boolean isSuperUserConfirmationDefaultValue() {
        return superUserConfirmationDefaultValue;
    }

    public void setSuperUserConfirmation(final boolean superUserConfirmation) {
        this.superUserConfirmation = superUserConfirmation;
        setSuperUserConfirmationDefaultValue(false);
    }

    public void setSuperUserConfirmationDefaultValue(final boolean superUserConfirmationDefaultValue) {
        this.superUserConfirmationDefaultValue = superUserConfirmationDefaultValue;
    }

    // ---------------- ACCOUNT STATUS ----------------
    public boolean isAccountStatus() {
        return accountStatus;
    }

    public boolean isAccountStatusDefaultValue() {
        return accountStatusDefaultValue;
    }

    public void setAccountStatus(final boolean accountStatus) {
        this.accountStatus = accountStatus;
        setAccountStatusDefaultValue(false);
        setEmailConfirmationDefaultValue(false);
    }

    public void setAccountStatusDefaultValue(final boolean accountStatusDefaultValue) {
        this.accountStatusDefaultValue = accountStatusDefaultValue;
    }
    public void setEmail(String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public boolean isEmailConfirmation() {
        return emailConfirmation;
    }

    public boolean isEmailConfirmationDefaultValue() {
        return emailConfirmationDefaultValue;
    }

    public void setEmailConfirmation(final boolean emailConfirmation) {
        this.emailConfirmation = emailConfirmation;
        setEmailConfirmationDefaultValue(false);
        
    }
    
    public void setEmailConfirmationDefaultValue(final boolean emailConfirmationDefaultValue) {
        this.emailConfirmationDefaultValue = emailConfirmationDefaultValue;
    }

}