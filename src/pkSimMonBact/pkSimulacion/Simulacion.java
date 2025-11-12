package pkSimMonBact.pkSimulacion;

import pkSimMonBact.pkBiologos.Biologo;
import pkSimMonBact.pkMonera.ReinoMonera;

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
        String nombre1 = b1.getNombreCientifico();
        String nombre2 = b2.getNombreCientifico();

        // SIMBIOSIS: Lactobacillus + Streptococcus
        if ((nombre1.contains("Lactobacillus") && nombre2.contains("Streptococcus")) ||
            (nombre1.contains("Streptococcus") && nombre2.contains("Lactobacillus"))) {
            registrarInteraccion(nombre1 + " + " + nombre2 + " = SIMBIOSIS ✓ (crecen juntas)");
            return;
        }

        // DEPREDACIÓN/INHIBICIÓN: Clostridium inhibe otros
        if (nombre1.contains("Clostridium") && !nombre2.contains("Clostridium")) {
            registrarInteraccion(nombre1 + " INHIBE a " + nombre2 + " ✗ (toxina)");
            return;
        }
        if (nombre2.contains("Clostridium") && !nombre1.contains("Clostridium")) {
            registrarInteraccion(nombre2 + " INHIBE a " + nombre1 + " ✗ (toxina)");
            return;
        }

        // COMPETENCIA ejemplo
        if ((nombre1.contains("Halobacterium") && nombre2.contains("Methanococcus")) ||
            (nombre1.contains("Methanococcus") && nombre2.contains("Halobacterium"))) {
            registrarInteraccion(nombre1 + " COMPITE con " + nombre2 + " ⚔️ (recursos limitados)");
            return;
        }

        // Por defecto: coexistencia
        registrarInteraccion(nombre1 + " COEXISTE con " + nombre2 + " → (sin efectos)");
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
