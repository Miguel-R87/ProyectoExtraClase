package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public final class StringFormatValueIsValidRule implements Rule{
	
	public static final Rule instance = new StringFormatValueIsValidRule();
	
	private StringFormatValueIsValidRule() {
		
	}
	
	public static void executRule(Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = ("Se ha presentado un error tratando de llevar a cabo la operación esperada");
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringFormatValueIsValidRule";
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 4) {
			var userMessage = "Se ha presentado un error tratando de llevar a cabo la operación esperada";
			var technicalMessage = "Se requerían 4 parametros y llegó una cantidad menor a esta requeridos para ejecutar la regla StringFormatValueIsValidRule";
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var pattern = (String) data[2];
		boolean mustApplyTrim = (Boolean) data[3];
		
		if(!TextHelper.formatIsValid(stringData, pattern, mustApplyTrim)) {
			var userMessage= "El siguiente dato NO cumple con los caracteres estipulados para este campo: ".concat(dataName);
			var technicalMessage= "La regla StringFormatValueIsValidRule fallo ya que el siguiente dato debe contener solo los siguientes caracteres:".concat(pattern);
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
	}

}