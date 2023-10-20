package it.contrader.dao;

import it.contrader.model.MedicalExamination;
import it.contrader.model.User;
import it.contrader.utils.ConnectionSingleton;

import javax.swing.text.html.parser.Entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicalExaminationDAO implements DAO<MedicalExamination> {


    private final String QUERY_ALL = "SELECT * FROM visita";
    private final String QUERY_CREATE = "INSERT INTO visita (id_visita, nome, tipologia, costo, codice, orari, img) VALUES (?,?,?,?,?,?,?)";
    private final String QUERY_READ = "SELECT * FROM visita WHERE id_visita=?";
    private final String QUERY_UPDATE = "UPDATE visita SET nome=?, tipologia=?, costo=?, codice=?, orari=?, img=? WHERE id_visita=?";
    private final String QUERY_DELETE = "DELETE FROM visita WHERE id_visita=?";
    private final String QUERY_IDME = "select visita.Id_Visita from visita join prenotazione on prenotazione.id_user=? where prenotazione.Id_Visita=visita.Id_Visita;";
    private final String QUERY_COUNT = "select count(*) from visita WHERE tipologia=?";
    private final String QUERY_SEARCH = "Select * from visita where id_visita=?";

    public MedicalExaminationDAO() {

    }

    public List<MedicalExamination> getAll() {

        List<MedicalExamination> medicalExaminationList = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();

        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            MedicalExamination medicalExamination;
            while (resultSet.next()) {

                int id = resultSet.getInt("Id_Visita");
                String typology = resultSet.getString("tipologia");
                double cost = resultSet.getDouble("costo");
                long code = resultSet.getLong("codice");
                String img = resultSet.getString("img");
                medicalExamination = new MedicalExamination(typology, cost, code, img);
                medicalExamination.setId(id);
                medicalExaminationList.add(medicalExamination);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalExaminationList;
    }

    @Override
    public MedicalExamination read(int id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String typology, img;
            double cost;
            long code;


            typology = resultSet.getString("tipologia");
            cost = resultSet.getDouble("costo");
            code = resultSet.getLong("codice");
            img = String.valueOf(resultSet.getLong("img"));


            MedicalExamination medicalExamination = new MedicalExamination(typology, cost, code, img);
            medicalExamination.setId(resultSet.getInt("id_visita"));

            return medicalExamination;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean insert(MedicalExamination medicalExaminationToInsert) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
            preparedStatement.setLong(1, medicalExaminationToInsert.getId());
            preparedStatement.setString(3, medicalExaminationToInsert.getTypology());
            preparedStatement.setDouble(4, medicalExaminationToInsert.getCost());
            preparedStatement.setLong(5, medicalExaminationToInsert.getCode());
            preparedStatement.setString(7, medicalExaminationToInsert.getImg());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(MedicalExamination medicalExamination) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
/*
    @Override
    public boolean update(MedicalExamination medicalExaminationToUpdate) {
        Connection connection = ConnectionSingleton.getInstance();

        if (medicalExaminationToUpdate.getId() == 0)
            return false;

        MedicalExamination medicalExaminationread = read((int) medicalExaminationToUpdate.getId());

                if (medicalExaminationToUpdate.getTypology() == null || medicalExaminationToUpdate.getTypology().equals("")) {
                    medicalExaminationToUpdate.setTypology(medicalExaminationread.getTypology());
                }

                if (medicalExaminationToUpdate.getCost() == 0) {
                    medicalExaminationToUpdate.setCost(medicalExaminationread.getCost());
                }

                if (medicalExaminationToUpdate.getCode() == 0){
                    medicalExaminationToUpdate.setCode(medicalExaminationread.getCode());
                }

                PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
                preparedStatement.setString(2, medicalExaminationToUpdate.getTypology());
                preparedStatement.setDouble(3, medicalExaminationToUpdate.getCost());
                preparedStatement.setLong(4, medicalExaminationToUpdate.getCode());
                preparedStatement.setString(6, medicalExaminationToUpdate.getImg());
                preparedStatement.setLong(7,medicalExaminationToUpdate.getId());
                int a = preparedStatement.executeUpdate();
                if (a > 0)
                    return true;
                else
                    return false;

            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setLong(1, id);
            int n = preparedStatement.executeUpdate();
            if (n != 0)
                return true;

        } catch (SQLException e) {
        }
        return false;
    }




   public int statistic(String type){
        Connection connection = ConnectionSingleton.getInstance();
        try {


            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_COUNT);
            preparedStatement.setString(1,type);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int statistic = resultSet.getInt("count(*)");

            return statistic;
        } catch (SQLException e) {
            return 0;
        }

    }


    public MedicalExamination search(int id) {
        Connection connection = ConnectionSingleton.getInstance();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SEARCH);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String name,typology;
            double cost;
            long code;
            String hours,img;
            int userId;


            name = resultSet.getString("nome");
            typology = resultSet.getString("tipologia");
            cost = resultSet.getDouble("costo");
            code = resultSet.getLong("codice");
            hours = resultSet.getString("orari");
            img = resultSet.getString("img");
//            userId = resultSet.getInt("userId");
            MedicalExamination medicalExamination = new MedicalExamination(name,typology,cost,code,hours,img);
            medicalExamination.setId(resultSet.getInt("id_visita"));


            return medicalExamination;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
*/