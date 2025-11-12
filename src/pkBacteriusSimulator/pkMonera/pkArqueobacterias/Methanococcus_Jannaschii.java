package pkBacteriusSimulator.pkMonera.pkArqueobacterias;

public class Methanococcus_Jannaschii extends Arqueobacterias {
    
    private Double nivelMetanoProducido;

    public Methanococcus_Jannaschii(String nombreCientifico, String habitat, Double nivelMetanoProducido) {
        
        super(nombreCientifico, habitat);

        if (nivelMetanoProducido != null && nivelMetanoProducido >= 0.0) {
            this.nivelMetanoProducido = nivelMetanoProducido;
        } else {
            this.nivelMetanoProducido = 0.0;
            System.err.println("Advertencia: Nivel de Metano inválido. Se asignó 0.0"); 
        }

        setClasificacionArqueo("metanogena"); 
        setResultadoTincioGram("Negativo Atípico");
    }

    public Double getNivelMetanoProducido() {
        return nivelMetanoProducido;
    }

    public void setNivelMetanoProducido(Double nivelMetanoProducido) {
        
        if (nivelMetanoProducido != null && nivelMetanoProducido >= 0.0) {
            this.nivelMetanoProducido = nivelMetanoProducido;
        } else {
            
            System.err.println("Error de Asignación: El nivel de metano debe ser positivo y no nulo. Valor actual: " + this.nivelMetanoProducido);
        }
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
               
                if (this.adaptarseCondicionesAnaerobicas()) { 
                    return "Methanococcus jannaschii es un anaerobio estricto y, por ende, " +
                           "más resistente a la ausencia de oxígeno que Halobacterium salinarum (aerobio).";
                }
                return "Error: Clasificación de resistencia anaeróbica interna inconsistente.";
            default:
                return "Methanococcus jannaschii es altamente resistente a condiciones anaeróbicas.";
        }
    }

}

    
