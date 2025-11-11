package pkBacteriusSimulator.pkMonera;

public abstract class ReinoMonera {

    private String nombreCientifico;
    private String tipoCelula;
    private String habitat;
    private String reproduccion;
    private Double tamanio;
    private Double phOptimo;
    private Double temperaturaOptima;
    private Boolean esPatogeno;
    private Boolean movilidad;
    private Boolean anaerobioStricto;
    
    
    

    public ReinoMonera (String nombreCientifico, String tipoCelula, String habitat,
                        String reproduccion, Double tamanio, Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean movilidad, Boolean anaerobioStricto){
        this.nombreCientifico = nombreCientifico;
        this.tipoCelula = tipoCelula;
        this.habitat = habitat;
        this.reproduccion = reproduccion;
        this.tamanio = tamanio;
        this.phOptimo = phOptimo;
        this.temperaturaOptima = temperaturaOptima;
        this.esPatogeno = esPatogeno;
        this.movilidad = movilidad;
        this.anaerobioStricto = anaerobioStricto;
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

    public String getTipoCelula() {
        return tipoCelula;
    }
    public void setTipoCelula(String tipoCelula) {
        if (tipoCelula.equalsIgnoreCase("Procariota") || tipoCelula.equalsIgnoreCase("Eucariota"))
            this.tipoCelula = tipoCelula;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El tipo de celula debe ser Procariota o Eucariota");
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

    public Boolean getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(Boolean movilidad) {
        if (movilidad != null)
            this.movilidad = movilidad;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El valor de movilidad no puede ser nulo");
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
        return anaerobioStricto;
    }

    public void setAnaerobioStricto(Boolean anaerobioStricto) {
        if (anaerobioStricto != null)
            this.anaerobioStricto = anaerobioStricto;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El valor de anaerobioStricto no puede ser nulo");
    }

    public String getReproduccion() {
        return reproduccion;
    }
    public void setReproduccion(String reproduccion) {
        if(reproduccion != null && !reproduccion.isEmpty())
            this.reproduccion = reproduccion;
        else
            System.out.println("\n" + "================== ERROR ==================\n");
            System.out.println("El tipo de reproduccion no puede estar vacio");
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

}
