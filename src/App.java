

public class App {
    public static void main(String[] args) {
        // Punto de entrada mínimo: delegar a AppBacteriusSimulator.inicializar()
        BacteriusSimulatorController controller = new BacteriusSimulatorController();
        controller.inicializar();
    }
}
