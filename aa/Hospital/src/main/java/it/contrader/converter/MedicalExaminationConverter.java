package it.contrader.converter;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.MedicalExamination;
import it.contrader.model.User;

import java.util.ArrayList;
import java.util.List;

public class MedicalExaminationConverter implements Converter <MedicalExamination, MedicalExaminationDTO> {
    public MedicalExaminationDTO toDTO(MedicalExamination medicalExamination){
        MedicalExaminationDTO medicalExaminationDTO=new MedicalExaminationDTO(
                medicalExamination.getId(),
                medicalExamination.getTypology(),
                medicalExamination.getCost(),
                medicalExamination.getCode(),
                medicalExamination.getImg());
                return medicalExaminationDTO;
    }
    public MedicalExamination toEntity(MedicalExaminationDTO medicalExaminationDTO){
        MedicalExamination medicalExamination=new MedicalExamination(
                medicalExaminationDTO.getId(),
                medicalExaminationDTO.getTypology(),
                medicalExaminationDTO.getCost(),
                medicalExaminationDTO.getCode(),
                medicalExaminationDTO.getImg());
        return medicalExamination;
    }

    public List<MedicalExaminationDTO> toDTOList(List<MedicalExamination> medicalExaminationList) {
        //Crea una lista vuota.
        List<MedicalExaminationDTO> medicalExaminationDTOList = new ArrayList<MedicalExaminationDTO>();

        //Cicla tutti gli elementi della lista e li converte uno a uno
        for(MedicalExamination medicalExamination : medicalExaminationList) {
            //Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
            //e lo aggiunge adda lista di DTO
            medicalExaminationDTOList.add(toDTO(medicalExamination));
        }
        return medicalExaminationDTOList;
    }
}

