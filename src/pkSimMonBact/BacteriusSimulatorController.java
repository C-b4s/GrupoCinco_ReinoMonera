package pkSimMonBact;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import pkSimMonBact.pkBiologos.*;
import pkSimMonBact.pkMonera.ReinoMonera;
import pkSimMonBact.pkSimulacion.Simulacion;

import pkSimMonBact.pkMonera.pkEubacterias.*;
import pkSimMonBact.pkMonera.pkArqueobacterias.*;

public class BacteriusSimulatorController {
    public static  final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static  final String RESET = "\u001B[0m";

    private ReinoMonera[] bacterias = new ReinoMonera[200];
    private Biologo[] biologos = new Biologo[20];
    private Simulacion[] simulaciones = new Simulacion[100];
    private Biologo usuarioActual = null;

    private int totalBacterias = 0;
    private int totalBiologos = 0;
    private int totalSimulaciones = 0;

    public BacteriusSimulatorController() {
        biologos[0] = new Bacteriologo(
        "Juan", 
        "García", 
        30, 
        1,
        "Microbiología", 
        "Lab1",
        true,              
        "juan01",          
        "clave123",      
        3                  
);

        biologos[1] = new MicrobiologoAmbiental("María", "López", 28, 2, "Ecología", "Lab2", "Océano", "eco01", "entrada123", "Marino");
        totalBiologos = 2;
    }

    public void inicializar() {
        Scanner ingresoDatos = new Scanner (System.in);
        boolean running = true;

        while (running) {
            if (this.getUsuarioActual() == null) {
                System.out.println(VERDE + "\n--- MENU (NO autenticado) ---" + RESET);
                System.out.println("1) Iniciar sesión");
                System.out.println("0) Salir");
                System.out.print("Opción: ");
                String line = ingresoDatos.nextLine();

                if (line.equals("1")) {
                    System.out.print("Login: ");
                    String login = ingresoDatos.nextLine();
                    System.out.print("Password: ");
                    String pwd = ingresoDatos.nextLine();
                    boolean ok = this.autenticar(login, pwd);
                    System.out.println(ok ? AMARILLO + "Autenticado como " + this.getUsuarioActual().getNombre() + RESET
                                          : ROJO + "Credenciales inválidas"  + RESET);
                } else if (line.equals("0")) {
                    running = false;
                }else{
                    imprimirErrorOpcionIncorrecta();
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
                String opt = ingresoDatos.nextLine();

                switch (opt) {
                   case "1":
    ReinoMonera[] bs = this.obtenerTodasLasBacterias();
    if (bs.length == 0) {
        System.out.println(ROJO + "No hay bacterias registradas" + RESET);
        break;
    }

    System.out.println("Bacterias registradas:");
    for (int i = 0; i < bs.length; i++) {
        System.out.println((i + 1) + ") " + bs[i].getNombreCientifico());
    }

    System.out.print("Seleccione bacteria para ver información: ");

    try {
        int idxInfo = Integer.parseInt(ingresoDatos.nextLine()) - 1;

        if (idxInfo >= 0 && idxInfo < bs.length) {
            String pantallaInfo = mostrarInformacion(bs[idxInfo]);
            System.out.println(pantallaInfo);
        } else {
            System.out.println(ROJO + "Índice fuera de rango." + RESET);
        }

    } catch (NumberFormatException e) {
        System.out.println(ROJO + "Debe ingresar un número válido." + RESET);
    }

    break;

                    case "2":
                        if (u instanceof Bacteriologo) {
                            crearBacteriaInteractiva(ingresoDatos);
                        } else {
                            System.out.println("Solo los Bacteriólogos pueden registrar bacterias.");
                        }
                        break;

                    case "3":
                        if (u instanceof MicrobiologoAmbiental) {
                            System.out.print("Nombre simulación: ");
                            String nombreSim = ingresoDatos.nextLine();
                            System.out.print("pH: ");
                            double ph = Double.parseDouble(ingresoDatos.nextLine());
                            System.out.print("Temperatura: ");
                            double temp = Double.parseDouble(ingresoDatos.nextLine());
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
                    seleccionarBacterias(ingresoDatos, sim, todas);
                };
    } else {
        System.out.println("Solo Microbiólogos pueden crear simulaciones.");
    }
    break;}

                    case "4":
                        Simulacion[] sims = this.obtenerMisSimulaciones();
                        if (sims.length == 0) System.out.println(ROJO + "No tiene simulaciones" + RESET);
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
                                int idx = Integer.parseInt(ingresoDatos.nextLine()) - 1;
                                if (idx >= 0 && idx < misSims.length) this.ejecutarSimulacion(misSims[idx]);
                            }
                        }
                        break;

                    case "0":
                        running = false;
                        break;

                    default:
                        imprimirErrorOpcionIncorrecta();
                        break;
                }
            }
        }

        ingresoDatos.close();
        System.out.println("Aplicación finalizada");
    }

    
