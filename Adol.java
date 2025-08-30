import java.util.Scanner;

public class Adol{

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String apellidos1 = "cortes"; 
        double numero;
        int sumaPrecios = 0;
        
        String[] apellidos = new String[5];
        apellidos[0] = " cortes";
        apellidos [1] = "prado";
        apellidos [2] = "macc";
        apellidos [3] = "chot";
        apellidos [4] = "past";

        for (int i=0; i <apellidos.length; i++){
            System.out.println(apellidos[i]);


        }

        int[] precios = new int[3];
        for (int i= 0; i<precios.length; i++){
            System.out.println("dame el precio:");
            precios[i] = sc.nextInt();

        }
        for(int i = 0; i<precios.length; i++){
            System.out.println(precios[i]);
        }

       for(int i = 0; i<precios.length; i++){
        sumaPrecios = sumaPrecios + precios[i];
        System.out.println(" suma de los precios: "+ sumaPrecios);
        double promedio = sumaPrecios / precios.length;
        System.out.println(" promedio: "+ promedio);
       }



        /*
         sumaPrecios = 10
         i = 1
         cuando sumasPrecios vale 30
         i vale 2
         10
         20
         30
         */

       


    }

}
