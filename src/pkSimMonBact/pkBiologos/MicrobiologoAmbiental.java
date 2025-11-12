package pkSimMonBact.pkBiologos;

public class MicrobiologoAmbiental extends Biologo {
    private String ecosistemaEstudiado;
    private String login;
    private String password;
    private String tipoAmbiente;

    public MicrobiologoAmbiental(String nombre, String apellido, Integer edad, String id, String campoEspecialidad, String laboratorioAsignado, String ecosistemaEstudiado, String login, String password, String tipoAmbiente) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        super.setEdad(edad);
        super.setId(id);
        super.setCampoEspecialidad(campoEspecialidad);
        super.setLaboratorioAsignado(laboratorioAsignado);
        this.ecosistemaEstudiado = ecosistemaEstudiado;
        this.login = login;
        this.password = password;
        this.tipoAmbiente = tipoAmbiente;
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
        this.password = password;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(String tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public void simularProduccionMetano(String methanococcus) {
        System.out.println("Simulando producción de metano por " + methanococcus + " en ambiente " + tipoAmbiente + " del ecosistema " + ecosistemaEstudiado);
    
    }

    public String evaluarCalidadAmbiental(double ph, double temperatura, double salinidad) {
        System.out.println("Evaluando calidad ambiental:");
        System.out.println(" - pH: " + ph);
        System.out.println(" - Temperatura: " + temperatura + "°C");
        System.out.println(" - Salinidad: " + salinidad + "‰");
        return "Calidad ambiental evaluada";
    }

    public void evaluarResistenciaAnaerobia(String bacteria) {
       // registrarBacteria(bacteria); 
        System.out.println("Evaluando resistencia anaerobia de la bacteria: " + bacteria);
    }

    public void analizarRespuestaSalinidad(String halobacterium) {
        System.out.println("Analizando respuesta a salinidad de: " + halobacterium);
    }
    // desarrolloo mas de clases a fututro con datos de bacterias
}