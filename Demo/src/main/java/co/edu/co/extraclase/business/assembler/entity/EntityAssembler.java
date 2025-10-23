package co.edu.co.extraclase.business.assembler.entity;

public interface EntityAssembler<E, D> {
	
	E toEntity(D domain);
	
	D toDomain(E entity);

}
