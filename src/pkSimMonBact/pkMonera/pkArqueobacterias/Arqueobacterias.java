package pkSimMonBact.pkMonera.pkArqueobacterias;

import pkSimMonBact.pkMonera.ReinoMonera;

public abstract class Arqueobacterias extends ReinoMonera{
    private String resultadoTincioGram;
    private String clasificacionArqueo;

    public Arqueobacterias(String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto,String resultadoTincioGram,String clasificacionArqueo){
        super(nombreCientifico,habitat,
                    phOptimo,temperaturaOptima,
                    esPatogeno,anaerobioStricto);
        this.clasificacionArqueo=clasificacionArqueo;
        this.resultadoTincioGram=resultadoTincioGram;
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
