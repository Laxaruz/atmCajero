package com.atm;
import java.util.Scanner;
public class cajeroAtm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Variables a tomar en cuenta
        final int PINCORRECTO = 6654 ;
        double saldo = 130600 ;
        int intentos = 0 ;
        boolean bloqueo = false ;
        StringBuilder recibo = new StringBuilder(); // Para almacenar el historial del cajero
        

        // Método de autentificación

        while (intentos < 3) {
            System.out.println("Escribe el pin de seguridad: ");
            int pin = sc.nextInt();

            //Condiciones
            if (pin == PINCORRECTO ) 
            {
                System.out.println("Bienvenido al sistema");
                break;
            }
            intentos ++; //Incrementa antes de revisar si llega a 3
            System.out.println("Pin incorrecto, le quedan: " +(3- intentos) + " intentos");
                    
            if (intentos == 3) 
            {
                bloqueo = true ;
                System.out.println(" Lo lamentamos, su cuenta ha sido bloqueada.");
                return;
            }
        } 
        // Menu del cajero

        int opciones ;
        while (true) 
        {
            System.out.println("Bienvenido a Laxaruz.");
            System.out.println("Elija una de las opciones.");
            System.out.println("1. Consulte su saldo.");
            System.out.println("2. Retiro de dinero.");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");

            opciones = sc.nextInt(); //Booleano para la operaciones

            boolean operacionExitosa = false ;

        switch (opciones) {
            case 1:
                System.out.println("Tú dinero en la cuenta es: " + saldo);
                recibo.append("Consulta de saldo: $" + saldo + "\n");
                operacionExitosa = true ;
                break;
            case 2: 
                System.out.println("¿Cuánto dinero desea retirar? : ");
                double retiro = sc.nextDouble();
                if (retiro <= 0 || retiro > saldo)
                {
                    System.out.println("⚠ Monto inválido o Fondos insuficientes.");
                    break;
                }
                    else {
                        saldo -= retiro;
                        System.out.println("💵 Has retirado $"+ retiro + ". Saldo restante: $" + saldo);
                        recibo.append("Retiro -$" + retiro + "\n");
                        operacionExitosa = true ;
                    }
                    break;
            case 3:
                System.out.println("Elija método de deposito: \n (1) Deposito en cuenta propia \n (2) Deposito a otra cuenta: ");
                int tipoDeposito = sc.nextInt();

                if (tipoDeposito == 1) {
                    System.out.println("Ingrese la cantidad a depositar: ");
                    double deposito = sc.nextDouble();
                    if (deposito <= 0) {
                        System.out.println("Monto inválido. intente nuevamente.");
                        break;
                    }
                    saldo += deposito; 
                    System.out.println("Has depositado con éxito " + deposito + " en tu cuenta, saldo actual: " + saldo);
                    recibo.append("Depósito en cuenta propia: +$" + deposito + "\n");
                    operacionExitosa = true;
                } else if  (tipoDeposito == 2) {
                    //Deposito en otra cuenta
                    System.out.println("Ingrese cuenta del destinatario: ");
                    String cuentaDestino = sc.next();
                    System.out.println("Ingrese cantidad a depositar: ");
                    double transferencia = sc.nextDouble();
                    if (transferencia <= 0) {
                        System.out.println("Monto inválido. Intente nuevamente.");
                        break;
                    }
                    System.out.println("Has transferido con éxito " + transferencia + " a la cuenta : " +cuentaDestino );
                    recibo.append("Transferencia a cuenta " + cuentaDestino + ": -$" + transferencia + "\n");
                    operacionExitosa = true ;
                }
                else {
                    System.out.println("Opción no valida");
                }
                break;
            case 4: 
                System.out.println("Gracias por usar Laxaruz. ¡Hasta luego! 👋");
                return;
            default:
            System.out.println("⚠ Opción no valida, intente nuevamente.");
        }
        //Menú para la despues de la operación exitosa
        if (operacionExitosa) 
        {
            int postOpcion;
            do 
            {
                System.out.println("Seleccione una opción \n");
                System.out.println("(1) Imprimir recibo y Salir.");
                System.out.println("(2) Salir");
                System.out.print("Seleccione una opción: ");
                postOpcion = sc.nextInt();

                if (postOpcion == 1) 
                {
                    System.out.println("Imprimiendo recibo...");
                    System.out.println("-----------------");
                    System.out.println(recibo.toString());
                    System.out.println("-----------------");
                    return;
                }else if (postOpcion == 2)
                {
                    System.out.println("Gracias por Usar Laxaruz. ¡¡¡Hasta luego!!!");
                    return;
                }else 
                {
                    System.out.println("Opción no válida, intente nuevamente.");
                }
            } while (postOpcion != 1 && postOpcion != 2) ;
        }       
            
        
        sc.close();
    } 
    
    
} 
}