package co.edu.co.extraclase.business.domain;
import java.time.LocalDate;
import java.util.UUID;	
import co.edu.co.extraclase.crosscuting.helper.DateHelper;
import co.edu.co.extraclase.crosscuting.helper.ObjectHelper;
import co.edu.co.extraclase.crosscuting.helper.TextHelper;
import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;	



public final  class TareaDomain extends Domain{
	private String titulo;
	private String descripcion;	
	private LocalDate fechaCreacion;		
	private LocalDate fechaLimite;
	private ListaDomain lista;	
	private EstadoDomain estado;	
	private PrioridadDomain prioridad;	
	
	public TareaDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setTitulo(TextHelper.getDefault());
        setDescripcion(TextHelper.getDefault());
        setLista(ListaDomain.getDefaultValue());	
        setEstado(EstadoDomain.getDefaultValue());
        setPrioridad(PrioridadDomain.getDefaultValue());
        setFechaCreacion(DateHelper.getDefault());
        setFechaLimite(DateHelper.getDefault());
        	
	} 
	public TareaDomain(final UUID id,final String titulo,final String descripcion,final LocalDate fechaCreacion,final LocalDate fechaLimite,
			final ListaDomain lista,final EstadoDomain estado,final PrioridadDomain prioridad) {
		super(id);
		setTitulo(titulo);
		setDescripcion(descripcion);
		setLista(lista);
		setFechaCreacion(fechaCreacion);
		setFechaLimite(fechaLimite);
		setEstado(estado);
		setPrioridad(prioridad);
		
	}
	
	String getTitulo() {	
		return titulo;
	}
	 String getDescripcion() {
		 return descripcion;
	 }
	 ListaDomain getLista() {
		 return lista;
	 }
	 EstadoDomain getEstado() {
		 return estado;
	 }
	 PrioridadDomain getPrioridad() {
		 return prioridad;
	 }
	 LocalDate getFechaCreacion() {
		 return fechaCreacion;
	 }
	 LocalDate getFechaLimite() {
		 return fechaLimite;
	 }	
	
void setTitulo(final String titulo){
	this.titulo=TextHelper.getDefaultWithTrim(titulo);
	}
	void setDescripcion(final String descripcion) {
		 this.descripcion=TextHelper.getDefaultWithTrim(descripcion);
	 }
	 void setLista(final ListaDomain lista) {
	 this.lista	=ObjectHelper.getDefault(lista, ListaDomain.getDefaultValue());
	 }
	 void setEstado(final EstadoDomain estado) {
		 this.estado=ObjectHelper.getDefault(estado,EstadoDomain.getDefaultValue());
	 }
	 void setPrioridad(final PrioridadDomain prioridad) {
		 this.prioridad=ObjectHelper.getDefault(prioridad, PrioridadDomain.getDefaultValue());
		 
	 }
	 void setFechaCreacion(final LocalDate fechaCreacion) {
		 this.fechaCreacion=DateHelper.getDefault(fechaCreacion);
	 }
	 void setFechaLimite(final LocalDate fechaLimite) {
		 this.fechaLimite=DateHelper.getDefault(fechaLimite);
	 }
	 
	 TareaDomain getDefaultValue() {
		 return new TareaDomain();
	 }	
	 
	 
	 
	 
	


}