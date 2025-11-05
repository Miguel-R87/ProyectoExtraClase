package co.edu.co.extraclase.crosscuting.messagescatalog;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	USER_ERROR_FACTORY_NOT_INITIALIZED("Factoria no iniciada", "La fuente de información sobre la cual se va a realizar la transacción seleccionada no esta disponible dentro del sistema. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
	
	TECHNICAL_ERROR_FACTORY_NOT_VALIDATED("Factotoria no validada", "La factoria de acceso a datos no existe y por tanto no se puede determinar a que fuente de datos debe conectarse."),
	
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

	    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Transacción iniciada en la fuente de datos", "Se intentó ejecutar una operación existiendo una transacción activa en la conexión current."),

	    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Transacción no iniciada en la fuente de datos", "Se intentó ejecutar una operación sin que existiera una transacción activa en la conexión current."),

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

	    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS("Error SQL validando el estado de la conexión contra la base de datos", "Se presentó una excepción de tipo SQLException al intentar validar si la conexión contra la base de datos se encontraba activa o disponible."),
	    
	    USER_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante el registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
		
	    TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_REGISTERING_USER("Error inesperado durante la operación de registro de un nuevo usuario", "Se ha presentado un problema inesperado durante la operación de registro de un nuevo usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),

	    USER_ERROR_WHEN_REGISTERING_USER_NULL_USER("Usuario nulo al registrar usuario.", "Se recibió un objeto nulo al intentar registrar un usuario."),
	    
	    TECHNICAL_ERROR_WHEN_REGISTERING_USER_NULL_USER("Error técnico: usuario nulo.", "Se intentó registrar un usuario pero el objeto UserDomain fue nulo."),

	    USER_ERROR_WHEN_REGISTERING_USER_INVALID_USERNAME("Nombre de usuario inválido.", "El nombre de usuario debe tener entre 2 y 50 caracteres y no puede estar vacío."),
	    
	      TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_USERNAME("Error técnico: nombre de usuario inválido.", "Validación fallida para el nombre de usuario: longitud fuera del rango 2-50 o valor vacío."),

	    USER_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL("Correo electrónico inválido.", "El correo electrónico debe tener un formato válido y su longitud debe estar entre 10 y 60 caracteres."),
	    
	    TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_EMAIL("Error técnico: correo inválido.", "Validación fallida para el email: formato inválido o longitud fuera del rango 9-60."),

	    USER_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME("Nombres inválidos.", "El nombre debe tener entre 2 y 60 caracteres y no puede estar vacío."),
	    
	      TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_FIRST_NAME("Error técnico: nombres inválidos.", "Validación fallida para firstName: longitud fuera del rango 2-60 o valor vacío."),

	    USER_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME("Apellidos inválidos.", "El apellido debe tener entre 2 y 60 caracteres y no puede estar vacío."),
	   
	    TECHNICAL_ERROR_WHEN_REGISTERING_USER_INVALID_LAST_NAME("Error técnico: apellidos inválidos.", "Validación fallida para lastName: longitud fuera del rango 2-60 o valor vacío."),

	    USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_USERNAME("Nombre de usuario duplicado.", "Ya existe un usuario con el mismo nombre de usuario."),
	    
	    TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_USERNAME("Error técnico: nombre de usuario duplicado.", "Se intentó registrar un usuario con un username ya existente en la base de datos."),

	    USER_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("Correo electrónico duplicado.", "Ya existe un usuario con el mismo correo electrónico."),
	    
	    TECHNICAL_ERROR_WHILE_REGISTERING_USER_DUPLICATED_EMAIL("Error técnico: correo duplicado.", "Se intentó registrar un usuario con un email ya existente en la base de datos."),

		USER_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER("Error inesperado durante la actualización de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de actualización de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
		
		TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_UPDATING_USER("Error inesperado durante la operación de actualización de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de actualización de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de registro."),
	
	USER_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la operación de consulta de la información de un usuario. Por favor intente de nuevo y si el problema persiste contacte al administrador del sistema."),
		
	TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_FINDING_USER("Error inesperado durante la operación de consulta de la información de un usuario", "Se ha presentado un problema inesperado durante la de la operación de consulta de la información de un usuario. No fue una SQLException, sino un error no controlado en el proceso de consulta."),
		
		USER_ERROR_TRYING_TO_MAKE_AN_OPERATION("Error tratando de llevar a cabo la operación", "Se ha presentado un error tratando de llevar a cabo la operación esperada"),
		
	USER_SUCESSFULLY_REGISTERED("El Usuario fue registrado con éxito", "El Registro del usuario se llevo a cabo con éxito"),
		TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringIsPresentRule"),
		
		TECHNICAL_ERROR_WRONG_STRING_LENGTH_IS_PRESENT("No fueron ingresados todos los parametros", "Se requerían 3 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringIsPresentRule"),
		
		USER_ERROR_WRONG_LENGTH("El dato ingresado tiene una longitud incorrecta",  "El siguiente dato debe tener una longituda de: " ),
		
		  TECHNICAL_ERROR_WRONG_LENGTH("El dato ingresado tiene una longitud incorrecta", "La regla StringLengthValueIsValidRule fallo ya que el siguiente dato debe tener la siguiente longitud: "),

		TECHNICAL_ERROR_UUID_IS_DEFAULT("UUID por defecto", "La operacion no pudo ser llevada a cabo, ya que en el el siguiente dato fue ingresado el uuid por defecto: "),
		
	USER_ERROR_INCOMPLETE_PARAMETERS("No se enviaron todos los datos necesarios", "El dato es necesario para llevar a cabo la operación: "),
		
		TECHNICAL_ERROR_INCOMPLETE_PARAMETERS("No se enviaron todos los datos necesarios", "La regla StringValueIsPresent falló porque el siguiente dato requerido para llevar a cabo la operación está vacío: "),
		
		 TECHNICAL_ERROR_STRING_LENGTH_VALUE("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValueIsValidRule"),

		   TECHNICAL_ERROR_WRONG_STRING_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 5 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringLengthValueIsValidRule"),

		TECHNICAL_ERROR_STRING_FORMAT_VALUE("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla StringFormatValueIsValidRule"),

TECHNICAL_ERROR_WRONG_STRING_FORMAT_VALUE("No fueron ingresados todos los parametros", "Se requerían 4 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringFormatValueIsValidRule"),

		USER_ERROR_WRONG_FORMAT("El dato ingresado tiene un formato incorrecto",  "El siguiente dato NO cumple con los caracteres estipulados para este campo: " ),
		
		TECHNICAL_ERROR_WRONG_FORMAT("El dato ingresado tiene un formato incorrecto", "La regla StringFormatValueIsValidRule fallo ya que el siguiente dato debe contener solo los siguientes caracteres:  "),
		
		TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
		
		  TECHNICAL_ERROR_VALUE_USER_DOES_NOT_EXISTS_BY_USERNAME("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserUsernameDoesNotExistRule"),
		
		USER_ERROR_USER_DOES_EXISTS_BY_USERNAME("Ya hay un usuario registrado con ese nombre de usuario", "No es posible llevar a cabo la operación, ya que ya existe un usuario con el mismo nombre de usuario"),

		 TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_EMAIL("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserEmailDoesNotExistsRule"),
		
		TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_USER_DOES_NOT_EXISTS_BY_USERNAME("No fueron ingresados todos los parametros", "Se requerían * parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserUsernameDoesNotExistRule"),		
		
		USER_ERROR_USER_DOES_EXISTS_BY_EMAIL("Ya hay un usuario registrado con ese email", "No es posible llevar a cabo la operación, ya que ya existe un usuario con el email"),
		
		TECHNICAL_ERROR_USER_DOES_EXISTS_BY_EMAIL("Ya hay un usuario registrado con ese email", "No es posible llevar a cabo la operación, ya que ya existe un usuario dentro de la fuente de datos con el mismo email "),
		
		TECHNICAL_ERROR_USER_DOES_EXISTS_BY_USERNAME("Ya hay un usuario registrado con ese nombre de usuario", "No es posible llevar a cabo la operación, ya que ya existe un usuario dentro de la fuente de datos con el mismo nombre de usuario "),

		TECHNICAL_ERROR_VALUE_IS_NOT_PRESENT_USER("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar la regla UserExistsByIdRule"),
		
		TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE("No fueron ingresados todos los parametros", "Se requerían 2 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla UserExistsByIdRule"),
		
		USER_ERROR_USER_DOES_NOT_EXITS("El usuario no existe", "El usuario ingresada no existe"),
		
		TECHNICAL_ERROR_USER_DOES_NOT_EXITS("El usuario no existe", "El usuario con el siguiente id no existe: "),
		
		TECHNICAL_ERROR_VALUE_USER_IS_NOT_PRESENT("Error tratando de llevar a cabo la operación", "No se recibieron los parametros requeridos para ejecutar el validator ValidateDataUserConsistencyForRegisterNewInformation"),
		
		TECHNICAL_ERROR_WRONG_USER_LENGTH_VALUE_IS_NOT_PRESENT("No fueron ingresados todos los parametros", "Se requería 1 parametro y llegó una cantidad menor a esta requerida para ejecutar el validator ValidateDataUserConsistencyForRegisterNewInformation"),

		
		;

	
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