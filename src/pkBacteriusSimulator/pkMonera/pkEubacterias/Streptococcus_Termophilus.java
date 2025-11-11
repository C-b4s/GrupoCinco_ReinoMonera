package pkBacteriusSimulator.pkMonera.pkEubacterias;



public class Streptococcus_Termophilus extends Eubacterias {
    private Double nivelAcidoLactico;


    public Double getNivelAcidoLactico() {
        return nivelAcidoLactico;
    }

    public void setNivelAcidoLactico(Double nivelAcidoLactico){
        if (nivelAcidoLactico == null || nivelAcidoLactico <0){
            throw new IllegalArgumentException("El nivel de ácido láctico no puede ser nulo o negativo");
        }
        this.nivelAcidoLactico = nivelAcidoLactico;
    }

    public String fermentar (String sustrato){
        if(sustrato.equalsIgnoreCase("lactosa")){
            return "Se ha fermentado la lactosa y se ha producido ácido láctico.";
        } else {
            return "El sustrato no es adecuado para la fermentación por Streptococcus thermophilus.";
        }
    }

    public void compararFermentacion(Eubacterias otraBacteria, String azucarOtra, String acidoOtra){
        

    }

    
}
