package co.edu.co.extraclase.business.domain;

import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class PrioridadDomain extends Domain {

	private String nombre;
	private String descripcion;
	private int tiempoHoras;
	private UnidadMedidaDomain unidadMedida;

	public PrioridadDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setNombre(TextHelper.getDefault());
		setDescripcion(TextHelper.getDefault());
		setTiempoHoras(0);
		setUnidadMedida(UnidadMedidaDomain.getDefaultValue());
	}

	public PrioridadDomain(final UUID id, final String nombre, final String descripcion, final int tiempoHoras,
			final UnidadMedidaDomain unidadMedida) {
		super(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setTiempoHoras(tiempoHoras);
		setUnidadMedida(unidadMedida);
	}

	public static PrioridadDomain getDefaultValue() {
		return new PrioridadDomain();
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

	public int getTiempoHoras() {
		return tiempoHoras;
	}

	public void setTiempoHoras(final int tiempoHoras) {
		this.tiempoHoras = tiempoHoras;
	}

	public UnidadMedidaDomain getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(final UnidadMedidaDomain unidadMedida) {
		this.unidadMedida = ObjectHelper.getDefault(unidadMedida, UnidadMedidaDomain.getDefaultValue());
	}
}
