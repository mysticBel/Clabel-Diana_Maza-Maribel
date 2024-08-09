package Test;

import dao.BD;
import modelo.Odontologo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicio.OdontologoServicio;

import java.sql.Connection;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoListarTest {
    private OdontologoServicio odontologoServicio;

    @BeforeEach
    void setUp() throws Exception {
        odontologoServicio = new OdontologoServicio();
        try (Connection connection = BD.DatabaseManager.getConnection()) {
            connection.createStatement().execute("TRUNCATE TABLE odontologo");


            // Creamos y guardamos algunos odontólogos de prueba
            Odontologo odontologo1 = new Odontologo("Juana", "Perez", 54678);
            Odontologo odontologo2 = new Odontologo("Ana", "Gomez", 98755);
            odontologoServicio.guardar(odontologo1);
            odontologoServicio.guardar(odontologo2);
        }
    }
    @Test
    void listarTodos()throws Exception {
        List<Odontologo> odontologos = odontologoServicio.listarTodos();

        assertEquals(2, odontologos.size());

        //
        Odontologo odontologo1 = odontologos.get(0);
        assertEquals("Juana", odontologo1.getNombre());
        assertEquals("Perez", odontologo1.getApellido());
        assertEquals(54678, odontologo1.getNumeroMatricula());

        //
        Odontologo odontologo2 = odontologos.get(1);
        assertEquals("Ana", odontologo2.getNombre());
        assertEquals("Gomez", odontologo2.getApellido());
        assertEquals(98755, odontologo2.getNumeroMatricula());
    }
}