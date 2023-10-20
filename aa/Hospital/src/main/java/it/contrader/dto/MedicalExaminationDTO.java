package it.contrader.dto;

import java.util.TimeZone;

public class    MedicalExaminationDTO extends UserDTO {

    private int id;
    private String typology;

    private double cost;

    private long code;
    private String img;

    private int userId;

    public MedicalExaminationDTO(int id, String name, String typology, double cost, long code, String hours, String img) {
        this.id = id;
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.img = img;
    }

    public MedicalExaminationDTO(int id, String name, String typology, double cost, long code, String hours, String img,int userId) {
        this.id = id;
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.img = img;
        this.userId=userId;
    }

    public MedicalExaminationDTO(String name, String typology, double cost, long code, String hours, String img) {
        this.typology = typology;
        this.cost = cost;
        this.code = code;
        this.img = img;
    }

    public MedicalExaminationDTO() {
    }

    public MedicalExaminationDTO(String id, String typology, String cost, String code, String img) {
    }

    public MedicalExaminationDTO(int id, String typology, double cost, long code, String img) {
    }

    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "MedicalExaminationDTO{" +
                "id=" + id +
                ", typology='" + typology + '\'' +
                ", cost=" + cost +
                ", code=" + code +
                ", img='" + img + '\'' +
                '}';
    }
}
