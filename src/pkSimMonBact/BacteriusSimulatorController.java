

import java.util.Scanner;

import pkBiologos.Biologo;
import pkMonera.ReinoMonera;

public class BacteriusSimulatorController {
    private ReinoMonera[] bacterias = new ReinoMonera[200];
    private Biologo[] biologos = new Biologo[20];
    private Simulacion[] simulaciones = new Simulacion[100];
    private Biologo usuarioActual = null;

    private int totalBacterias = 0;
    private int totalBiologos = 0;
    private int totalSimulaciones = 0;

    public BacteriusSimulatorController() {
        biologos[0] = new Bacteriologo("Juan", "García", 30, 1, "Microbiología", "Lab1", "juan01", "clave123");
        biologos[1] = new MicrobiologoAmbiental("María", "López", 28, 2, "Ecología", "Lab2", "Océano", "eco01", "entrada123", "Marino");
        totalBiologos = 2;
    }

    public void inicializar() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            if (this.getUsuarioActual() == null) {
                System.out.println("\n--- MENU (NO autenticado) ---");
                System.out.println("1) Iniciar sesión");
                System.out.println("0) Salir");
                System.out.print("Opción: ");
                String line = sc.nextLine();

                if (line.equals("1")) {
                    System.out.print("Login: ");
                    String login = sc.nextLine();
                    System.out.print("Password: ");
                    String pwd = sc.nextLine();
                    boolean ok = this.autenticar(login, pwd);
                    System.out.println(ok ? "Autenticado como " + this.getUsuarioActual().getNombre()
                                          : "Credenciales inválidas");
                } else if (line.equals("0")) {
                    running = false;
                }

            } else {
                Biologo u = this.getUsuarioActual();
                System.out.println("\n--- MENU (usuario: " + u.getNombre() + ") ---");
                System.out.println("1) Ver bacterias");
                System.out.println("2) Registrar bacteria (solo Bacteriólogo)");
                System.out.println("3) Crear simulación (solo Microbiólogo)");
                System.out.println("4) Ver mis simulaciones");
                System.out.println("5) Cerrar sesión");
                if (u instanceof MicrobiologoAmbiental) System.out.println("6) Ejecutar simulación");
                System.out.println("0) Salir");
                System.out.print("Opción: ");
                String opt = sc.nextLine();

                switch (opt) {
                    case "1":
                        ReinoMonera[] bs = this.obtenerTodasLasBacterias();
                        if (bs.length == 0) System.out.println("No hay bacterias registradas");
                        for (ReinoMonera b : bs)
                            System.out.println("- " + b.getNombreCientifico());
                        break;

                    case "2":
                        if (u instanceof Bacteriologo) {
                            crearBacteriaInteractiva(sc);
                        } else {
                            System.out.println("Solo los Bacteriólogos pueden registrar bacterias.");
                        }
                        break;

                    case "3":
                        if (u instanceof MicrobiologoAmbiental) {
                            System.out.print("Nombre simulación: ");
                            String nombreSim = sc.nextLine();
                            System.out.print("pH: ");
                            double ph = Double.parseDouble(sc.nextLine());
                            System.out.print("Temperatura: ");
                            double temp = Double.parseDouble(sc.nextLine());
                             Simulacion sim = this.crearSimulacion(nombreSim, ph, temp);

                        if (sim != null) {
            // Mostrar bacterias disponibles
                        ReinoMonera[] todas = this.obtenerTodasLasBacterias();
                    if (todas.length == 0) {
                        System.out.println(" No hay bacterias registradas. Pídele al bacteriólogo que agregue algunas.");
                    } else {
                        System.out.println("Seleccione bacterias a incluir en la simulación (separadas por coma):");
                    for (int i = 0; i < todas.length; i++) {
                        System.out.println((i + 1) + ") " + todas[i].getNombreCientifico());
                    }
                    System.out.print("Opción(es): ");
                    String seleccion = sc.nextLine();
                    String[] partes = seleccion.split(",");
                for (String p : partes) {
                    try {
                        int idx = Integer.parseInt(p.trim()) - 1;
                        if (idx >= 0 && idx < todas.length) {
                            sim.anadirBacteria(todas[idx]);
                        }
                    } catch (Exception e) {
                        // Ignora errores de número
                    }
                }
            }

            System.out.println(" Simulación creada correctamente con " + sim.getBacterias().length + " bacterias.");
        }
    } else {
        System.out.println("Solo Microbiólogos pueden crear simulaciones.");
    }
    break;

                    case "4":
                        Simulacion[] sims = this.obtenerMisSimulaciones();
                        if (sims.length == 0) System.out.println("No tiene simulaciones");
                        for (Simulacion s : sims) System.out.println("- " + s.getNombre());
                        break;

                    case "5":
                        this.cerrarSesion();
                        System.out.println("Sesión cerrada.");
                        break;

                    case "6":
                        if (u instanceof MicrobiologoAmbiental) {
                            Simulacion[] misSims = this.obtenerMisSimulaciones();
                            if (misSims.length == 0) {
                                System.out.println("No tienes simulaciones para ejecutar.");
                            } else {
                                System.out.println("Simulaciones disponibles:");
                                for (int i = 0; i < misSims.length; i++) {
                                    System.out.println((i + 1) + ") " + misSims[i].getNombre());
                                }
                                System.out.print("Selecciona número de simulación: ");
                                int idx = Integer.parseInt(sc.nextLine()) - 1;
                                if (idx >= 0 && idx < misSims.length) this.ejecutarSimulacion(misSims[idx]);
                            }
                        }
                        break;

                    case "0":
                        running = false;
                        break;
                }
            }
        }

        sc.close();
        System.out.println("Aplicación finalizada");
    }

    private void crearBacteriaInteractiva(Scanner sc) {
        System.out.println("\nSeleccione tipo de bacteria:");
        System.out.println("1) Eubacteria");
        System.out.println("2) Arqueobacteria");
        System.out.print("Opción: ");
        String tipo = sc.nextLine();

        ReinoMonera b = null;

        if (tipo.equals("1")) {
            System.out.println("Seleccione Eubacteria:");
            System.out.println("1) Lactobacillus acidophilus");
            System.out.println("2) Streptococcus thermophilus");
            System.out.println("3) Clostridium botulinum");
            String sub = sc.nextLine();

            switch (sub) {
                case "1":
                    b = new Lactobacilus_Acidophilus(
                        "Lactobacillus acidophilus",
                        "Intestino humano",
                        6.5,
                        37.0,
                        false,
                        true,
                        true,
                        "Gram positiva",
                        "Eubacteria",
                        "Fermentación láctica",
                        "Glucosa",
                        0.8,
                        1.2
                    );
                    break;

                case "2":
                    b = new Streptococcus_Thermophilus(
                        0.7,
                        1.1,
                        "Streptococcus thermophilus",
                        "Leche",
                        6.5,
                        42.0,
                        false,
                        false,
                        true,
                        "Gram positiva",
                        "Eubacteria",
                        "Fermentación láctica"
                    );
                    break;

                case "3":
                    b = new ClostridumBotulinum(
                        "Clostridium botulinum",
                        "Suelo",
                        7.0,
                        37.0,
                        true,
                        true,
                        false,
                        "Gram positiva",
                        "Eubacteria",
                        "Fermentación",
                        true,
                        true,
                        75.3
                    );
                    break;
            }
        } else if (tipo.equals("2")) {
            System.out.println("Seleccione Arqueobacteria:");
            System.out.println("1) Halobacterium salinarum");
            System.out.println("2) Methanococcus jannaschii");
            String sub = sc.nextLine();

            switch (sub) {
                case "1":
                    b = new Halobacterium_Salinarum(
                        "Halobacterium salinarum",
                        "Ambientes salinos",
                        7.0,
                        45.0,
                        false,
                        false,
                        "Gram negativa",
                        "Halófila extrema"
                        ,12.4
                    );
                    break;

                case "2":
                    b = new Methanococcus_Jannaschii(
                        "Methanococcus jannaschii",
                        "Aguas termales",
                        7.0,
                        85.0,
                        false,
                        true,
                        "Gram negativa",
                        "Metanógena",
                        2.3
                    );
                    break;
            }
        }

        if (b != null) {
            boolean ok = this.registrarBacteria(b);
            System.out.println(ok ? "Bacteria registrada correctamente." : "Error al registrar bacteria.");
        } else {
            System.out.println("Tipo no válido.");
        }
    }

    public boolean autenticar(String login, String password) {
        for (int i = 0; i < totalBiologos; i++) {
            Biologo b = biologos[i];
            if (b == null) continue;
            if (b instanceof MicrobiologoAmbiental m && m.getLogin().equals(login) && m.getPassword().equals(password)) {
                usuarioActual = m;
                return true;
            }
            if (b instanceof Bacteriologo bac && bac.getLogin().equals(login) && bac.getPassword().equals(password)) {
                usuarioActual = bac;
                return true;
            }
        }
        return false;
    }

    public Biologo getUsuarioActual() { return usuarioActual; }

    public void cerrarSesion() { usuarioActual = null; }

    public boolean registrarBacteria(ReinoMonera bacteria) {
        if (usuarioActual instanceof Bacteriologo) {
            if (totalBacterias < bacterias.length) {
                bacterias[totalBacterias++] = bacteria;
                return true;
            }
        }
        return false;
    }

    public ReinoMonera[] obtenerTodasLasBacterias() {
        ReinoMonera[] res = new ReinoMonera[totalBacterias];
        for (int i = 0; i < totalBacterias; i++) res[i] = bacterias[i];
        return res;
    }

    public Simulacion crearSimulacion(String nombre, double pH, double temperatura) {
        if (usuarioActual instanceof MicrobiologoAmbiental) {
            Simulacion sim = new Simulacion(nombre, usuarioActual, pH, temperatura);
            simulaciones[totalSimulaciones++] = sim;
            return sim;
        }
        return null;
    }

    public void ejecutarSimulacion(Simulacion sim) {
        if (sim == null) return;

        System.out.println("\n=== INICIANDO SIMULACIÓN: " + sim.getNombre() + " ===");
        System.out.println("pH: " + sim.getpHActual() + " | Temperatura: " + sim.getTemperaturaActual());

        ReinoMonera[] bs = sim.getBacterias();
        for (ReinoMonera b : bs) {
            double dPh = Math.abs(b.getPhOptimo() - sim.getpHActual());
            double dT = Math.abs(b.getTemperaturaOptima() - sim.getTemperaturaActual());
            System.out.println((dPh < 2 && dT < 5 ? "✓" : "✗") + " " + b.getNombreCientifico());
        }

        sim.ejecutarInteracciones();
        for (String inter : sim.getInteraccionesOcurridas())
            System.out.println("→ " + inter);

        System.out.println("=== FIN DE SIMULACIÓN ===");
    }

    public Simulacion[] obtenerMisSimulaciones() {
        int count = 0;
        for (Simulacion s : simulaciones) {
            if (s != null && s.getUsuarioCreador() == usuarioActual) count++;
        }
        Simulacion[] res = new Simulacion[count];
        int idx = 0;
        for (Simulacion s : simulaciones) {
            if (s != null && s.getUsuarioCreador() == usuarioActual) res[idx++] = s;
        }
        return res;
    }
}
