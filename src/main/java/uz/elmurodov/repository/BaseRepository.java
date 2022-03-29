package uz.elmurodov.repository;

import lombok.SneakyThrows;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.exception.CustomerSQLException;

import java.io.Serializable;
import java.sql.*;

public class BaseRepository {
    protected Connection connection = UNIContainer.getBean(Connection.class);
    private Object[] args;

    protected Serializable callProcedure(String query, int outType) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            ResultSet resultSet = statement.executeQuery();
            return prepareResultSet(resultSet, outType);
        } catch (SQLException ex) {
            throw new CustomerSQLException(ex.getMessage(), ex.getCause());
        }
    }
    protected void callProcedure(String query) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            statement.execute();
        } catch (SQLException ex) {
            throw new CustomerSQLException(ex.getMessage(), ex.getCause());
        }
    }

    @SneakyThrows
    private Serializable prepareResultSet(ResultSet resultSet, int outType) {
        if (resultSet.next()) {
            return switch (outType) {
                case Types.VARCHAR -> resultSet.getString(1);
                case Types.BIGINT -> resultSet.getLong(1);
                case Types.BOOLEAN -> resultSet.getBoolean(1);
                default -> throw new IllegalStateException("Unexpected value: " + outType);
            };
        }
        return null;
    }

    @SneakyThrows
    private void prepareToExecute(CallableStatement statement) {
        for (int i = 0; i < this.args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    protected void prepareArguments(Object... args) {
        this.args = args;
    }

}
