import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese la hora en formato HH:MM
        System.out.print("Introduce la hora en formato HH:MM: ");
        String hora = scanner.nextLine();

        // Validar que la hora tiene el formato correcto
        if (hora.matches("\\d{2}:\\d{2}") && Integer.parseInt(hora.substring(0, 2)) < 24 && Integer.parseInt(hora.substring(3, 5)) < 60) {
            // Extraer las horas y los minutos
            int horas = Integer.parseInt(hora.substring(0, 2));
            int minutos = Integer.parseInt(hora.substring(3, 5));

            // Convertir horas y minutos a palabras
            String horaEscrita = convertirHoraEscrita(horas, minutos);
            System.out.println("La hora es: " + horaEscrita);
        } else {
            System.out.println("El formato de la hora es incorrecto.");
        }

        scanner.close();
    }

    public static String convertirHoraEscrita(int horas, int minutos) {
        String[] horasEscritas = {
            "cero", "una", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", 
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", 
            "dieciocho", "diecinueve", "veinte", "veintiuno", "veintidós", "veintitrés"
        };

        String[] minutosEscritos = {
            "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", 
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", 
            "dieciocho", "diecinueve", "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", 
            "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve", "treinta", 
            "treinta y uno", "treinta y dos", "treinta y tres", "treinta y cuatro", "treinta y cinco", 
            "treinta y seis", "treinta y siete", "treinta y ocho", "treinta y nueve", "cuarenta", 
            "cuarenta y uno", "cuarenta y dos", "cuarenta y tres", "cuarenta y cuatro", "cuarenta y cinco", 
            "cuarenta y seis", "cuarenta y siete", "cuarenta y ocho", "cuarenta y nueve", "cincuenta", 
            "cincuenta y uno", "cincuenta y dos", "cincuenta y tres", "cincuenta y cuatro", 
            "cincuenta y cinco", "cincuenta y seis", "cincuenta y siete", "cincuenta y ocho", 
            "cincuenta y nueve"
        };

        // Si los minutos son cero
        if (minutos == 0) {
            return horasEscritas[horas] + " en punto";
        }

        // Si los minutos son menores de 30
        if (minutos <= 30) {
            return horasEscritas[horas] + " y " + minutosEscritos[minutos];
        }

        // Si los minutos son mayores de 30, mostrar la siguiente hora
        if (minutos > 30) {
            if (horas == 23) {
                return "cero " + minutosEscritos[60 - minutos];
            } else {
                return horasEscritas[horas + 1] + " menos " + minutosEscritos[60 - minutos];
            }
        }

        return "";
    }
}

