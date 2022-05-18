import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение для вычисления:");
        try {
        String inputLine = scanner.nextLine();
        scanner.close();
        String result = calc(inputLine);
        if (result.length() < 50){System.out.println("Результат вычислений равен: " + "\n" + result);}
        else {System.out.println(result);}
        }
        catch (NumberFormatException e){
        System.out.println("Ошибка ввода данных. На вход должны подаваться одновременно целые арабские или римские числа," +
                " от 1 до 10 включительно, разделенные математическим знаком.");}}

    public static String calc(String input) {
        String operation = "";
        String result;
        String error = "Ошибка ввода данных. На вход должны подаваться одновременно целые арабские или римские числа," +
                " от 1 до 10 включительно, разделенные математическим знаком.";

        try {char[] search_operation = new char[10];
        for(int i = 0; i < input.length(); i++)
            {search_operation[i] = input.charAt(i);
            if (search_operation[i] == '+') {operation = "+"; break;}
            else if (search_operation[i] == '-') {operation = "-"; break;}
            else if (search_operation[i] == '*') {operation = "*"; break;}
            else if (search_operation[i] == '/') {operation = "/"; break;}}}
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(error);}

        String[] variables = input.split("[+*/-]");

        if (variables.length != 2) {
            return error;}

        String unknown_number1 = variables[0].trim();
        String unknown_number2 = variables[1].trim();

        int number1 = number_determinant(unknown_number1);
        int number2 = number_determinant(unknown_number2);

        if (number1==0 && number2==0){
            int arab_number1 = Integer.parseInt(unknown_number1);
            int arab_number2 = Integer.parseInt(unknown_number2);

            if ((arab_number1 > 0 && arab_number1 < 11) && (arab_number2 > 0 && arab_number2 < 11)){
                result = calculation(arab_number1, arab_number2, operation);
                return arab_number1 + " " + operation + " " + arab_number2 + " = " + result;}
            else {return error;}}

        else if (number1>0 && number2>0){
            result = calculation(number1, number2, operation);
            if (Integer.parseInt(result) > 0){return unknown_number1 + " " + operation + " " + unknown_number2 + " = " + convert_to_romain(result);}
            else {return ("Результат вычеслений римских чисел не может быть меньше 1.");}}
        else {return  error;}
    }

    public static int number_determinant(String unknown_number){
        return switch (unknown_number.toUpperCase()) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> 0;};}

    public static String calculation(int number1, int number2, String operation){
    String result_calculation = "";
        switch (operation) {
            case "+" -> result_calculation = String.valueOf(number1 + number2);
            case "/" -> result_calculation = String.valueOf(number1 / number2);
            case "*" -> result_calculation = String.valueOf(number1 * number2);
            case "-" -> result_calculation = String.valueOf(number1 - number2);}
        return result_calculation;}

    public static String convert_to_romain(String result){
        String[] roman_number = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman_number[Integer.parseInt(result)];
    }
}

