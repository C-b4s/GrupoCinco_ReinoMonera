package pkBacteriusSimulator.pkBiologos;

import pkBacteriusSimulator.pkMonera.ReinoMonera;

public abstract class Biologo {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String Id;
    private String campoEspecialidad;
    private String laboratorioAsignado;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
    public String getCampoEspecialidad() {
        return campoEspecialidad;
    }
    public void setCampoEspecialidad(String campoEspecialidad) {
        this.campoEspecialidad = campoEspecialidad;
    }
    public String getLaboratorioAsignado() {
        return laboratorioAsignado;
    }
    public void setLaboratorioAsignado(String laboratorioAsignado) {
        this.laboratorioAsignado = laboratorioAsignado;
    }

    public void registrarBacteria(){

    }
    
    public void generarInforme(ReinoMonera bacteria , Double tiempoAnalisis, String laboratorio){    
        System.out.println("================== INFORME ==================");
        
        
        System.out.print("|");
        System.out.println("Informe de " + bacteria + ": analizada por " + nombre + "en " + laboratorio +
        " durante " + tiempoAnalisis + "horas");
    }


}
