package dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class BD {


    public class DatabaseManager {

        public static void createTableFromFile(String filePath) {
            Connection connection = null;

            try {
                connection = getConnection();
                Statement statement = connection.createStatement();

                // Leer el archivo .sql y ejecutar su contenido
                String sql = readSqlFile(filePath);
                statement.execute(sql);

                System.out.println("Tabla creada con éxito.");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private static String readSqlFile(String filePath) throws Exception {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            }
            return sb.toString();
        }

        public static Connection getConnection() throws Exception {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        }

    }


}
