package pkSimMonBact.pkBiologos;
import pkSimMonBact.pkMonera.ReinoMonera;
import pkSimMonBact.pkMonera.pkArqueobacterias.Halobacterium_Salinarum;
import pkSimMonBact.pkMonera.pkArqueobacterias.Methanococcus_Jannaschii;

public class MicrobiologoAmbiental extends Biologo {
    private String ecosistemaEstudiado;
    private String login;
    private String password;
    private String tipoAmbiente;

    public MicrobiologoAmbiental(String nombre, String apellido, Integer edad, Integer id, String campoEspecialidad, String laboratorioAsignado, String ecosistemaEstudiado, String login, String password, String tipoAmbiente) {
        super.setNombre("Maria");
        super.setApellido(apellido);
        super.setEdad(edad);
        super.setId(id);
        super.setCampoEspecialidad(campoEspecialidad);
        super.setLaboratorioAsignado(laboratorioAsignado);
        this.ecosistemaEstudiado = ecosistemaEstudiado;
        this.login = "login";
        this.password = "password";
        this.tipoAmbiente = tipoAmbiente;
    }

    @Override
    public String obtenerTipo() {
        return "MICROBIOLOGO";
    }

    public String getEcosistemaEstudiado() {
        return ecosistemaEstudiado;
    }

    public void setEcosistemaEstudiado(String ecosistemaEstudiado) {
        this.ecosistemaEstudiado = ecosistemaEstudiado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password=password.toLowerCase();
        if(password.equalsIgnoreCase("entrada123"))
        this.password = password;
        else{
            System.out.println("Contraseña Incorrecta intentelo nuevamente");
        }
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(String tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public void simularProduccionMetano(Methanococcus_Jannaschii bacteria) {
    System.out.println("🧪 Simulación de producción de metano iniciada...");
    System.out.println("🔬 Bacteria: " + bacteria.getNombreCientifico());
    System.out.println("📍 Hábitat: " + bacteria.getHabitat());
    System.out.println("🌍 Ecosistema estudiado: " + ecosistemaEstudiado);
    System.out.println("🌡️ Ambiente: " + tipoAmbiente);
    System.out.println("⚙️ Nivel actual de metano producido: " + bacteria.getNivelMetanoProducido() + " mmol");

    // Simular condiciones
    boolean hayCO2 = true;
    boolean hayH2 = true;

    boolean resultado = bacteria.generarMetano(hayCO2, hayH2);

    if (resultado) {
        System.out.println("✅ Condiciones óptimas detectadas (CO₂ y H₂ presentes).");
        System.out.println("🔋 Producción de metano exitosa.");
        System.out.println("📈 Nuevo nivel de metano: " + bacteria.getNivelMetanoProducido() + " mmol");
    } else {
        System.out.println("❌ Condiciones insuficientes para generar metano.");
    }
}


    public String evaluarCalidadAmbiental(double ph, double temperatura, double salinidad) {
        System.out.println("Evaluando calidad ambiental:");
        System.out.println(" - pH: " + ph);
        System.out.println(" - Temperatura: " + temperatura + "°C");
        System.out.println(" - Salinidad: " + salinidad + "‰");
        return "Calidad ambiental evaluada";
    }

    public void evaluarResistenciaAnaerobia(String bacteria) {
       
        System.out.println("Evaluando resistencia anaerobia de la bacteria: " + bacteria);
    }

    public void analizarRespuestaSalinidad(Halobacterium_Salinarum bacteria) {
    System.out.println("🧪 Análisis de respuesta a salinidad");
    System.out.println("🔬 Bacteria: " + bacteria.getNombreCientifico());
    System.out.println("📍 Hábitat: " + bacteria.getHabitat());
    System.out.println("🌊 Nivel de salinidad óptima: " + bacteria.getNivelSalinidadOptima() + " M");
    System.out.println("📈 Evaluación: " + bacteria.analizarRespuestaSalina());
}

    @Override
    public void generarInforme(ReinoMonera bacteria, Double tiempoAnalisis, String laboratorio) {
        System.out.println("========== INFORME DE MICROBACTERIOLOGO ==========");
        System.out.printf("🔬 Bacteria: %s%n", bacteria);
        System.out.printf("⏱️ Tiempo de análisis: %.2f horas%n", tiempoAnalisis);
        System.out.printf("🏢 Laboratorio: %s%n", laboratorio);
        System.out.printf("👨‍🔬 Analista: %s %s (ID: %d)%n", getNombre(), getApellido(), getId());
        System.out.printf("🧪 Especialidad: %s%n", getCampoEspecialidad());
        System.out.println("=============================================");
    }
    
}