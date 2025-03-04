package com.mycompany.aplicacion_de_conceptos.dtos;

public class DTOProfesor extends DTOPersona {
    private String tipoContrato;

    public DTOProfesor(double id, String nombres, String apellidos, String email, String tipoContrato) {
        super(id, nombres, apellidos, email);
        this.tipoContrato = tipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
