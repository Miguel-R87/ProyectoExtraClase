package co.edu.co.extraclase.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.co.extraclase.crosscuting.exception.ExtraClaseException;
import co.edu.co.extraclase.crosscuting.helper.*;

import co.edu.co.extraclase.data.dao.entity.ListDAO;
import co.edu.co.extraclase.data.dao.entity.SqlConnection;
import co.edu.co.extraclase.entity.ListEntity;
import co.edu.co.extraclase.entity.ProjectEntity;

public class ListPostgreSqlDAO extends SqlConnection implements ListDAO{

    public ListPostgreSqlDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void create(ListEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("INSERT INTO \"Lista\" (\"listaId\", \"nombre\", \"fechaCreacion\", \"proyectoId\") ");
        sql.append("VALUES (?, ?, ?, ?)");

        try(var preparedStatement =getConnection().prepareStatement(sql.toString())){
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setObject(3, entity.getCreationDate());
            preparedStatement.setObject(4,entity.getProject().getId());

            preparedStatement.executeUpdate();

        } catch (final SQLException exception){
            var userMessage = "";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = "";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public List<ListEntity> findAll() {
        return findByFilter(new ListEntity());
    }

    @Override
    public List<ListEntity> findByFilter(ListEntity filterEntity) {
        var parametersList = new ArrayList<Object>();
        var sql = createSentenceFindByFilter(filterEntity, parametersList);
        try (var preparedStatement = this.getConnection().prepareStatement(sql)) {
            for (int index = 0; index < parametersList.size(); index++) {
                preparedStatement.setObject(index + 1, parametersList.get(index));
            }
            return executeSentenceFindByFilter(preparedStatement);
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "";
            var technicalMessage = "a";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
    }

    private String createSentenceFindByFilter(ListEntity filterEntity, List<Object> parametersList) {
        final var sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("  L.\"listaId\" AS \"idL\", ");
        sql.append("  L.\"nombre\" AS \"nombreL\", ");
        sql.append("  L.\"fechaCreacion\" AS \"fechaCreacionL\", ");
        sql.append("  P.\"proyectoId\" AS \"idP\", ");
        sql.append("  P.\"nombre\" AS \"nombreP\" ");
        sql.append("FROM \"Lista\" AS L ");
        sql.append("INNER JOIN \"Proyecto\" AS P ON L.\"proyectoId\" = P.\"proyectoId\" ");
        createWhereClauseFindByFilter(sql, parametersList, filterEntity);
        return sql.toString();
    }

    private void createWhereClauseFindByFilter(final StringBuilder sql, final List<Object> parametersList, final ListEntity filterEntity) {
        var filterEntityValidated = ObjectHelper.getDefault(filterEntity, new ListEntity());
        final var conditions = new ArrayList<String>();
        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getId()),
                "L.\"listaId\" = ", filterEntityValidated.getId());
        addCondition(conditions, parametersList,!TextHelper.isEmptyWithTrim(filterEntityValidated.getName()),
                "L.\"nombre\" = ", filterEntityValidated.getName());
        addCondition(conditions, parametersList, !DateTimeHelper.isDefaultDate(filterEntityValidated.getCreationDate()),
                "L.\"fechaCreacion\" = ", filterEntityValidated.getCreationDate());
        addCondition(conditions, parametersList, !UUIDHelper.getUUIDHelper().isDefaultUUID(filterEntityValidated.getProject().getId()),
                "L.\"proyectoId\" = ", filterEntityValidated.getProject().getId());

        if(!conditions.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", conditions));
        }
    }

    private void addCondition(final List<String> conditions, final List<Object> parametersList, final boolean condition,
                              final String clause, final Object value) {
        if (condition) {
            conditions.add(clause + " ?");
            parametersList.add(value);
        }
    }

    private List<ListEntity> executeSentenceFindByFilter(final PreparedStatement preparedStatement) {
        var listList =  new ArrayList<ListEntity>();
        try (var resulSet = preparedStatement.executeQuery()){
            while(resulSet.next()){
                var project = new ProjectEntity();
                project.setId(UUIDHelper.getUUIDHelper().getFromString(resulSet.getString("idP")));
                project.setName(resulSet.getString("nombreP"));

                var list = new ListEntity();
                list.setId(UUIDHelper.getUUIDHelper().getFromString(resulSet.getString("idL")));
                list.setName(resulSet.getString("nombreL"));
                list.setCreationDate(resulSet.getTimestamp("fechaCreacionL").toLocalDateTime());
                list.setProject(project);
                listList.add(list);
            }
        } catch(final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final ExtraClaseException exception) {
            var userMessage = "a";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }
        return listList;
    }

    @Override
    public void update(ListEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("UPDATE \"Lista\" ");
        sql.append("SET ");
        sql.append("\"nombre\" = ?, ");
        sql.append("\"proyectoId\" = ? ");
        sql.append("WHERE \"listaId\" = ?");

        try (var preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setObject(2, entity.getProject().getId());
            preparedStatement.setObject(3, entity.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException exception) {
            var userMessage = "";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception) {
            var userMessage = "a";
            var technicalMessage = "";
            throw ExtraClaseException.create(exception, userMessage, technicalMessage);
        }


}}


