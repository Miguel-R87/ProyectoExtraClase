package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public final class StringLengthValueIsValidRule implements Rule{
	
	private static final Rule instance = new StringLengthValueIsValidRule();
	
	private StringLengthValueIsValidRule() {
		
	}
	
	public static void executeRule(final Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la operacion deseada ";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValueIsValidRule";
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 5) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la operacion deseada ";
			var technicalMessage = "Se requerian 5 parametros pero no se han recibido los suficientes para continuar con la operacion";
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var minLength = (Integer) data[2];
		var maxLength = (Integer) data[3];
		boolean mustApplyTrim = (boolean) data[4];


		
		if (TextHelper.lengthIsValid(stringData, minLength, maxLength, mustApplyTrim)) {
			var userMessage = "El dato [".concat(dataName).concat("] no tiene una longitud entre ").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength)).concat("...");
			var technicalMessage = "La reglaa StringValueIsPresentRule ha fallado para el dato [".concat(dataName).concat("] porque no tiene una longitud entre").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength)).concat("...");
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}

		
	}	
		
	}


