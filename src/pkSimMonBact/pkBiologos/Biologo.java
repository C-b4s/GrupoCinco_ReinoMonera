package pkSimMonBact.pkBiologos;

public abstract class Biologo {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer Id;
    private String campoEspecialidad;
    private String laboratorioAsignado;

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

    // ======= MÉTODOS FUNCIONALES =======

    public void registrarBacteria() {
        System.out.println("🔬 Registro de bacteria iniciado...");
    }

    public void generarInforme(String bacteria, Double tiempoAnalisis, String laboratorio) {
        System.out.println("========== INFORME DE ANÁLISIS ==========");
        System.out.printf("🧫 Bacteria: %s%n", bacteria);
        System.out.printf("⏱️ Tiempo de análisis: %.2f horas%n", tiempoAnalisis);
        System.out.printf("🏢 Laboratorio: %s%n", laboratorio);
        System.out.printf("👨‍🔬 Analista: %s %s%n", getNombre(), getApellido());
        System.out.println("=========================================");
    }
}
