package co.edu.co.extraclase.data.dao.entity;


import java.util.UUID;

import co.edu.co.extraclase.data.dao.CreateDAO;
import co.edu.co.extraclase.data.dao.RetrieveDAO;
import co.edu.co.extraclase.entity.NotificationEntity;

public interface NotificationDAO extends CreateDAO<NotificationEntity>, RetrieveDAO<NotificationEntity, UUID> {

}
