package pkBacteriusSimulator.pkMonera;

public abstract class ReinoMonera {

    private String nombreCientifico;
    private String habitat;
    private Double tamanio;
    private Double phOptimo;
    private Double temperaturaOptima;
    private Boolean esPatogeno;
    private Boolean anaerobioEstricto;

    public ReinoMonera (String nombreCientifico, String habitat,
                        Double tamanio, Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto){
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.tamanio = tamanio;
        this.phOptimo = phOptimo;   
        this.temperaturaOptima = temperaturaOptima;
        this.esPatogeno = esPatogeno;
        this.anaerobioEstricto = anaerobioStricto;
    }

    
    protected ReinoMonera(Builder <?> builder) {
        this.nombreCientifico = builder.nombreCientifico;
        this.habitat = builder.habitat;
        this.tamanio = builder.tamanio;
        this.phOptimo = builder.phOptimo;
        this.temperaturaOptima = builder.temperaturaOptima;
        this.esPatogeno = builder.esPatogeno;
        this.anaerobioEstricto = builder.anaerobioEstricto;
    }

    

    public ReinoMonera(String nombreCientifico2, String string, String habitat2) {
        //TODO Auto-generated constructor stub
    }


    public String getNombreCientifico() {
        return nombreCientifico;
    }
    public void setNombreCientifico(String nombreCientifico) {
        if(nombreCientifico!= null && !nombreCientifico.isEmpty())
            this.nombreCientifico = nombreCientifico;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El nombre cientifico no puede estar vacio");
    }

    public Double getTamaño() {
        return tamanio;
    }
    public void setTamaño(Double tamaño) {
        if (tamaño != null && tamaño > 0)
            this.tamanio = tamaño;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El tamaño debe ser un valor positivo");
    }

    public Boolean getEsPatogeno() {
        return esPatogeno;
    }
    public void setEsPatogeno(Boolean esPatogeno) {
        if(esPatogeno != null)
            this.esPatogeno = esPatogeno;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El valor de esPatogeno no puede ser nulo");
    }

    public String getHabitat() {
        return habitat;
    }


    public void setHabitat(String habitat) {
        if (habitat != null && !habitat.isEmpty())
            this.habitat = habitat;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El habitat no puede estar vacio");
    }

    public Boolean getAnaerobioStricto() {
        return anaerobioEstricto;
    }

    public void setAnaerobioStricto(Boolean anaerobioStricto) {
        if (anaerobioStricto != null)
            this.anaerobioEstricto = anaerobioStricto;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El valor de anaerobioStricto no puede ser nulo");
    }

    public Double getPhOptimo() {
        return phOptimo;
    }

    public void setPhOptimo(Double phOptimo) {
        if (phOptimo != null && phOptimo >= 0 && phOptimo <=14)
            this.phOptimo = phOptimo;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El pH debe estar entre 0 y 14");
    }

    public Double getTemperaturaOptima() {
        return temperaturaOptima;
    }


    public void setTemperaturaOptima(Double temperaturaOptima) {
        if (temperaturaOptima != null)
            this.temperaturaOptima = temperaturaOptima;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("La temperatura óptima no puede ser nula");
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

      public static abstract class Builder<Monera extends Builder<Monera>> {
        private String nombreCientifico;
        private String habitat;
        private Double tamanio;
        private Double phOptimo;
        private Double temperaturaOptima;
        private Boolean esPatogeno;
        private Boolean anaerobioEstricto;

        // setters del builder (devuelven T para encadenar)
        public Monera nombreCientifico(String nombre) { 
            this.nombreCientifico = nombre; 
            return self(); 
        }


        public Monera habitat(String hab) { 
            this.habitat = hab; 
            return self(); 
        }

        public Monera tamanio(Double tam) { 
            this.tamanio = tam; 
            return self(); 
        }

        public Monera phOptimo(Double pH) { 
            this.phOptimo = pH; 
            return self(); 
        }

        public Monera temperaturaOptima(Double tempOp) { 
            this.temperaturaOptima = tempOp; 
            return self(); 
        }

        public Monera esPatogeno(Boolean pat) { 
            this.esPatogeno = pat; 
            return self(); 
        }

        public Monera anaerobioEstricto(Boolean anaerobio) { 
            this.anaerobioEstricto = anaerobio; 
            return self(); 
        }

        // subclases deben devolver "self" concreto
        protected abstract Monera self();

        // subclase concreta implementará build() que retorna la subclase concreta
        public abstract ReinoMonera build();
    }

}
