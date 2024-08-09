import dao.BD;
import modelo.Odontologo;
import servicio.OdontologoServicio;

public class Main {
    public static void main(String[] args) {
        BD.DatabaseManager.createTableFromFile("D:\\escritorio2024\\Digital House\\workspace-backend\\Clabel-Diana_Maza-Maribel\\src\\script.sql");

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
