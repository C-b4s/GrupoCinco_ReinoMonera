package pkSimMonBact;

import pkSimMonBact.pkBiologos.Bacteriologo;
import pkSimMonBact.pkBiologos.MicrobiologoAmbiental;
import pkSimMonBact.pkMonera.pkArqueobacterias.Halobacterium_Salinarum;

public class AppBacteriusSimulator {
    

    private void imprimirBienvenida() {
        System.out.println(" Bienvenido al simulador Bacterius");
    System.out.println("=====================================");

    }
public void inicializar(){
        imprimirBienvenida();
        Bacteriologo bacteriologo1 = new Bacteriologo(
            "Luis", "Gómez", 40, 1001, "Microbiología General", "Lab Central",
            true, "luis.gomez", "clave123", 3
        );
            MicrobiologoAmbiental microBioAmb1 = new MicrobiologoAmbiental(
            "Ana", "Torres", 34, 1002, "Microbiología Ambiental", "Lab A",
            "Manglar costero", "ana.torres", "clave123", "Hipersalino"
        );

        Halobacterium_Salinarum halo1 = new Halobacterium_Salinarum(
            "Halobacterium salinarum", "Lago hipersalino", 2.8
        );
 microBioAmb1.analizarRespuestaSalinidad(halo1);
        

    }
}
