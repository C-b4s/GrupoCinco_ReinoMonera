package pkSimMonBact.pkMonera.pkEubacterias;


public class Streptococcus_Thermophilus extends Eubacteria {
    private Double nivelAcidoLactico;
    private Double consumoAzucares;

    
    public Streptococcus_Thermophilus (Double nivelAcidoLactico, Double consumoAzucares,
                                                                        String nombreCientifico, String habitat,
                                                                        Double phOptimo, Double temperaturaOptima,
                                                                        Boolean esPatogeno, Boolean anaerobioStricto, Boolean esProbiotico,
                                                                        String gram, String clasificacionEubacteria, String tipoFermentacion  ){
        super("Streptococcus Thermophilus", habitat,
                    phOptimo,temperaturaOptima,
                    esPatogeno,anaerobioStricto,esProbiotico,
                    gram, clasificacionEubacteria, tipoFermentacion);
        this.nivelAcidoLactico=nivelAcidoLactico;
        this.consumoAzucares =consumoAzucares;
    }

    //Getters y Setters:
    public Double getNivelAcidoLactico() {
        return nivelAcidoLactico;
    }
    
    public void setNivelAcidoLactico(Double nivelAcidoLactico){
        if (nivelAcidoLactico == null || nivelAcidoLactico <= 0){
            throw new IllegalArgumentException("El nivel de ácido láctico no puede ser nulo o negativo");
        }
        this.nivelAcidoLactico = nivelAcidoLactico;
    }

    public Double getConsumoAzucares() {
        return consumoAzucares;
    }

    public void setConsumoAzucares(Double consumoAzucares) {
        if (consumoAzucares == null || consumoAzucares <= 0){
            throw new IllegalArgumentException("El consumo de azucares no puede ser nulo o negativo");
        }
        
        this.consumoAzucares = consumoAzucares;
    }
    

    //Métodos:
    public String fermentar (String sustrato){
        if(sustrato.equalsIgnoreCase("lactosa")){
            this.nivelAcidoLactico += 5.0;
            return "Se ha fermentado la lactosa y se ha producido ácido láctico.";
        } else {
            return "El sustrato no es adecuado para la fermentación por Streptococcus thermophilus.";
        }
    }

    public String compararFermentacion(Eubacteria otraBacteria, Double azucarOtra, Double acidoOtra){
        if (otraBacteria == null || acidoOtra == null || azucarOtra == null){
            String mensajeError = "\n================== ERROR ==================\n";
            mensajeError += "No se puede realizar la operación con parámetros nulos";
            return mensajeError;
        }

        if (otraBacteria instanceof Lactobacilus_Acidophilus lactobacillus1){
            acidoOtra = lactobacillus1.getNivelProduccionAcidoLact();
            azucarOtra = lactobacillus1.getConsumoAzucares();
        }
        
        
        String resultado = "\n";
        resultado += "\n================== FERMENTACION DE " + this.getNombreCientifico().toUpperCase() + " ==================\n";
        resultado += "Nivel de ácido láctico producido: " + this.getNivelAcidoLactico() + "\n";
        resultado += "Nivel de consumo de azúcares: " + this.getConsumoAzucares() + "\n";

        if (this.getNivelAcidoLactico() > acidoOtra){
            resultado += "\n" + this.getNombreCientifico() + " produce MÁS ácido láctico que " + otraBacteria.getNombreCientifico();
        }else if (this.getNivelAcidoLactico() < acidoOtra ){
            resultado += "\n" + this.getNombreCientifico() + " produce MENOS ácido láctico que " + otraBacteria.getNombreCientifico();
        }else{
            resultado += "\n" + "AMBAS bacterias producen la misma cantidad de ácido láctico";
        }
        
        if (this.getConsumoAzucares() < azucarOtra){
            resultado += "\n" + this.getNombreCientifico() + " es más eficiente en el consumo de azúcares que " + otraBacteria.getNombreCientifico();
        }else if (this.getConsumoAzucares() > azucarOtra){
            resultado += "\n" + this.getNombreCientifico() + " es menos eficiente en el consumo de azúcares que " + otraBacteria.getNombreCientifico();
        }else{
            resultado += "\n" + "ambas bacterias consumen la misma cantidad de azúcares";
        }

        return resultado;

    } 
}
