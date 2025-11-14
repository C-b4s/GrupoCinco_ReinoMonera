package pkMonera.pkEubacterias;

public class ClostridumBotulinum extends Eubacteria{

 public static  final String ROJO = "\u001B[31m";
   public static  final String RESET = "\u001B[0m";
    
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
        super("Clostridum Botulinum", habitat,
                    phOptimo,temperaturaOptima,
                    false, anaerobioStricto, false,
                    "positivo", clasificacionEubacteria, tipoFermentacion);
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

    @Override
    public String ejecutarFuncionMetabolica(){
        if (ambienteSinOxigeno) return "Produce toxina botulínica en ambientes anaerobios";
        else return ROJO + "Dado que el ambiente no es anaerobio, no se ha producido toxina botulinica" + RESET;
    }

     public String activarPorLactobacillus(Lactobacilus_Acidophilus Lactobacilus) {
        return "La bacteria Clostridum botulinum detecta el ácido láctico producido por " + Lactobacilus.getNombreCientifico() + " y activa su metabolismo anaeróbico.";
    }

    public String competirConDosBacterias(Lactobacilus_Acidophilus lacto, Streptococcus_Thermophilus strepto) {
        return "La bacteria Clostridum botulinum compite por recursos contra " + lacto.getNombreCientifico() + " y " + strepto.getNombreCientifico() + " en un ambiente compartido.";
    }

    public String inhibirBacteria(Eubacteria bacteria, Float crecimiento) {
        if (!this.toxinaActiva){
            return "La toxina butilinica está inactiva, por tanto no hay efecto sobre " + bacteria.getNombreCientifico();
        }

        String nombre = bacteria.getNombreCientifico().toLowerCase();
        if (this.toxinaActiva){
            if (nombre.contains("Lactobacillus acidophilus")){
                return "La toxina botulínica de Clostridum Botulinum inhibe el crecimiento de " + bacteria.getNombreCientifico() + " al alterar su pH y eliminar nutrientes disponibles para el crecimiento de la misma.";
            }

            if (nombre.contains("Streptococcus thermophilus")) {
            return "La toxina botulínica de Clostridum Botulinum inhibe parcialmente a "  + bacteria.getNombreCientifico()
                    + " desplazándola en ambientes anaeróbicos estrictos.";
            }

        }
        return "No se registró ninguna inhibición en específico contra " + bacteria.getNombreCientifico() + ".";  
    }


}
