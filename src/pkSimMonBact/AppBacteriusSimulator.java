package pkSimMonBact;

import pkSimMonBact.pkBiologos.Bacteriologo;
import pkSimMonBact.pkBiologos.MicrobiologoAmbiental;
import pkSimMonBact.pkMonera.pkArqueobacterias.Halobacterium_Salinarum;

public class AppBacteriusSimulator {
    public void inicializar(){
        imprimirBienvenida();
        Bacteriologo bacteriologo1 = new Bacteriologo();
        MicrobiologoAmbiental microBioAmb1 =new MicrobiologoAmbiental("null", null, null, null, null, null, null, null, null, null);
        microBioAmb1.analizarRespuestaSalinidad("");
         Halobacterium_Salinarum halo1=new Halobacterium_Salinarum(null, null, 23.3);

        

    }

    private void imprimirBienvenida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirBienvenida'");
    }

}
