package pkSimMonBact.pkBiologos;

<<<<<<< HEAD
import pkSimMonBact.pkMonera.ReinoMonera;

=======
import java.util.Scanner;
import pkSimMonBact.pkMonera.ReinoMonera;
>>>>>>> b35617688be206933a52badc77316a186febb92f
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
            System.out.println(" Advertencia: ID no asignado o inválido.");
        }
        return Id;
    }

    public String getNombre() {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println(" Advertencia: Nombre no asignado.");
        }
        return nombre;
    }

    public String getApellido() {
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println(" Advertencia: Apellido no asignado.");
        }
        return apellido;
    }

    public Integer getEdad() {
        if (edad == null || edad < 0) {
            System.out.println(" Advertencia: Edad no válida.");
        }
        return edad;
    }

    public String getCampoEspecialidad() {
        if (campoEspecialidad == null || campoEspecialidad.trim().isEmpty()) {
            System.out.println(" Advertencia: Campo de especialidad no definido.");
        }
        return campoEspecialidad;
    }

    public String getLaboratorioAsignado() {
        if (laboratorioAsignado == null || laboratorioAsignado.trim().isEmpty()) {
            System.out.println(" Advertencia: Laboratorio no asignado.");
        }
        return laboratorioAsignado;
    }

    public void setId(Integer id) {
        if (id == null || id < 0) {
            System.out.println(" Error: El ID debe ser un número positivo.");
        } else {
            this.Id = id;
        }
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println(" Error: El nombre no puede estar vacío.");
        } else {
            this.nombre = nombre.trim();
        }
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            System.out.println(" Error: El apellido no puede estar vacío.");
        } else {
            this.apellido = apellido.trim();
        }
    }

    public void setEdad(Integer edad) {
        if (edad == null || edad < 0) {
            System.out.println(" Error: La edad debe ser un número positivo.");
        } else {
            this.edad = edad;
        }
    }

    public void setCampoEspecialidad(String campoEspecialidad) {
        if (campoEspecialidad == null || campoEspecialidad.trim().isEmpty()) {
            System.out.println(" Error: El campo de especialidad no puede estar vacío.");
        } else {
            this.campoEspecialidad = campoEspecialidad.trim();
        }
    }

    public void setLaboratorioAsignado(String laboratorioAsignado) {
        if (laboratorioAsignado == null || laboratorioAsignado.trim().isEmpty()) {
            System.out.println(" Error: El laboratorio asignado no puede estar vacío.");
        } else {
            this.laboratorioAsignado = laboratorioAsignado.trim();
        }
    }

    public void generarInforme(ReinoMonera bacteria, Double tiempoAnalisis, String laboratorio) {
        System.out.println("========== INFORME DE ANÁLISIS ==========");
        System.out.printf(" Bacteria: %s%n", bacteria);
        System.out.printf(" Tiempo de análisis: %.2f horas%n", tiempoAnalisis);
        System.out.printf(" Laboratorio: %s%n", laboratorio);
        System.out.printf(" Analista: %s %s%n", getNombre(), getApellido());
        System.out.println("=========================================");
    }
<<<<<<< HEAD
    
    public void generarInforme(ReinoMonera bacteria , Double tiempoAnalisis, String laboratorio){    
        
        if (bacteria == null || tiempoAnalisis == null || laboratorio == null){
            throw new IllegalArgumentException("Parámetros nulos no permitidos para generar el informe.");
        }

        System.out.println("Generando informe...");
        System.out.println("================== INFORME DE ANÁLISIS BACTERILOGICO ==================");
        
        System.out.println(titulo);
        int espacios = titulo.length();

        System.out.print("|");
        System.out.println("Informe de " + bacteria + ": analizada por " + nombre + "en " + laboratorio +
        " durante " + tiempoAnalisis + "horas");
=======

    public String obtenerTipo() {
        // TODO Auto-generated method stu
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTipo'");
        
    }
       public int getContadorBacterias() {
        return contadorBacterias;
>>>>>>> b35617688be206933a52badc77316a186febb92f
    }

    public void setContadorBacterias(int contadorBacterias) {
        this.contadorBacterias = contadorBacterias;
    }
}
