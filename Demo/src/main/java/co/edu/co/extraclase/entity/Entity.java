package co.edu.co.extraclase.entity;

import co.edu.co.extraclase.crosscuting.helper.UUIDHelper;
import java.util.UUID;

class Entity {

    private UUID id;

    protected Entity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
    }

    protected Entity(final UUID id) {
        setId(id);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }
}
