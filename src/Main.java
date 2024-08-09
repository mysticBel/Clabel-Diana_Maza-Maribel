import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String filePath = new File("").getAbsolutePath();
        BD.DatabaseManager.createTableFromFile(filePath.concat("/src/script.sql"));

    Odontologo odontologo1 = new Odontologo(
            "Javier",
            "Salinas",
            12345);

    Odontologo odontologo2 = new Odontologo(
                "Daniela",
                "Chavez",
                43216);

    OdontologoServicio servicio = new OdontologoServicio();

    servicio.guardar(odontologo1);
    servicio.guardar(odontologo2);

        System.out.println("Este es el odontologo");
        System.out.println(odontologo1.toString());

        System.out.println("Esta es el listado de Odontologos");
        servicio.listarTodos();
    }

}
