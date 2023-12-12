package calculators;

class Main {
    static String calc(String input) {
        String[] parts = input.split("\\s");

        try {
            int num1 = parseNumber(parts[0]);
            int num2 = parseNumber(parts[2]);

            validateNumbers(num1, num2);

            String result;
            switch (parts[1]) {
                case "+":
                    result = toOutputFormat(num1 + num2);
                    break;
                case "-":
                    result = toOutputFormat(num1 - num2);
                    break;
                case "*":
                    result = toOutputFormat(num1 * num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на 0");
                    }
                    result = toOutputFormat(num1 / num2);
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка");
            }

            return result;
        } catch (Exception e) {
            return "Ошибка: " + e.getMessage();
        }
    }

    static int parseNumber(String input) {
        if (input.matches("\\d+")) {
            int num = Integer.parseInt(input);
            if (num < 1 || num > 10) {
                throw new IllegalArgumentException("Числа должны быть только от 1 до 10 включительно");
            }
            return num;
        } else {
            throw new IllegalArgumentException("Неверный формат");
        }
    }

    static void validateNumbers(int num1, int num2) {
        if ((num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10)
                || (num1 < 1 && num2 < 1)) {
            // Valid numbers
        } else {
            throw new IllegalArgumentException("Числа должны быть только от 1 до 10 включительно");
        }
    }

    static String toOutputFormat(int result) {
        if (result < 1) {
            throw new IllegalArgumentException("Ошибка");
        }
        return Integer.toString(result);
    }
}

class CalculatorApp {
    public static void main(String[] args) {
        try {
            // Example usage:
            String result = Main.calc("5 / 0");
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}


