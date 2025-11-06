package co.edu.co.extraclase.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class UserDomain extends Domain {

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

    public UserDomain() {
    	super(UUIDHelper.getUUIDHelper().getDefault());
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

    public UserDomain(final UUID id) {
        super(id);
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

    public UserDomain(final UUID id, final String firstName, final String lastName, final String username,
                      final String email, final boolean emailConfirmation, final LocalDateTime registrationDate, final String passwordHash,
                      final boolean accountStatus, final boolean isSuperUser, final boolean superUserConfirmation) {
        super(id);
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

    public static UserDomain getDefaultValue() {
        return new UserDomain();
    }

    public static UserDomain getDefaultValue(final UserDomain user) {
        return ObjectHelper.getDefault(user, getDefaultValue());
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
    	return isSuperUserDefaultValue;
    }

    public void setSuperUserConfirm(final boolean isSuperUser) {
    	this.isSuperUser = isSuperUser;
    	setSuperUserDefaultValue(false);
    }

    public void setSuperUser(final boolean isSuperUser) {
        setSuperUserConfirm(isSuperUser);
    }

    public void setSuperUserDefaultValue(final boolean isSuperUserDefaultValue) {
    	this.isSuperUserDefaultValue = isSuperUserDefaultValue;
	}
					
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

	public void setEmail(final String email) {
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
