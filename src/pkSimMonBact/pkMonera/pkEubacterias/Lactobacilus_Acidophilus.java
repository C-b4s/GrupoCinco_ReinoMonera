package pkSimMonBact.pkMonera.pkEubacterias;

public class Lactobacilus_Acidophilus extends Eubacteria{
private String tipoAzucarFermentado;
private Double nivelProduccionAcidoLact;
private Double consumoAzucares;



public Lactobacilus_Acidophilus(String string, String string2, double d, double e, double f, boolean b, boolean c){
    super(null);
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
