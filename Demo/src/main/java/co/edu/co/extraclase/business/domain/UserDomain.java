package co.edu.co.extraclase.business.domain;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.DateTimeHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import co.edu.co.extraclase.crosscuting.helper.BooleanHelper;

public class UserDomain extends Domain {
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

    public UserDomain(){
        super(UUIDHelper.getUUIDHelper().getDefault());
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

    public UserDomain(final UUID id) {
        super(id);
        setFirstName(TextHelper.getDefault());
        setLastName(TextHelper.getDefault());
        setUsername(TextHelper.getDefault());
        setEmail(TextHelper.getDefault());
        setEmailConfirmation(BooleanHelper.getDefault());
        setRegistrationDate(LocalDateTime.now());
        setPasswordHash(TextHelper.getDefault());
        setAccountStatus(BooleanHelper.getDefault());
        setSuperUser(BooleanHelper.getDefault());
        setSuperUserConfirmation(BooleanHelper.getDefault());
    }

    public UserDomain(final UUID id, final String firstName, final String lastName, final String username,
                      final String email, final boolean emailConfirmation, final String passwordHash,
                      final boolean accountStatus, final boolean isSuperUser, final boolean superUserConfirmation ,
                      final LocalDateTime registrationDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.emailConfirmation = emailConfirmation;
        this.passwordHash = passwordHash;
        this.accountStatus = accountStatus;
        this.isSuperUser = isSuperUser;
        this.superUserConfirmation = superUserConfirmation;
        this.registrationDate = registrationDate;
    }

    static UserDomain getDefaultValue() {
        return new UserDomain();
    }

    static UserDomain getDefaultValue(final UserDomain user) {
        return ObjectHelper.getDefault(user, getDefaultValue());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailConfirmation() {
        return emailConfirmation;
    }

    public void setEmailConfirmation(boolean emailConfirmation) {
        this.emailConfirmation = emailConfirmation;
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
        this.accountStatus = accountStatus;
    }

    public boolean isSuperUser() {
        return isSuperUser;
    }

    public void setSuperUser(boolean superUser) {
        isSuperUser = superUser;
    }

    public boolean isSuperUserConfirmation() {
        return superUserConfirmation;
    }

    public void setSuperUserConfirmation(boolean superUserConfirmation) {
        this.superUserConfirmation = superUserConfirmation;
    }
}


