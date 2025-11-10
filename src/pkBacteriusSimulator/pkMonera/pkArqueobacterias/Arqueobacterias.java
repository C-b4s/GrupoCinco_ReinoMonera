package pkBacteriusSimulator.pkMonera.pkArqueobacterias;

public abstract class Arqueobacterias {
    private String resultadoTincioGram;
    private String clasificacionArqueo;
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
