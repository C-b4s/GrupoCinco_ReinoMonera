package pkMonera.pkEubacterias;

public class ClostridumBotulinum extends Eubacteria{
    // Atributos  
    private boolean          toxinaActiva;
    private boolean          ambienteSinOxigeno;
    private double           nivelToxina;

    public double getNivelToxina() {
        return nivelToxina;
    }

    public void setNivelToxina(double nivelToxina) {
        this.nivelToxina = nivelToxina;
    }

    public boolean isAmbienteSinOxigeno() {
        return ambienteSinOxigeno;
    }

    public void setAmbienteSinOxigeno(boolean ambienteSinOxigeno) {
        this.ambienteSinOxigeno = ambienteSinOxigeno;
    }

    public boolean isToxinaActiva() {
        return toxinaActiva;
    }

    public void setToxinaActiva(boolean toxinaActiva) {
        this.toxinaActiva = toxinaActiva;
    }

    public ClostridumBotulinum(String nombreCientifico, String habitat,
                        Double phOptimo, Double temperaturaOptima,
                        Boolean esPatogeno, Boolean anaerobioStricto, Boolean esProbiotico,
                        String gram, String clasificacionEubacteria, String tipoFermentacion ,
                        boolean toxinaActiva, boolean ambienteSinOxigeno, double nivelToxina) {
        super(nombreCientifico, habitat,
                    phOptimo,temperaturaOptima,
                    esPatogeno,anaerobioStricto,esProbiotico,
                    gram, clasificacionEubacteria, tipoFermentacion);
        this.toxinaActiva = true;
        this.ambienteSinOxigeno = true;
        this.nivelToxina = 75.3;
    }

    // Métodos
    public void cultivarEnAmbienteSeguro(){
        if (ambienteSinOxigeno){
            System.out.println("La bacteria se cultivó correctamente en el ambiente adecuado (sin oxígeno).");
        }else {
            System.out.println("La bacteria no puede crecer en presencia de oxígeno.");
        }
    }

    public void activarToxina(){
        if(ambienteSinOxigeno){
            toxinaActiva = true;
            nivelToxina = 75.3; // valor de referencia 
            System.out.println("La toxina botulínica ha sido activada con éxito.");
        }else {
            System.out.println("La toxina botulínica no se puede activar en un ambiente con oxígeno.");
        }
    }

    public void mostrarActividadToxica(){
        System.out.println("Registro de la actividad tóxica de la bacteria Clostridium Botulinum\n");
        if (ambienteSinOxigeno){
            System.out.println("Ambiente: ADECUADO (SIN OXIGENO)");
        }else {
            System.out.println("Ambiente: INADECUADO (CON PRESENCIA DE OXIGENO)");
        }
        if (toxinaActiva){
            System.out.println("Toxina: ACTIVADA");
            System.out.println("Nivel de Toxina:" + nivelToxina);
        }else {
            System.out.println("Toxina: INACTIVA");
        }
        
    }

    public void desactivarToxina(){
        toxinaActiva = false;
        nivelToxina = 0;
        System.out.println("La toxina ha sido desactivada.");
    }

}
