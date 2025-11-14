package pkSimMonBact.pkMonera.pkArqueobacterias;

public class Methanococcus_Jannaschii extends Arqueobacterias {
    
    private Double nivelMetanoProducido;
    private double nivelCO2;
    private double nivelH2;

    public Methanococcus_Jannaschii(String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto,String resultadoTincioGram,
                        String clasificacionArqueo, Double nivelMetanoProducido, double nivelCO2, double nivelH2) {
        
        super("Methanococcus Jannaschii",habitat,
                    phOptimo,temperaturaOptima,
                    false,anaerobioStricto, resultadoTincioGram, clasificacionArqueo);
        this.nivelMetanoProducido = nivelMetanoProducido;
        this.nivelCO2 = 0.0;
        this.nivelH2 = 0.0;
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

    public void suministrarReactivos(boolean co2, boolean h2) {
    this.tieneCO2 = co2;
    this.tieneH2 = h2;
}


@Override
public String ejecutarFuncionMetabolica() {

    if (tieneCO2 && tieneH2) {
        return getNombreCientifico() 
            + " produce metano utilizando CO₂ y H₂ (metanogénesis).";
    }

    if (!tieneCO2 && !tieneH2) {
        return getNombreCientifico()
            + " no puede realizar metanogénesis: faltan CO₂ y H₂.";
    }

    if (!tieneCO2) {
        return getNombreCientifico()
            + " no puede realizar metanogénesis porque falta CO₂.";
    }

    return getNombreCientifico()
        + " no puede realizar metanogénesis porque falta H₂.";
}

}



    
