package principal;

import java.util.Scanner;


public class JavaLaboratorio {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEnteroSeguro();
            if (opcion == 0) break;
            ejecutarOpcion(opcion);
            System.out.println("\n>>> Presione ENTER para volver al menú <<<");
            sc.nextLine(); 
        }
        System.out.println("Programa finalizado.");
    }

    public static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("       MENÚ LABORATORIO COMPLETO        ");
        System.out.println("========================================");
        System.out.println("  1. Calculadora (Suma, Resta, Mult, Div)");
        System.out.println("  2. Validar Contraseña (Ciclo do-while)");
        System.out.println("  3. Verificar Número Primo");
        System.out.println("  4. Suma de Números Pares (Ciclo while)");
        System.out.println("  5. Conversión de Temperatura (Doble vía)");
        System.out.println("  6. Contador de Vocales");
        System.out.println("  7. Cálculo de Factorial (Validar negativo)");
        System.out.println("  8. Juego de Adivinanza (1-100)");
        System.out.println("  9. Paso por Referencia (Simulado)");
        System.out.println(" 10. Tabla de Multiplicar");
        System.out.println("  0. SALIR");
        System.out.println("========================================");
        System.out.print("👉 Seleccione: ");
    }

    // --- REQUISITO: VALIDACIÓN CON TRY-CATCH ---
    public static int leerEnteroSeguro() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("⚠ ERROR: Ingrese un número entero: ");
            }
        }
    }

    public static double leerDoubleSeguro() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("⚠ ERROR: Ingrese un valor numérico: ");
            }
        }
    }

    public static void ejecutarOpcion(int op) {
        switch (op) {
            case 1 -> calculadora();
            case 2 -> validarPassword();
            case 3 -> checkPrimo();
            case 4 -> sumarPares();
            case 5 -> convertirTemperatura();
            case 6 -> contarVocales();
            case 7 -> factorial();
            case 8 -> adivinanza();
            case 9 -> simularReferencia();
            case 10 -> mostrarTabla();
            default -> System.out.println("Opción inválida.");
        }
    }

    // 1. CALCULADORA (REQUISITO: MÉTODO POR OPERACIÓN Y EVITAR DIVISIÓN POR CERO)
    public static void calculadora() {
        System.out.print("Num 1: "); double a = leerDoubleSeguro();
        System.out.print("Num 2: "); double b = leerDoubleSeguro();
        System.out.println("Suma: " + (a+b) + " | Resta: " + (a-b) + " | Mult: " + (a*b));
        if (b != 0) System.out.println("Div: " + (a/b));
        else System.out.println("Div: No permitida por cero.");
    }

    // 2. PASSWORD (REQUISITO: CICLO DO-WHILE)
    public static void validarPassword() {
        String clave;
        do {
            System.out.print("Ingrese Contraseña: ");
            clave = sc.nextLine();
            if (!clave.equals("1234")) System.out.println("❌ Incorrecta.");
        } while (!clave.equals("1234"));
        System.out.println("🔓 Acceso concedido.");
    }

    // 3. PRIMOS
    public static void checkPrimo() {
        System.out.print("Número: ");
        int n = leerEnteroSeguro();
        boolean esP = n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) if (n % i == 0) esP = false;
        System.out.println(esP ? "Es primo" : "No es primo");
    }

    // 4. SUMA PARES (REQUISITO: CICLO WHILE HASTA INGRESAR 0)
    public static void sumarPares() {
        int suma = 0, num;
        System.out.println("Ingrese números (0 para salir):");
        while ((num = leerEnteroSeguro()) != 0) {
            if (num % 2 == 0) suma += num;
        }
        System.out.println("Suma de pares: " + suma);
    }

    // 5. TEMPERATURA (REQUISITO: MÉTODO PARA CADA CONVERSIÓN)
    public static void convertirTemperatura() {
        System.out.println("1. C a F | 2. F a C");
        int sub = leerEnteroSeguro();
        System.out.print("Valor: ");
        double v = leerDoubleSeguro();
        if (sub == 1) System.out.println("F: " + ((v * 9/5) + 32));
        else System.out.println("C: " + ((v - 32) * 5/9));
    }

    // 6. VOCALES
    public static void contarVocales() {
        System.out.print("Frase: ");
        String f = sc.nextLine().toLowerCase();
        int c = 0;
        for (char l : f.toCharArray()) if ("aeiou".indexOf(l) != -1) c++;
        System.out.println("Vocales: " + c);
    }

    // 7. FACTORIAL (REQUISITO: VALIDAR NO NEGATIVO)
    public static void factorial() {
        System.out.print("Número: ");
        int n = leerEnteroSeguro();
        if (n < 0) System.out.println("No se permiten negativos.");
        else {
            long res = 1;
            for (int i = 1; i <= n; i++) res *= i;
            System.out.println("Factorial: " + res);
        }
    }

    // 8. ADIVINANZA (REQUISITO: RANGO 1-100 Y DO-WHILE)
    public static void adivinanza() {
        int secreto = (int)(Math.random() * 100) + 1;
        int intento;
        System.out.println("Adivina del 1 al 100:");
        do {
            intento = leerEnteroSeguro();
            if (intento < secreto) System.out.println("Más alto...");
            else if (intento > secreto) System.out.println("Más bajo...");
        } while (intento != secreto);
        System.out.println("🎉 ¡Acertaste!");
    }

    // 9. REFERENCIA (REQUISITO: SIMULAR CON OBJETO/ARREGLO)
    public static void simularReferencia() {
        int[] vals = {10, 20};
        System.out.println("Antes: A=" + vals[0] + " B=" + vals[1]);
        intercambiar(vals);
        System.out.println("Después: A=" + vals[0] + " B=" + vals[1]);
    }
    public static void intercambiar(int[] a) {
        int t = a[0]; a[0] = a[1]; a[1] = t;
    }

    // 10. TABLA (REQUISITO: MÉTODO PARA GENERARLA)
    public static void mostrarTabla() {
        System.out.print("Número: ");
        int n = leerEnteroSeguro();
        for (int i = 1; i <= 10; i++) System.out.println(n + " x " + i + " = " + (n*i));
    }
}