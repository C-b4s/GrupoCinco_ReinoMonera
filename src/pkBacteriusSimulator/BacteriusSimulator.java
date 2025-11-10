package pkBacteriusSimulator;
import pkBacteriusSimulator.pkSeresVivos.pkMonera.pkEubacterias.ClostridumBotulinum;

//Controller
public class BacteriusSimulator {
    
    public void iniciar(){


        // ...

        // APARTADO BACTERIA CLOSTRIDUM BOTULINUM
        ClostridumBotulinum clostridumBotulinum = new ClostridumBotulinum(true, true, 75.3);
        
        System.out.println("Comprobando el ambiente para cultivar la bacteria:\\n");
        clostridumBotulinum.cultivarEnAmbienteSeguro();
        System.out.println();
        System.out.println("Cultivando la bacteria y activando su toxina:\\n");
        clostridumBotulinum.activarToxina();
        System.out.println();
        System.out.println("Buscando informacion de la bacteria Clostridum Botulinum:\n");
        clostridumBotulinum.mostrarActividadToxica();
        System.out.println();
        // Aqui va la interaccion con otro bacteria.
        System.out.println("Finalizando proceso......");
        System.out.println("Desactivando toxina y guardando la bacteria:");
        clostridumBotulinum.desactivarToxina();
        System.out.println();

        // ...
    }
}
