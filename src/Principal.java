import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        boolean loop = true;
        while (loop) {
            System.out.println("******************************** ");
            System.out.println("Sea Bienvenidoz/a al conversor de moneda: ");

            Scanner opc = new Scanner(System.in);
            System.out.println("1. Dolar => Peso argentino\n2. Peso Argentino => Dolar\n3. Dolar => Real Brasileño\n4. Real Brasileño => Dolar\n5. Dolar => Peso colombiano\n6. Peso colombiano => a dolar\n7. Salir");
            int opcion = opc.nextInt();
            if (opcion >= 1 & opcion<=6 ) {

                Scanner cambiomoneda = new Scanner(System.in);
                System.out.println("Digite el valor que desea convertir");
                int monedaConversion = cambiomoneda.nextInt();

                String monedaRecibida = null;
                String convertir = null;


                switch (opcion) {
                    case 1:
                        monedaRecibida = "USD";
                        convertir = "ARS";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 2:
                        monedaRecibida = "ARS";
                        convertir = "USD";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 3:
                        monedaRecibida = "USD";
                        convertir = "BRL";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 4:
                        monedaRecibida = "BRL";
                        convertir = "USD";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 5:
                        monedaRecibida = "USD";
                        convertir = "COP";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 6:
                        monedaRecibida = "COP";
                        convertir = "USD";
                        Moneda.cambioDeMoneda(monedaRecibida, convertir, monedaConversion);
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("este es un mensaje que esta por default");
                }
            }else if (opcion==7){
                System.out.println("Gracias por usar el conversor de moneda");
                System.exit(0);
            }else{
                System.out.println("Digite una opcion valida entre 1 y 7 ");}

        }
    }
}