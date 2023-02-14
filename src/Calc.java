import java.util.Scanner;

public class Calc {
    public static void main(String[] args) throws RuntimeException, NumberFormatException, Exception, ArrayIndexOutOfBoundsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арефметическую операцию типа: 1 + 2, II - III, IV (Цифра пробел знак пробел цифра) * V\nВы можете использовать либо арабские либо римские цифры от 1 до 10.");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception, ArrayIndexOutOfBoundsException {

        //Создание масивов для провверки ввода
        String[] action = new String[]{"-", "+", "*", "/"};
        String[] numbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] numbersRoma = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        //Разделение на элементы
        String[] divElement = input.split(" ");
        //Убираем случайные пробелы с начала и в конце
        input = input.trim();

        //Проверка ввода на кол. элементов
        if (divElement.length > 3) {
            try { throw new Exception("Можно ввести два операнда, не больше");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }

        //Проверка соответствия ввода
        boolean checkRoma = false;
        boolean checkRoma2 = false;
        boolean check = false;
        boolean check2 = false;


        //Проверка на Римские

        for (int i = 0; i <= 9; i++) {
            if (divElement[0].charAt(0) == numbersRoma[i].charAt(0)) {
                checkRoma = true;
            }
            if (divElement[2].charAt(0) == numbersRoma[i].charAt(0)) {
                checkRoma2 = true;
            }
        }

        //Проверка на арабские
        for (int q = 0; q <= 9; q++) {
            if (numbers[q] == divElement[0]); check = true;
            if (numbers[q] == divElement[2]); check2 = true;
        }


        //Если одна римская, а другая арабская выход из программы
        if (checkRoma != checkRoma2 || check != check2) {
            try {
                throw new Exception("Можно вводить только Римские или только арабские цифры");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        if (checkRoma == checkRoma2 == true) {//Если Римские, то перевод в арабские.
            switch (divElement[0]) {
                case "I":
                    divElement[0] = "1";
                    break;
                case "II":
                    divElement[0] = "2";
                    break;
                case "III":
                    divElement[0] = "3";
                    break;
                case "IV":
                    divElement[0] = "4";
                    break;
                case "V":
                    divElement[0] = "5";
                    break;
                case "VI":
                    divElement[0] = "6";
                    break;
                case "VII":
                    divElement[0] = "7";
                    break;
                case "VIII":
                    divElement[0] = "8";
                    break;
                case "IX":
                    divElement[0] = "9";
                    break;
                case "X":
                    divElement[0] = "10";
                    break;
            }
        }
        if (checkRoma == checkRoma2 == true) {//Если Римские, то перевод в арабские.
            switch (divElement[2]) {
                case "I":
                    divElement[2] = "1";
                    break;
                case "II":
                    divElement[2] = "2";
                    break;
                case "III":
                    divElement[2] = "3";
                    break;
                case "IV":
                    divElement[2] = "4";
                    break;
                case "V":
                    divElement[2] = "5";
                    break;
                case "VI":
                    divElement[2] = "6";
                    break;
                case "VII":
                    divElement[2] = "7";
                    break;
                case "VIII":
                    divElement[2] = "8";
                    break;
                case "IX":
                    divElement[2] = "9";
                    break;
                case "X":
                    divElement[2] = "10";
                    break;
            }
        }

        //Проверка ввода арабских
        if (check == check2 == true) {
            try {
                int num1 = Integer.parseInt(divElement[0]);
                int num2 = Integer.parseInt(divElement[2]);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод значений");
                System.exit(1);
            }
        }


        //Деление ввода на переменные
        int num1 = Integer.parseInt(divElement[0]);
        int num2 = Integer.parseInt(divElement[2]);


        int result = 0;


        switch (divElement[1]) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        //Проверка вывода римских цифр
        if (checkRoma == true && checkRoma2 == true) {
            boolean checking = (result <= 0);
            if (checking == true) {
                try {
                    throw new Exception("Ввывод не возможен. Нет римских цифр ниже I");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
            }
        }
        // Переведение Римского вывода в Римские цифры
        String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
                "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"};
        String resultRoma = new String();
        if (checkRoma == true && checkRoma2 == true) {
            resultRoma = String.valueOf(romanArray[result]);
        }

        if ((checkRoma == true) && (checkRoma2 == true)) {

            input = resultRoma;
        } else if ((check == true) && (check2 == true)) {
            input = String.valueOf(result);
        }



        return input;
    }
}



