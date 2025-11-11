package pkBacteriusSimulator.pkMonera.pkArqueobacterias;

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
        this.nivelSalinidadOptima = nivelSalinidadOptima;
    }

    public String analizarRespuestaSalina() {
        if (nivelSalinidadOptima > 3.0) {
            return "Alta adaptación a ambientes hipersalinos.";
        } else if (nivelSalinidadOptima >= 1.5) {
            return "Adaptación moderada a la salinidad.";
        } else {
            return "Baja tolerancia a condiciones salinas.";
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
