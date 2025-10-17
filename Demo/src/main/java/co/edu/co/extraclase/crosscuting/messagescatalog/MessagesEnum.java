package co.edu.co.extraclase.crosscuting.messagescatalog;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	 USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía.","La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNINAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula.","La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),

	    USER_ERROR_SQL_CONNECTION_IS_OPEN("Conexión contra la fuente de información deseada abierta.","La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está abierta. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada.","La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada. Por favor, intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNINAL_ERROR_SQL_CONNECTION_IS_OPEN("Conexión contra la fuente de información deseada abierta.","La conexión requerida para llevar a cabo la operación contra la base de datos está abierta."),

	    TECHNINAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada.","La conexión requerida para llevar a cabo la operación contra la base de datos está cerrada."),

	    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada ", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"),

	    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presento un error de tipo SQLException al validar si la conexión contra base de datos estaba o no abierta." ),

	    USER_ERROR_TRANSACTION_IS_STARTED("Transacción iniciada", "Se ha iniciado una transacción válida para ejecutar la operación solicitada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	    
	    USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada", "No se ha iniciado una transacción válida para ejecutar la operación solicitada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción iniciada en la fuente de datos", "Se intentó ejecutar una operación existiendo una transacción activa en la conexión actual."),

	    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada en la fuente de datos", "Se intentó ejecutar una operación sin que existiera una transacción activa en la conexión actual."),

	    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN("Error inesperado validando si la transacción esta abierta", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada estaba abierta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_OPEN( "Error inesperado validando si la transacción estaba abierta",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido abierta. No fue una SQLException, sino un error no controlado en el proceso de validación."),

	    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_CLOSED("Error inesperado validando si la transacción esta cerrada", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada estaba cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_CLOSED( "Error inesperado validando si la transacción estaba cerrada",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido cerrada. No fue una SQLException, sino un error no controlado en el proceso de validación."),

	    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando el estado de la transacción", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando el estado de la transacción", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada NO estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	    
	    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED( "Error inesperado validando si la transacción estaba iniciada",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),

		TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED( "Error inesperado validando si la transacción NO estaba iniciada",  "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos NO había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),

	    USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error comprobando si la transacción estaba iniciada", "Se presentó un error mientras se verificaba si la transacción había sido iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL validando si la transacción estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos había sido iniciada."),

	    USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_OPEN("Ocurrió un error comprobando si la transacción estaba abierta", "Se presentó un error mientras se verificaba si la transacción estaba abierta. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_OPEN("Error SQL validando si la transacción estaba abierta", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos estaba abierta."),

	    USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_CLOSED("Ocurrió un error comprobando si la transacción estaba cerrada", "Se presentó un error mientras se verificaba si la transacción estaba cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_CLOSED("Error SQL validando si la transacción estaba cerrada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos estaba cerrada."),

	    USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Ocurrió un error comprobando si la transacción no estaba iniciada", "Se presentó un error mientras se verificaba si la transacción NO había sido iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error SQL validando si la transacción NO estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos NO había sido iniciada."),

	    USER_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("No se pudo validar el estado debido a un error", "Se presentó un error tratando de conectar con la base de datos. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos", "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa o disponible.");

private String title;
private String content;
private MessagesEnum(final String title, final String content) {

	setTitle(title);
	setContent(content);
}
public String getTitle() {
	return title;
}
public void setTitle(final String title) {
	this.title = TextHelper.getDefaultWithTrim(title);
}
public String getContent() {
	return content;
}
public void setContent(final String content) {
	this.content = TextHelper.getDefaultWithTrim(content);
}



	
}