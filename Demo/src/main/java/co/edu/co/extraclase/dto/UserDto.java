package co.edu.co.extraclase.dto;

import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import java.time.LocalDateTime;
import java.util.UUID;

public final class UserDto {
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
    
    public UserDto() {
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

    public UserDto(final UUID id) {
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
 
    public UserDto(final UUID id, final String firstName, final String lastName, final String username,
                   final String email, final boolean emailConfirmed, final String passwordHash,
                   final boolean accountStatus, final boolean isSuperUser, 
                   final boolean superUserConfirmed, final LocalDateTime registrationDate) {
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

    public static UserDto getDefaultValue() {
        return new UserDto();
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

    public boolean isSuperUserIsDefaultValue() {
        return isSuperUserIsDefaultValue;
    }

    public void setSuperUserConfirm(final boolean isSuperUser) {
        this.isSuperUser = isSuperUser;
        setSuperUserIsDefaultValue(false);
    }

    public void setSuperUser(final boolean isSuperUser) {
        setSuperUserConfirm(isSuperUser);
    }

    public void setSuperUserIsDefaultValue(final boolean isSuperUserIsDefaultValue) {
        this.isSuperUserIsDefaultValue = isSuperUserIsDefaultValue;
    }

    public boolean isSuperUserConfirmed() {
        return superUserConfirmed;
    }

    public boolean isSuperUserConfirmedIsDefaultValue() {
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

    public boolean isAccountStatusIsDefaultValue() {
        return accountStatusIsDefaultValue;
    }

    public void setAccountStatus(final boolean accountStatus) {
        this.accountStatus = accountStatus;
        setAccountStatusIsDefaultValue(false);
        setEmailConfirmedIsDefaultValue(false);
    }

    public void setAccountStatusIsDefaultValue(final boolean accountStatusIsDefaultValue) {
        this.accountStatusIsDefaultValue = accountStatusIsDefaultValue;
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