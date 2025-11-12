package pkBacteriusSimulator.pkMonera.pkArqueobacterias;

public class Methanococcus_Jannaschii extends Arqueobacterias {
    
    private Double nivelMetanoProducido;

    public Methanococcus_Jannaschii(String nombreCientifico, String habitat, Double nivelMetanoProducido) {
        
        super(nombreCientifico, habitat);
        this.nivelMetanoProducido = nivelMetanoProducido;
    }

    public Double getNivelMetanoProducido() {
        return nivelMetanoProducido;
    }

    public void setNivelMetanoProducido(Double nivelMetanoProducido) {
        this.nivelMetanoProducido = nivelMetanoProducido;
    }

    public Boolean generarMetano(Boolean hayCO2, Boolean hayH2) {

        if (hayCO2 && hayH2) {
            this.nivelMetanoProducido += 0.5;
            return true;
        } else {
            return false;
        }
    }
    
    public String compararResistenciaAnaerobia(String bacteria) {
        switch (bacteria.toLowerCase()) {
            case "halobacterium salinarum":
               
                if (this.seAdaptaCondicionAnaerobica()) { 
                    return "Methanococcus jannaschii es un anaerobio estricto y, por ende, " +
                           "más resistente a la ausencia de oxígeno que Halobacterium salinarum (aerobio).";
                }
                return "Error: Clasificación de resistencia anaeróbica interna inconsistente.";
            default:
                return "Methanococcus jannaschii es altamente resistente a condiciones anaeróbicas.";
        }
    }

    private Boolean seAdaptaCondicionAnaerobica() {
        return this.adaptarseCondicionesAnaerobicas();
    }

}

    