public void definirNivelesMetano(Methanococcus_Jannaschii m, Scanner sc) {
    double co2 = 0, h2 = 0;
    boolean valido = false;

    do {
        try {
            System.out.print("Ingrese nivel de CO₂ disponible: ");
            co2 = Double.parseDouble(sc.nextLine());

            System.out.print("Ingrese nivel de H₂ disponible: ");
            h2 = Double.parseDouble(sc.nextLine());

            if (co2 < 0 || h2 < 0) {
                System.out.println("Los valores no pueden ser negativos.");
            } else {
                valido = true;
            }

        } catch (NumberFormatException e) {
            System.out.println(" Debe ingresar valores numéricos válidos.");
        }

    } while (!valido);

    // Asignar valores al objeto
    m.setNivelCO2(co2);
    m.setNivelH2(h2);

    System.out.println("Niveles establecidos correctamente.");
}

    private void seleccionarBacterias(Scanner sc, Simulacion sim, ReinoMonera[] todas) {

    int cantidadMinima = 2;
    int max = todas.length;

    boolean entradaValida;

    do {
        entradaValida = true;

        // Lista temporal para evitar agregar bacterias si el usuario se equivoca
        ArrayList<ReinoMonera> seleccionTemporal = new ArrayList<>();

        System.out.print("Opción(es): ");
        String seleccion = sc.nextLine();
        String[] partes = seleccion.split(",");

        int contadorValidas = 0;

        for (String p : partes) {
            try {
                int numero = Integer.parseInt(p.trim());

                if (numero >= 1 && numero <= max) {
                    int idx = numero - 1;
                    seleccionTemporal.add(todas[idx]);
                    contadorValidas++;
                } else {
                        entradaValida = false;
                }

            } catch (NumberFormatException e) {
                imprimirErrorTipoNoValido();
                entradaValida = false;
            }
        }

        // Validar mínimo de bacterias
        if (contadorValidas < cantidadMinima) {
            imprimirErrorSeleccionBacterias(cantidadMinima);
            entradaValida = false;
        }

        // Si la entrada fue válida, recién aquí agregamos a la simulación
        if (entradaValida) {
            for (ReinoMonera b : seleccionTemporal) {
                sim.anadirBacteria(b);
            }

            System.out.println("Simulación creada correctamente con "
                    + sim.getBacterias().length + " bacterias.");
        }

    } while (!entradaValida);
    }

    private void imprimirErrorSeleccionBacterias(int cantidadMinima) {
        System.err.println(ROJO + "\n================== ERROR ==================\n" +
                           "Debes seleccionar al menos " + cantidadMinima + " bacterias.\n" + RESET);
        throw new UnsupportedOperationException("Unimplemented method 'imprimirErrorSeleccionBacterias'");
    }

    private void imprimirErrorTipoNoValido() {
      System.err.println(ROJO + "\n================== ERROR ==================\n" +
                           "El tipo de dato ingresado no es vàlido. Por favor, intente nuevamente.\n" + RESET);

    }

    private void imprimirErrorOpcionIncorrecta() {
        System.err.println(ROJO + "\n================== ERROR ==================\n" +
                           "Opción incorrecta. Por favor, intente de nuevo.\n" + RESET);

    }

    private void crearBacteriaInteractiva(Scanner sc) {
        System.out.println("\nSeleccione tipo de bacteria:");
        System.out.println("1) Eubacteria");
        System.out.println("2) Arqueobacteria");

        String tipo;
        do {
        System.out.print("Opción: ");
        tipo = sc.nextLine();

        if (!tipo.equals("1") && !tipo.equals("2")) imprimirErrorOpcionIncorrecta();
        } while (!tipo.equals("1") && !tipo.equals("2" ));
        

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
                        "Heterótrofa, anaerobia facultativa",
                        "Fermentación láctica",
                        "glucosa",
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
                        "Cocos, morfologia",
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
                        "Gram positivo, anaerobia estricta",
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
                        ,2.4
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
                        2.3,
                        0.0,
                        0.0
                    );
                    break;
            }
        }
        if (b instanceof Methanococcus_Jannaschii) {
            definirNivelesMetano((Methanococcus_Jannaschii)b, sc);
            b.ejecutarFuncionMetabolica();
        }
       if (b != null) {

    // 🔹 Ejecutar la función metabólica específica de la bacteria creada
    System.out.println("\n--- Función metabólica ejecutada ---");
    System.out.println(b.ejecutarFuncionMetabolica());
    System.out.println("------------------------------------\n");

    // 🔹 Registrar bacteria
    boolean ok = this.registrarBacteria(b);
    System.out.println(ok ? "Bacteria registrada correctamente." : ROJO + "Error al registrar bacteria." + RESET);

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

        System.out.println(VERDE + "\n=== INICIANDO SIMULACION: " + sim.getNombre() + " ===" + RESET);
        System.out.println("pH: " + sim.getpHActual() + " | Temperatura: " + sim.getTemperaturaActual());

        ReinoMonera[] bs = sim.getBacterias();
        for (ReinoMonera b : bs) {
            double dPh = Math.abs(b.getPhOptimo() - sim.getpHActual());
            double dT = Math.abs(b.getTemperaturaOptima() - sim.getTemperaturaActual());
            System.out.println((dPh < 2 && dT < 5 ? "--" : "✗") + " " + b.getNombreCientifico());
        }

        sim.ejecutarInteracciones();
        for (String inter : sim.getInteraccionesOcurridas())
            System.out.println("→ " + inter);

        System.out.println(VERDE + "=== FIN DE SIMULACION ===" + RESET);
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

    public String mostrarInformacion(ReinoMonera b1) {
    String info = "\n========== Información de la bacteria ==========\n";
    info += "Nombre científico: " + b1.getNombreCientifico() + "\n";
    info += "Hábitat: " + b1.getHabitat() + "\n";
    info += "pH óptimo: " + b1.getPhOptimo() + "\n";
    info += "Temperatura óptima: " + b1.getTemperaturaOptima() + " °C\n";
    info += "Es patógeno: " + (b1.getEsPatogeno() ? "Sí" : "No") + "\n";
    info += "Anaerobio estricto: " + (b1.getAnaerobioStricto()? "Sí" : "No") + "\n";
    info += "Funcion metabolica: " + b1.ejecutarFuncionMetabolica() + "\n";
    info += "================================================\n";
    return info;
}
}
