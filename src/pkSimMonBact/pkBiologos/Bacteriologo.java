package pkSimMonBact.pkBiologos;

import pkSimMonBact.pkMonera.ReinoMonera;
import pkSimMonBact.pkMonera.pkEubacterias.ClostridumBotulinum;
import pkSimMonBact.pkMonera.ReinoMonera;
import pkSimMonBact.pkMonera.pkEubacterias.Lactobacilus_Acidophilus;
import pkSimMonBact.pkMonera.pkEubacterias.ClostridumBotulinum;

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

    
    public void evaluarFermentacion(ReinoMonera bacteria) {
    System.out.println("🧫 Evaluando fermentación en: " + bacteria.getNombreCientifico());
    System.out.println("📍 Hábitat: " + bacteria.getHabitat());
    System.out.println("🧪 pH óptimo: " + bacteria.getPhOptimo());
    System.out.println("🌡️ Temperatura óptima: " + bacteria.getTemperaturaOptima() + "°C");

    if (bacteria instanceof Lactobacilus_Acidophilus) {
        System.out.println("✅ Fermentación láctica esperada.");
    } else if (bacteria instanceof ClostridumBotulinum) {
        System.out.println("⚠️ Fermentación puede generar toxinas peligrosas.");
    } else {
        System.out.println("ℹ️ Tipo de fermentación no especificado para esta bacteria.");
    }
}

public void compararFermentacion(ReinoMonera b1, ReinoMonera b2) {
    System.out.println("🔍 Comparando fermentación entre:");
    System.out.println("🧫 " + b1.getNombreCientifico() + " → pH: " + b1.getPhOptimo() + ", Temp: " + b1.getTemperaturaOptima());
    System.out.println("🧫 " + b2.getNombreCientifico() + " → pH: " + b2.getPhOptimo() + ", Temp: " + b2.getTemperaturaOptima());

    if (b1.getPhOptimo() < b2.getPhOptimo()) {
        System.out.println("📊 " + b1.getNombreCientifico() + " fermenta mejor en medios más ácidos.");
    } else {
        System.out.println("📊 " + b2.getNombreCientifico() + " fermenta mejor en medios más ácidos.");
    }
}

public void medirProduccionAcidoLactico(ReinoMonera bacteria) {
    System.out.println("📊 Midiendo ácido láctico en: " + bacteria.getNombreCientifico());

    if (bacteria instanceof Lactobacilus_Acidophilus) {
        System.out.println("✅ Producción alta de ácido láctico esperada.");
    } else {
        System.out.println("ℹ️ Producción de ácido láctico no característica de esta especie.");
    }
}

public String identificarPatogeno(ReinoMonera bacteria) {
    if (bacteria instanceof ClostridumBotulinum && bacteria.getEsPatogeno()) {
        return "🦠 Patógeno identificado: Clostridium botulinum con toxina activa.";
    } else if (bacteria.getEsPatogeno()) {
        return "🦠 Patógeno identificado: " + bacteria.getNombreCientifico();
    } else {
        return "✅ " + bacteria.getNombreCientifico() + " no es considerado patógeno.";
    }
}
    public void registrarActividadToxica(ClostridumBotulinum bacteria) {
    System.out.println("☣️ REGISTRO DE ACTIVIDAD TÓXICA");
    System.out.println("🔬 Bacteria: Clostridium botulinum");
    System.out.println("🌡️ Ambiente: " + (bacteria.isAmbienteSinOxigeno() ? "ADECUADO (SIN OXÍGENO)" : "INADECUADO (CON OXÍGENO)"));
    System.out.println("🧪 Toxina: " + (bacteria.isToxinaActiva() ? "ACTIVADA" : "INACTIVA"));
    System.out.printf("📈 Nivel de toxina: %.2f mmol/L%n", bacteria.getNivelToxina());
    System.out.println("✅ Actividad registrada correctamente.");
}


}
