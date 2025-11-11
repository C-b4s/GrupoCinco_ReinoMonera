package pkBacteriusSimulator.pkMonera.pkArqueobacterias;

import pkBacteriusSimulator.pkMonera.ReinoMonera;

public abstract class Arqueobacterias extends ReinoMonera{
    private String resultadoTincioGram;
    private String clasificacionArqueo;

    public Arqueobacterias(String nombreCientifico,String habitat){
        super(nombreCientifico,"Procariote",habitat);
    }

    public String getResultadoTincioGram() {
        return resultadoTincioGram;
    }
    public void setResultadoTincioGram(String resultadoTincioGram) {
        this.resultadoTincioGram = resultadoTincioGram;
    }
    public String getClasificacionArqueo() {
        return clasificacionArqueo;
    }
    public void setClasificacionArqueo(String clasificacionArqueo) {
        this.clasificacionArqueo = clasificacionArqueo;
    }

    public Boolean adaptarseCondicionesAnaerobicas(){
        return clasificacionArqueo.equalsIgnoreCase("metanogena");
    }

}
