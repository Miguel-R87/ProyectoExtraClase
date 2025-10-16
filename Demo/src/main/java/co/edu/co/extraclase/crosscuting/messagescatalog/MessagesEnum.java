package co.edu.co.extraclase.crosscuting.messagescatalog;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
	USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada", "La conexión requerida para llevar a cabo la operación contra la base de datos llegó cerrada."),
	USER_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXCEPTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos está o no abierta."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Problema inesperado validando el estado de la conexión contra la fuente de datos deseada", "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS("Error inesperado validando si la conexión contra la base de datos estaba abierta", "Se presentó un error de tipo SQLException al validar si la conexión contra la base de datos estaba o no abierta."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando el estado de la transacción", "Ocurrió un problema inesperado al validar si la transacción contra la fuente de información deseada estaba iniciada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED("Error SQL validando si la transacción estaba iniciada", "Se presentó un error de tipo SQLException mientras se verificaba si la transacción en la conexión con la base de datos había sido iniciada."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos", "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa o disponible."),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED("Error inesperado validando si la transacción estaba iniciada", "Se presentó un problema inesperado al intentar validar si la transacción contra la base de datos había sido iniciada. No fue una SQLException, sino un error no controlado en el proceso de validación."),
	
	
	USER_ERROR_TRANSACTION_IS_STARTED( "", "Ya hay una transacción activa. Finalice la transacción antes de iniciar una nueva."),
	TECHNICAL_ERROR_TRANSACTION_IS_STARTED( "Transacción ya iniciada", "El modo de auto-commit está desactivado, lo que indica que ya hay una transacción activa."	),

	
	
	USER_ERROR_FACTORY_NOT_INITIALIZED("La fuente de informacion sobre la cual se va ir a realizar la transacción seleccionada no esta disponible en el sistema", "No se ha inicializado la fábrica de DAO. Por favor contacte al administrador de la aplicación."),
	TECHNICAL_ERROR_FACTORY_NOT_INITIALIZED("La factoria que me pidieron no existe", "No se ha inicializado la fábrica de DAO."),
	
	
	
	
	USER_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada", "No se ha iniciado la transacción contra la fuente de información deseada. Por favor intente de nuevo."),
	TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED( "Transacción no iniciada", "La conexión indica que el modo de auto-commit está activado, por lo tanto no se ha iniciado la transacción."),
	TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si el autocommit contra la base de datos estaba desactivado", "Se presentó un error de tipo SQLException al validar si el autocommit habia sido desactivado ."),
	USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando el manejo de operaciones contra la fuente de datos", "Ocurrió un problema inesperado tratando de validar el estado de manejo de operaciones"),
	TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED("Error inesperado validando si el autocommit contra la base de datos estaba desactivado", "Se presentó un problema inesperado al validar si el autocommit habia sido desactivado. No fue una SQLException, sino un error no controlado en el proceso de validación.");
	
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