package co.edu.co.extraclase.business.domain;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.DateHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

import java.time.LocalDate;


public final class ListaDomain extends Domain {
	private String nombre;
	private LocalDate fechaCreacion;	
	
	public ListaDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setNombre(TextHelper.getDefault());
		setFechaCreacion(DateHelper.getDefault());
		
	}
	public ListaDomain(final UUID id, final String nombre, final LocalDate fechaCreacion) {
		super(id);
		setNombre(nombre);
		setFechaCreacion(fechaCreacion);
	}
	
	void setNombre(final String nombre) {
		this.nombre = TextHelper.getDefaultWithTrim(nombre);
	}
	void setFechaCreacion(final LocalDate fechaCreacion) {
		this.fechaCreacion = DateHelper.getDefault(fechaCreacion);
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechacreacion() {
		return fechaCreacion;
	}	
	public static ListaDomain getDefaultValue() {
		return new ListaDomain();
	}
	



}
