package servicio;

import dao.IDAO;
import dao.impl.implementacionDaoH2;
import modelo.Odontologo;

import java.util.List;

public class OdontologoServicio {
    private IDAO<Odontologo> interfazDAO;

    public OdontologoServicio(){
        this.interfazDAO = new implementacionDaoH2();
    }


    public Odontologo guardar(Odontologo odontologo){
        return interfazDAO.guardar(odontologo);
    }
    public List<Odontologo> listarTodos() {
        return interfazDAO.listarTodos();
    }

}
