package pkBacteriusSimulator.pkMonera.pkEubacterias;

import pkBacteriusSimulator.pkMonera.ReinoMonera;

public abstract class Eubacteria extends ReinoMonera{
    private Boolean esProbiotico;
    private String gram;
    private String clasificacionEubacteria;
    private String tipoFermentacion;

    protected Eubacteria(Builder<?> builder) {

        super(builder);
        this.tipoFermentacion = builder.tipoFermentacion;
        this.clasificacionEubacteria = builder.clasificacionEubacteria;
        this.gram = builder.gram;
        this.esProbiotico = builder.esProbiotico;
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


     public static abstract class Builder<Monera extends Builder<Monera>>
        extends ReinoMonera.Builder<Monera> {
        private String tipoFermentacion;
        private String clasificacionEubacteria;
        private String gram;
        private Boolean esProbiotico;

        public Monera tipoFermentacion(String tf) { 
            this.tipoFermentacion = tf; 
            return self(); 
         }

        public Monera clasificacionEubacteria(String c) { 
            this.clasificacionEubacteria = c; 
            return self(); 
        }

        public Monera gram(String g) { 
            this.gram = g; 
            return self(); 
        }

        public Monera esProbiotico(Boolean p) { 
            this.esProbiotico = p; 
            return self(); 
        }

        @Override
        protected abstract Monera self();


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
