package pkSimMonBact.pkBiologos;

public abstract class Biologo {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer Id;
    private String campoEspecialidad;
    private String laboratorioAsignado;
    
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

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
    
    public void generarInforme(String bacteria, Double tiempoAnalisis, String laboratorio){    
        System.out.println("================== INFORME ==================");
        System.out.println("|");
        
        
        System.out.println("Informe de " + bacteria + ": analizada por " + nombre + "en " + laboratorio +
        " durante " + tiempoAnalisis + "horas");
    }


}
