package pkSimMonBact.pkBiologos;

public class Bacteriologo extends Biologo {

    private String login;
    private String password;

    public Bacteriologo(String nombre, String apellido, Integer edad, Integer id,
                        String campoEspecialidad, String laboratorioAsignado,
                        String login, String password) {
        super.setNombre("Juan");
        super.setApellido(apellido);
        super.setEdad(edad);
        super.setId(id);
        super.setCampoEspecialidad(campoEspecialidad);
        super.setLaboratorioAsignado(laboratorioAsignado);
        this.login = login;
        this.password = password;
    }

    @Override
    public String obtenerTipo() {
        return "BACTERIOLOGO";
    }

    // Getters y setters
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
}

