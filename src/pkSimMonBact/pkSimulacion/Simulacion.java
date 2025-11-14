package pkSimulacion;

import pkBiologos.Biologo;
import pkMonera.ReinoMonera;

public class Simulacion {
    private String nombre;
    private Biologo usuarioCreador;
    private ReinoMonera[] bacterias = new ReinoMonera[20];
    private double phActual;
    private double temperaturaActual;
    private int totalBacterias = 0;

    // Interacciones
    private String[] interaccionesOcurridas = new String[50];
    private int totalInteracciones = 0;

    public Simulacion(String nombre, Biologo usuarioCreador, double pH, double temperatura) {
        this.nombre = nombre;
        this.usuarioCreador = usuarioCreador;
        this.phActual = pH;
        this.temperaturaActual = temperatura;
    }

    public String getNombre() { return nombre; }
    public Biologo getUsuarioCreador() { return usuarioCreador; }
    public double getpHActual() { return phActual; }
    public double getTemperaturaActual() { return temperaturaActual; }

    public ReinoMonera[] getBacterias() {
        ReinoMonera[] resultado = new ReinoMonera[totalBacterias];
        for (int i = 0; i < totalBacterias; i++) {
            resultado[i] = bacterias[i];
        }
        return resultado;
    }

    public boolean anadirBacteria(ReinoMonera bacteria) {
        if (totalBacterias < bacterias.length) {
            bacterias[totalBacterias] = bacteria;
            totalBacterias++;
            return true;
        }
        return false;
    }

    public void modificarCondiciones(double pH, double temperatura) {
        this.phActual = pH;
        this.temperaturaActual = temperatura;
    }

    // Interacciones
    public void ejecutarInteracciones() {
        for (int i = 0; i < totalBacterias; i++) {
            for (int j = i + 1; j < totalBacterias; j++) {
                if (bacterias[i] != null && bacterias[j] != null) {
                    detectarInteraccion(bacterias[i], bacterias[j]);
                }
            }
        }
    }

   private void detectarInteraccion(ReinoMonera b1, ReinoMonera b2) {
    String n1 = b1.getNombreCientifico().toLowerCase().trim();
    String n2 = b2.getNombreCientifico().toLowerCase().trim();

    // Normalizar nombres (por si tienen errores comunes)
    n1 = n1.replace("lactobacilus", "lactobacillus").replace("clostridum", "clostridium");
    n2 = n2.replace("lactobacilus", "lactobacillus").replace("clostridum", "clostridium");

    if ((n1.contains("lactobacillus acidophilus") && n2.contains("streptococcus thermophilus")) ||
        (n1.contains("streptococcus thermophilus") && n2.contains("lactobacillus acidophilus"))) {
        registrarInteraccion(b1.getNombreCientifico() + " + " + b2.getNombreCientifico() + " = SIMBIOSIS (crecen juntas)");
        return;
    }

    if (n1.contains("clostridium botulinum") && !n2.contains("clostridium botulinum")) {
        registrarInteraccion(b1.getNombreCientifico() + " INHIBE a " + b2.getNombreCientifico() + " (toxina)");
        return;
    }
    if (n2.contains("clostridium botulinum") && !n1.contains("clostridium botulinum")) {
        registrarInteraccion(b2.getNombreCientifico() + " INHIBE a " + b1.getNombreCientifico() + " (toxina)");
        return;
    }

    if ((n1.contains("halobacterium salinarum") && n2.contains("methanococcus jannaschii")) ||
        (n1.contains("methanococcus jannaschii") && n2.contains("halobacterium salinarum"))) {
        registrarInteraccion(b1.getNombreCientifico() + " COMPITE con " + b2.getNombreCientifico() + " (recursos limitados)");
        return;
    }

    registrarInteraccion(b1.getNombreCientifico() + " COEXISTE con " + b2.getNombreCientifico() + " (sin efectos)");
}


    private void registrarInteraccion(String interaccion) {
        if (totalInteracciones < interaccionesOcurridas.length) {
            interaccionesOcurridas[totalInteracciones] = interaccion;
            totalInteracciones++;
        }
    }

    public String[] getInteraccionesOcurridas() {
        String[] resultado = new String[totalInteracciones];
        for (int i = 0; i < totalInteracciones; i++) resultado[i] = interaccionesOcurridas[i];
        return resultado;
    }
}
