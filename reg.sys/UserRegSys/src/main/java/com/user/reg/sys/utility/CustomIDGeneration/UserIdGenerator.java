package com.user.reg.sys.utility.CustomIDGeneration;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UserIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) {
        String prefix="USR";
        try {
            Connection connection = sharedSessionContractImplementor.getSessionFactory().getSessionFactoryOptions()
                    .getServiceRegistry().getService(ConnectionProvider.class).getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(USER_id) as Id from USER_DATA");
            if (rs.next()) {
                int id = rs.getInt(1) + 101;
                String generatedId = prefix + new Integer(id).toString();
                return generatedId;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
