package pkSimMonBact.pkBiologos;

import java.util.Scanner;
import pkSimMonBact.pkMonera.ReinoMonera;
import pkSimMonBact.pkMonera.pkArqueobacterias.Methanococcus_Jannaschii;
import pkSimMonBact.pkMonera.pkEubacterias.Lactobacilus_Acidophilus;
import pkSimMonBact.pkMonera.pkEubacterias.ClostridumBotulinum;



public abstract class Biologo {
    Scanner scanner = new Scanner(System.in);

    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer Id;
    private String campoEspecialidad;
    private String laboratorioAsignado;
    private int contadorBacterias = 0;

    public Integer getId() {
        if (Id == null || Id < 0) {
            System.out.println("⚠️ Advertencia: ID no asignado o inválido.");
        }
        return Id;
    }

    public String getNombre() {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("⚠️ Advertencia: Nombre no asignado.");
        }
        return nombre;
    }

    public String getApellido() {
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println("⚠️ Advertencia: Apellido no asignado.");
        }
        return apellido;
    }

    public Integer getEdad() {
        if (edad == null || edad < 0) {
            System.out.println("⚠️ Advertencia: Edad no válida.");
        }
        return edad;
    }

    public String getCampoEspecialidad() {
        if (campoEspecialidad == null || campoEspecialidad.trim().isEmpty()) {
            System.out.println("⚠️ Advertencia: Campo de especialidad no definido.");
        }
        return campoEspecialidad;
    }

    public String getLaboratorioAsignado() {
        if (laboratorioAsignado == null || laboratorioAsignado.trim().isEmpty()) {
            System.out.println("⚠️ Advertencia: Laboratorio no asignado.");
        }
        return laboratorioAsignado;
    }

    public void setId(Integer id) {
        if (id == null || id < 0) {
            System.out.println("❌ Error: El ID debe ser un número positivo.");
        } else {
            this.Id = id;
        }
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("❌ Error: El nombre no puede estar vacío.");
        } else {
            this.nombre = nombre.trim();
        }
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println("❌ Error: El apellido no puede estar vacío.");
        } else {
            this.apellido = apellido.trim();
        }
    }

    public void setEdad(Integer edad) {
        if (edad == null || edad < 0) {
            System.out.println("❌ Error: La edad debe ser un número positivo.");
        } else {
            this.edad = edad;
        }
    }

    public void setCampoEspecialidad(String campoEspecialidad) {
        if (campoEspecialidad == null || campoEspecialidad.trim().isEmpty()) {
            System.out.println("❌ Error: El campo de especialidad no puede estar vacío.");
        } else {
            this.campoEspecialidad = campoEspecialidad.trim();
        }
    }

    public void setLaboratorioAsignado(String laboratorioAsignado) {
        if (laboratorioAsignado == null || laboratorioAsignado.trim().isEmpty()) {
            System.out.println("❌ Error: El laboratorio asignado no puede estar vacío.");
        } else {
            this.laboratorioAsignado = laboratorioAsignado.trim();
        }
    }

    public void registrarBacteria() {
        
        System.out.println("🔬 Registro de bacteria iniciado...");
        System.out.println("Ingrese el nombre o código de la bacteria:");
        System.out.println("1 → Methanococcus jannaschii");
        System.out.println("2 → Lactobacillus acidophilus");
        System.out.println("3 → Clostridium botulinum");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        ReinoMonera bacteria = null;

        switch (opcion) {
            case 1 -> bacteria = new Methanococcus_Jannaschii(
                "Methanococcus jannaschii", "Fosas marinas", 0.0, 6.5, 80.0, false, true);
            case 2 -> bacteria = new Lactobacilus_Acidophilus(
                "Lactobacillus acidophilus", "Intestino humano", 0.8, 5.5, 37.0, false, false);
            case 3 -> bacteria = new ClostridumBotulinum(
                "Clostridium botulinum", "Suelo", 1.0, 7.0, 30.0, true, true);
            default -> System.out.println("❌ Opción inválida.");
        }

        if (bacteria != null) {
            contadorBacterias++;
            System.out.println("✅ Bacteria registrada: " + bacteria.getNombreCientifico());
            System.out.println("📊 Total de bacterias registradas: " + contadorBacterias);
        }
    }

    public void generarInforme(ReinoMonera bacteria, Double tiempoAnalisis, String laboratorio) {
        System.out.println("========== INFORME DE ANÁLISIS ==========");
        System.out.printf("🧫 Bacteria: %s%n", bacteria);
        System.out.printf("⏱️ Tiempo de análisis: %.2f horas%n", tiempoAnalisis);
        System.out.printf("🏢 Laboratorio: %s%n", laboratorio);
        System.out.printf("👨‍🔬 Analista: %s %s%n", getNombre(), getApellido());
        System.out.println("=========================================");
    }
}
