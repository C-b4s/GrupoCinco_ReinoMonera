package pkBacteriusSimulator.pkMonera;

public abstract class ReinoMonera {

    private String nombreCientifico;
    private String tipoCelula;
    private Double tamaño;
    private Boolean esPatogeno;
    private Boolean movilidad;
    private String habitat;
    private Boolean anaerobioStricto;
    private String reproduccion;
    private Double phOptimo;
    private Double temperaturaOptima;
    public String getNombreCientifico() {
        return nombreCientifico;
    }
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }
    public String getTipoCelula() {
        return tipoCelula;
    }
    public void setTipoCelula(String tipoCelula) {
        this.tipoCelula = tipoCelula;
    }
    public Double getTamaño() {
        return tamaño;
    }
    public void setTamaño(Double tamaño) {
        this.tamaño = tamaño;
    }
    public Boolean getEsPatogeno() {
        return esPatogeno;
    }
    public void setEsPatogeno(Boolean esPatogeno) {
        this.esPatogeno = esPatogeno;
    }
    public Boolean getMovilidad() {
        return movilidad;
    }
    public void setMovilidad(Boolean movilidad) {
        this.movilidad = movilidad;
    }
    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    public Boolean getAnaerobioStricto() {
        return anaerobioStricto;
    }
    public void setAnaerobioStricto(Boolean anaerobioStricto) {
        this.anaerobioStricto = anaerobioStricto;
    }
    public String getReproduccion() {
        return reproduccion;
    }
    public void setReproduccion(String reproduccion) {
        this.reproduccion = reproduccion;
    }
    public Double getPhOptimo() {
        return phOptimo;
    }
    public void setPhOptimo(Double phOptimo) {
        this.phOptimo = phOptimo;
    }
    public Double getTemperaturaOptima() {
        return temperaturaOptima;
    }
    public void setTemperaturaOptima(Double temperaturaOptima) {
        this.temperaturaOptima = temperaturaOptima;
    }

    public String alimentarse (String comida){
        if (comida.equalsIgnoreCase("glucosa")){
            return nombreCientifico + "obtiene energía fermentando glucosa";
        } else if (comida.equalsIgnoreCase("C02  y H2")){
            return nombreCientifico + "realizar metabolismo metanogénico.";
        } else {
            return nombreCientifico + "no puede metabolizar " + comida + " .";
        }
    }

}
