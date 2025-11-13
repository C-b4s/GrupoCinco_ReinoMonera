package pkSimMonBact.pkMonera;

public abstract class ReinoMonera {

    private String nombreCientifico;
    private String habitat;
    private Double phOptimo;
    private Double temperaturaOptima;
    private Boolean esPatogeno;
    private Boolean anaerobioEstricto;

    public ReinoMonera (String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto){
        this.nombreCientifico = nombreCientifico;
        this.habitat = habitat;
        this.phOptimo = phOptimo;   
        this.temperaturaOptima = temperaturaOptima;
        this.esPatogeno = esPatogeno;
        this.anaerobioEstricto = anaerobioStricto;
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
}


