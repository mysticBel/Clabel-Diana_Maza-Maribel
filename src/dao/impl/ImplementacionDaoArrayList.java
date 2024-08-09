package dao.impl;

import dao.IDAO;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoArrayList implements IDAO<Odontologo> {

    private static int nextId = 1;
    private static final Logger logger = Logger.getLogger(ImplementacionDaoArrayList.class);

    private final ArrayList<Odontologo> odontologos = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(ImplementacionDaoArrayList.nextId);
        ImplementacionDaoArrayList.nextId++;

        odontologos.add(odontologo);
        logger.info("Odontólogo guardado en memoria: " + odontologo);

        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        logger.info("Listado de odontólogos en memoria: " + odontologos);
        return new ArrayList<>(odontologos);
    }

}
