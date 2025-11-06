package co.edu.co.extraclase.crosscuting.helper;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import java.sql.Connection;
import java.sql.SQLException;
import co.edu.co.extraclase.crosscuting.messagescatalog.MessagesEnum;

public final class SqlConnectionHelper {

    private SqlConnectionHelper() {
    
    }

    public static void ensureConnectionIsNotNull(final Connection connection) {
        if (ObjectHelper.isNull(connection)) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            var technicalMessage = MessagesEnum.TECHNINAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            throw ExtraClaseException.create(userMessage, technicalMessage);
        }
    }

    public static void ensureConnectionIsOpen(final Connection connection) {

        ensureConnectionIsNotNull(connection);

        try {
            if (connection.isClosed()) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                var technicalMessage = MessagesEnum.TECHNINAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                throw ExtraClaseException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS
                    .getContent();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS
                    .getContent();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }

    public static void ensureTransactionIsStarted(final Connection connection) {

        ensureConnectionIsOpen(connection);

        try {
            if (connection.getAutoCommit()) {
                var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED.getContent();
                throw ExtraClaseException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED
                    .getContent();
           throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED
                    .getContent();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }

    public static void ensureTransactionIsNotStarted(final Connection connection) {

        ensureConnectionIsOpen(connection);

        try {
                if (!connection.getAutoCommit()) {
                    var userMessage = MessagesEnum.USER_ERROR_TRANSACTION_IS_STARTED.getContent();
                    var technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_IS_STARTED.getContent();
                    throw ExtraClaseException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED
                    .getContent();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED
                    .getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED
                  .getContent();
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }
}