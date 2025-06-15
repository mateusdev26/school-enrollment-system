package conn;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionFactoryTest {
@Test
public void ConnectionShouldNotThrowSQLException() {
assertDoesNotThrow(ConnectionFactory::getConnection,"Didn't threw a SQLException");
}

}

