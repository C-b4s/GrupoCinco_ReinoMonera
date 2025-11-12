package pkSimMonBact.pkMonera.pkArqueobacterias;

public class Halobacterium_Salinarum extends Arqueobacterias {

    private Double nivelSalinidadOptima;

    public Halobacterium_Salinarum(String nombreCientifico, String habitat, Double nivelSalinidadOptima) {
        super(nombreCientifico, habitat);
        this.nivelSalinidadOptima = nivelSalinidadOptima;
    }

    public Double getNivelSalinidadOptima() {
        return nivelSalinidadOptima;
    }

    public void setNivelSalinidadOptima(Double nivelSalinidadOptima) {
        if (nivelSalinidadOptima < 1.5 || nivelSalinidadOptima > 3.7) {
            System.out.println("El valor de salanidad no es óptimo para que crezca el Halobacterium salinarum.");
        } else {
            this.nivelSalinidadOptima = nivelSalinidadOptima;
        }
    }
    
    public String analizarRespuestaSalina() {
        if (nivelSalinidadOptima <= 3.0 && nivelSalinidadOptima >= 2.0) {
            return "Ambiente optimo para el crecimiento del Halobacterium Salinarum.";
        } else if (nivelSalinidadOptima < 2) {
            return "La bacteria pierde agua y afecta su metabolismo.";
        } else {
            return "Consume mucha energía y su metabolismo se desacelera y se desestabilizan.";
        }
    }

    public String compararAdaptacion(String bacteria) {
        switch (bacteria.toLowerCase()) {
            case "methanococcus jannaschii":
                return "Methanococcus jannaschii se adapta mejor a condiciones anaeróbicas, " +
                        "mientras que Halobacterium salinarum destaca en ambientes hipersalinos.";
            default:
                return "No hay datos suficientes para comparar con " + bacteria + ".";
        }
    }

}
