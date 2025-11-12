package pkSimMonBact.pkBiologos;

public class Bacteriologo extends Biologo {

    private boolean manejaPatogenosPeligrosos;
    private String login;
    private String password;
    private int nivelBioseguridad;

    public Bacteriologo(String nombre, String apellido, Integer edad, Integer id,String campoEspecialidad, String laboratorioAsignado,boolean manejaPatogenosPeligrosos, String login,String password, int nivelBioseguridad) {

        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setEdad(edad);
        super.setId(id);
        super.setCampoEspecialidad(campoEspecialidad);
        super.setLaboratorioAsignado(laboratorioAsignado);

        this.manejaPatogenosPeligrosos = manejaPatogenosPeligrosos;
        this.login = login;
        this.password = password;
        this.nivelBioseguridad = nivelBioseguridad;
    }

    
    public void evaluarFermentacion(String bacteria) {
        System.out.println("🧫 Evaluando fermentación en: " + bacteria);
    }

    public void compararFermentacion(String bacteria1, String bacteria2) {
        System.out.println("🔍 Comparando fermentación entre " + bacteria1 + " y " + bacteria2);
    }

    public void medirProduccionAcidoLactico(String bacteria) {
        System.out.println("📊 Midiendo ácido láctico en: " + bacteria);
    }

    public String identificarPatogeno(String bacteria) {
        return "🦠 Patógeno identificado en " + bacteria + ": Clostridium botulinum";
    }

    public void registrarActividadToxica(String clostridiumB) {
        System.out.println("☣️ Actividad tóxica registrada para: " + clostridiumB);
    }

    
    
    @Override
    public void generarInforme(String bacteria, Double tiempoAnalisis, String laboratorio) {
        System.out.println("========== INFORME DE BACTERIÓLOGO ==========");
        System.out.printf("🔬 Bacteria: %s%n", bacteria);
        System.out.printf("⏱️ Tiempo de análisis: %.2f horas%n", tiempoAnalisis);
        System.out.printf("🏢 Laboratorio: %s%n", laboratorio);
        System.out.printf("👨‍🔬 Analista: %s %s (ID: %d)%n", getNombre(), getApellido(), getId());
        System.out.printf("🧪 Especialidad: %s%n", getCampoEspecialidad());
        System.out.printf("🛡️ Nivel de Bioseguridad: %d%n", nivelBioseguridad);
        System.out.printf("☣️ Maneja patógenos peligrosos: %s%n", manejaPatogenosPeligrosos ? "Sí" : "No");
        System.out.println("=============================================");
    }

    public void mostrarCredenciales() {
        System.out.println("🔐 Usuario: " + login);
        System.out.println("🔐 Contraseña: " + "*".repeat(password.length()));
    }

    public String resumenPerfil() {
        return String.format("""
            🧪 PERFIL DEL BACTERIÓLOGO
            Nombre: %s %s
            Edad: %d
            ID: %d
            Especialidad: %s
            Laboratorio: %s
            Nivel Bioseguridad: %d
            Patógenos Peligrosos: %s
            """, getNombre(), getApellido(), getEdad(), getId(),
            getCampoEspecialidad(), getLaboratorioAsignado(),
            nivelBioseguridad, manejaPatogenosPeligrosos ? "Sí" : "No");
    }
}
