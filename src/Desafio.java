import java.util.Scanner;

public class Desafio {

    // Definición de constantes para el menú

    public static final int CONSULTAR_SALDO = 1;
    public static final int RETIRAR = 2;
    public static final int DEPOSITAR = 3;
    public static final int SALIR = 4;


    // Metodo principal del programa

    public static void main(String[] args) {
        String nombre = "Tony Stark";
        String tipoDeCuenta = "Corriente";
        double saldo = 1599.99;

        imprimirDatosCliente(nombre, tipoDeCuenta, saldo);

        try (Scanner teclado = new Scanner(System.in)) { //  Try, para cerrar el Scanner automáticamente

            int opcion = 0; // Inicializamos la variable opcion

            // Mientras la opción no sea SALIR, se ejecutará el menú

            while (opcion != SALIR) {
                mostrarMenu();
                opcion = leerOpcion(teclado);

                switch (opcion) {
                    case CONSULTAR_SALDO:
                        consultarSaldo(saldo);
                        break;
                    case RETIRAR:
                        saldo = retirar(saldo, teclado);
                        break;
                    case DEPOSITAR:
                        saldo = depositar(saldo, teclado);
                        break;
                    case SALIR:
                        System.out.println("Muchas gracias por usar nuestro banco");
                        break;
                    default:
                        System.out.println("Por favor, ingrese una opción válida.");
                }
            }
            teclado.close(); // Cerrar el Scanner al final del programa
        }
    }
    // Metodo para imprimir los datos del cliente

    private static void imprimirDatosCliente(String nombre, String tipoDeCuenta, double saldo) {
        System.out.println("*********************************************");
        System.out.println("\nNombre del cliente: " + nombre);
        System.out.println("El tipo de cuenta es: " + tipoDeCuenta);
        System.out.printf("El saldo en la cuenta es: %.2f $%n", saldo); // seteamos a 2 decimales..
        System.out.println("**********************************************\n");
    }
        // Metodo para mostrar el menu de opciones

    private static void mostrarMenu() { // Mostramos el menu ded intereccion con el usuario
        String menu = """
                **** Escriba el número de la operación deseada ****
                1. Consultar saldo
                2. Retirar
                3. Depositar
                4. Salir
                """;
        System.out.println(menu);
    }

    // Metodo para leer la opcion ingresada por el usuario

    private static int leerOpcion(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            teclado.next(); // Limpiar el buffer del Scanner
        }
        return teclado.nextInt();
    }
// Metodo para consultar el saldo

    private static void consultarSaldo(double saldo) {
        System.out.printf("El saldo actualizado es: %.2f $%n", saldo);
    }
// Metodo para retirar dinero de la cuenta

    private static double retirar(double saldo, Scanner teclado) {
        System.out.println("¿Cuál es el monto que desea retirar?");
        double valorARetirar = teclado.nextDouble();
        if (valorARetirar > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= valorARetirar;
            System.out.printf("El saldo actualizado es: %.2f $%n", saldo);
        }
        return saldo;
    }
// Metodo para depositar dinero en la cuenta
    private static double depositar(double saldo, Scanner teclado) {
        System.out.println("¿Cuál es el monto a depositar?");
        double valorADepositar = teclado.nextDouble();
        saldo += valorADepositar;
        System.out.printf("El saldo actualizado es: %.2f $%n", saldo);
        return saldo;
    }
 // Fin del programa

}
// Fin de la clase Desafio