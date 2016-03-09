# jdbc-logging-driver
A pass-through JDBC driver that intercepts and logs all SQL calls.


# Usage
- Add jdbc-logging-driver jar to your CLASSPATH
- Change your JDBC connection URL prefix "jdbc:*" to read "jdbc:logging:*"
- Configure your logging system (jdbc-logging-driver uses slf4j)
