package pkSimMonBact;

import pkSimMonBact.pkBiologos.Bacteriologo;
import pkSimMonBact.pkBiologos.MicrobiologoAmbiental;
import pkSimMonBact.pkMonera.pkArqueobacterias.Halobacterium_Salinarum;

public class AppBacteriusSimulator {
    public final String ROJO = "\u001B[31m";
    public final String RESET = "\u001B[0m";
    public final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";

    public void inicializar(){
        imprimirBienvenida();
        Bacteriologo bacteriologo1 = new Bacteriologo();
        MicrobiologoAmbiental microBioAmb1 =new MicrobiologoAmbiental("null", null, null, null, null, null, null, null, null, null);
        microBioAmb1.analizarRespuestaSalinidad("");
         Halobacterium_Salinarum halo1=new Halobacterium_Salinarum(null, null, 23.3);

        

    }

    private void imprimirBienvenida() {
        String titulo = "================== SIMMON BACT ==================";
        System.out.println(" ".repeat(15) + titulo);
        System.out.println(" ".repeat(30) + "Tu app de simulación de bacterias preferida.");
        System.out.println();

    }

}
