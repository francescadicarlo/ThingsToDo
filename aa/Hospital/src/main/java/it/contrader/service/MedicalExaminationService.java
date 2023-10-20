package it.contrader.service;

import it.contrader.converter.MedicalExaminationConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.MedicalExaminationDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.MedicalExamination;
import it.contrader.model.User;

public class MedicalExaminationService extends AbstractService<User, UserDTO> {

    //Istanzio DAO  e Converter specifici.
    public MedicalExaminationService(){
        this.dao = new MedicalExaminationDAO();
        this.converter = new MedicalExaminationConverter();
    }



}
