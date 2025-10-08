package co.edu.co.extraclase.business.domain;
import java.util.UUID;

import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;

public final class EstadoDomain extends Domain {
	
	private String nombre;
	private String descripcion;
	private ColorDomain color;
	
	public EstadoDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setNombre(TextHelper.getDefault());
		setDescripcion(TextHelper.getDefault());
		setColor(ColorDomain.getDefaultValue());
	}
	
	public EstadoDomain(final UUID id, final String nombre, final String descripcion, final ColorDomain color) {
		super(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setColor(color);
	}
	
	public static EstadoDomain getDefaultValue() {
		return new EstadoDomain();
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

	public ColorDomain getColor() {
		return color;
	}

	public void setColor(final ColorDomain color) {
		this.color = ObjectHelper.getDefault(color, ColorDomain.getDefaultValue());
	}
}
