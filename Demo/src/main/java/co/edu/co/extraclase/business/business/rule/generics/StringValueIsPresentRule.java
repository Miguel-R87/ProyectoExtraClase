package co.edu.co.extraclase.business.business.rule.generics;

import co.edu.co.extraclase.business.business.rule.Rule;
import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;

public final class StringValueIsPresentRule implements Rule{
	
	public static final Rule instance = new StringValueIsPresentRule();
	
	private StringValueIsPresentRule() {
		
	}
	
	public static void executeRule(final Object...data ) {
		instance.execute(data);
	}

	@Override
	public void execute(Object... data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema tratando de llevar a cabo la operacion deseada ";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringValueIsPresentRule";
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
		
		if (data.length < 3) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada ";
			var technicalMessage = "Se requerian 3 parametros para ejecutar la regla StringValueIsPresentRule pero solo se recibieron " ;
			throw ExtraClaseException.create(userMessage, technicalMessage);
	}
		var stringdata = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (Boolean) data[2];
		
		if ((mustApplyTrim)
				? TextHelper.isEmptyWithTrim(stringdata)
						: TextHelper.isEmpty(stringdata)) {
			var userMessage = "El dato [".concat(dataName).concat("] es requerido para llevar la operación ");
			var technicalMessage = "La regla StringValueIsPresentRule ha fallado para el dato [".concat(dataName).concat("] porque se recibio un valor nulo o vacio");
			throw ExtraClaseException.create(userMessage, technicalMessage);
		}
	}
		
}


