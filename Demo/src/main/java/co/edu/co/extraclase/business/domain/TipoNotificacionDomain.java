package co.edu.co.extraclase.business.domain;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class TipoNotificacionDomain extends Domain {

	private String nombre;
	private String descripcion;

	public TipoNotificacionDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setNombre(TextHelper.getDefault());
		setDescripcion(TextHelper.getDefault());
	}

	public TipoNotificacionDomain(final UUID id, final String nombre, final String descripcion) {
		super(id);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public static TipoNotificacionDomain getDefaultValue() {
		return new TipoNotificacionDomain();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = TextHelper.getDefaultWithTrim(nombre);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.getDefaultWithTrim(descripcion);
	}
}
