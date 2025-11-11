package pkBacteriusSimulator.pkMonera.pkEubacterias;

import pkBacteriusSimulator.pkMonera.ReinoMonera;

public abstract class Eubacterias extends ReinoMonera{
    private Boolean esProbiotico;
    private String gram;
    private String clasificacionEubacteria;
    private String tipoFermentacion;

    public Eubacterias(String nombreCientifico, String habitat, String gram){
        super(nombreCientifico,"Procariota",habitat);
        this.gram =gram;
    }

    public Boolean getEsProbiotico() {
        return esProbiotico;
    }
    public void setEsProbiotico(Boolean esProbiotico) {
        this.esProbiotico = esProbiotico;
    }
    public String getGram() {
        return gram;
    }
    public void setGram(String gram) {
        this.gram = gram;
    }
    public String getClasificacionEubacteria() {
        return clasificacionEubacteria;
    }
    public void setClasificacionEubacteria(String clasificacionEubacteria) {
        this.clasificacionEubacteria = clasificacionEubacteria;
    }
    public String getTipoFermentacion() {
        return tipoFermentacion;
    }
    public void setTipoFermentacion(String tipoFermentacion) {
        this.tipoFermentacion = tipoFermentacion;
    }

    public Boolean reaccionarAntibiotico(String antibiotico){
    if(gram.equalsIgnoreCase("positivo") && antibiotico.equalsIgnoreCase("penicilina")){
        return false;
    }   else if( gram.equalsIgnoreCase("negativo") && antibiotico.equalsIgnoreCase("penicilina")){
        return true;
    }else{
        return false;
    }
    }

}
