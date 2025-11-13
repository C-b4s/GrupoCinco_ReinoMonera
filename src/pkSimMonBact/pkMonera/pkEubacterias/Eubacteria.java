package pkSimMonBact.pkMonera.pkEubacterias;

import pkSimMonBact.pkMonera.ReinoMonera;

public abstract class Eubacteria extends ReinoMonera{
    private Boolean esProbiotico;
    private String gram;
    private String clasificacionEubacteria;
    private String tipoFermentacion;

    protected Eubacteria(String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto, Boolean esProbiotico,
                        String gram, String clasificacionEubacteria, String tipoFermentacion ) {

        super(nombreCientifico,habitat,
                    phOptimo,temperaturaOptima,
                    esPatogeno,anaerobioStricto);
        this.tipoFermentacion = tipoFermentacion;
        this.clasificacionEubacteria = clasificacionEubacteria;
        this.gram = gram;
        this.esProbiotico = esProbiotico;
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
