package co.edu.co.extraclase.business.domain;


import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class ColorDomain extends Domain {

	private String nombre;
	private String codigoHEX;
	private UnidadMedidaDomain unidadMedida;
	
	public ColorDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setNombre(TextHelper.getDefault());
		setCodigoHEX(TextHelper.getDefault());
		setUnidadMedida(UnidadMedidaDomain.getDefaultValue());
	}
	
	public ColorDomain(final UUID id, final String nombre, final String codigoHEX, final UnidadMedidaDomain unidadMedida) {
		super(id);
		setNombre(nombre);
		setCodigoHEX(codigoHEX);
		setUnidadMedida(unidadMedida);
	}
	
	public static ColorDomain getDefaultValue() {
		return new ColorDomain();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = TextHelper.getDefaultWithTrim(nombre);
	}

	public String getCodigoHEX() {
		return codigoHEX;
	}

	public void setCodigoHEX(final String codigoHEX) {
		this.codigoHEX = TextHelper.getDefaultWithTrim(codigoHEX);
	}

	public UnidadMedidaDomain getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(final UnidadMedidaDomain unidadMedida) {
		this.unidadMedida = ObjectHelper.getDefault(unidadMedida, UnidadMedidaDomain.getDefaultValue());
	}
}
