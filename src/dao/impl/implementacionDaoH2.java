package dao.impl;

import dao.BD;
import dao.IDAO;
import modelo.Odontologo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class implementacionDaoH2 implements IDAO<Odontologo> {

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
       try{
           connection = BD.DatabaseManager.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "INSERT INTO ODONTOLOGO(" +
                           "nombre, apellido, numeroMatricula) VALUES " +
                           "(?,?,?)", Statement.RETURN_GENERATED_KEYS
           );
           preparedStatement.setString(1, odontologo.getNombre());
           preparedStatement.setString(2, odontologo.getApellido());
           preparedStatement.setInt(3, odontologo.getNumeroMatricula());

           preparedStatement.execute();

           ResultSet rs = preparedStatement.getGeneratedKeys();
           while (rs.next()) {
               odontologo.setId(rs.getInt(1));
               System.out.println("Se guardó el odontologo con nombre " +
                       odontologo.getNombre());
           }

       }catch (Exception e) {
           e.printStackTrace();
       } finally {
           try {
               connection.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.DatabaseManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGO"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));

                odontologoList.add(odontologo);

                System.out.println(odontologo.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }
}
