package co.edu.co.extraclase.data.dao.entity;

import java.util.UUID;

import co.edu.co.extraclase.data.dao.CreateDAO;
import co.edu.co.extraclase.data.dao.RetrieveDAO;
import co.edu.co.extraclase.data.dao.UpdateDAO;
import co.edu.co.extraclase.entity.ProjectEntity;

public interface ProjectUserDAO extends CreateDAO<ProjectEntity>,
RetrieveDAO<ProjectEntity,UUID>, 
UpdateDAO<ProjectEntity>
 {

}




