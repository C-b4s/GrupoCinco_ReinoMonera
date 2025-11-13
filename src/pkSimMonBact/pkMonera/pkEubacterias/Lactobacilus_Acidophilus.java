package pkSimMonBact.pkMonera.pkEubacterias;

public class Lactobacilus_Acidophilus extends Eubacteria{
private String tipoAzucarFermentado;
private Double nivelProduccionAcidoLact;
private Double consumoAzucares;



<<<<<<< HEAD
public Lactobacilus_Acidophilus(String nombreCientifico, String habitat, Double phOptimo, 
                                Double temperaturaOptima, Boolean esPatogeno, Boolean anaerobioStricto, 
                                String tipoFermentacion, String clasificacionEubacteria, 
                                String gram, Boolean esProbiotico){
    super(nombreCientifico, habitat, phOptimo, temperaturaOptima, 
          esPatogeno, anaerobioStricto, tipoFermentacion, clasificacionEubacteria, 
          gram, esProbiotico);
=======
public Lactobacilus_Acidophilus(String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto, Boolean esProbiotico,
                        String gram, String clasificacionEubacteria, String tipoFermentacion,String tipoAzucarFermentado,
                        Double nivelProduccionAcidoLact, Double consumoAzucares){
    super("Lactobacilus Acidophilus", habitat,
                    phOptimo,temperaturaOptima,
                    esPatogeno,anaerobioStricto,esProbiotico,
                    gram, clasificacionEubacteria, tipoFermentacion);
>>>>>>> b35617688be206933a52badc77316a186febb92f
    this.tipoAzucarFermentado ="Glucosa";
    this.nivelProduccionAcidoLact=0.0;
}

public Double evaluarEficienciaFermentacion(){
    double eficiencia = (nivelProduccionAcidoLact/10.0)*100;
    if(eficiencia>100) eficiencia=100;
    return Math.round(eficiencia *100.0 )/100.0;
 }
public String fermentar (String sustrato){
    if (sustrato.equalsIgnoreCase(tipoAzucarFermentado)){
        nivelProduccionAcidoLact += 4.5;
        return getNombreCientifico() + "fermentó" + sustrato + " y produjo acido lactico";
    }else{
        return getNombreCientifico() + " no puede fermentar "+ sustrato+".";
    }
}
public String getTipoAzucarFermentado() {
    return tipoAzucarFermentado;
}
public void setTipoAzucarFermentado(String tipoAzucarFermentado) {
    this.tipoAzucarFermentado = tipoAzucarFermentado;
}
public Double getNivelProduccionAcidoLact() {
    return nivelProduccionAcidoLact;
}
public void setNivelProduccionAcidoLact(Double nivelProduccionAcidoLact) {
    this.nivelProduccionAcidoLact = nivelProduccionAcidoLact;
}

public Double getConsumoAzucares() {
    return consumoAzucares;
}

public void setConsumoAzucares(Double consumoAzucares) {
    this.consumoAzucares = consumoAzucares;
}

}
