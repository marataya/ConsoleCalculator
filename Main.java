import java.util.Scanner;

public class Main {
  public static String calc(String input) {
    System.out.println("=");

    String result = "";

    String[] args = input.split(" ");

    String op1 = args[0];
    String operator = args[1];
    String op2 = args[2];
    int tempResult = 0;
    int op1Int = 0;
    int op2Int = 0;

    if (Validate.validateInput(op1, op2, operator) == "roman") {
      op1Int = RomanConversionUtils.romanToInt(op1);
      op2Int = RomanConversionUtils.romanToInt(op2);
      tempResult = makeTheCalculation(operator, op1Int, op2Int);
      result = RomanConversionUtils.IntegerToRomanNumeral(tempResult);
    }
    else {
      op1Int = Integer.valueOf(op1);
      op2Int = Integer.valueOf(op2);
      tempResult = makeTheCalculation(operator, op1Int, op2Int);
      result = Integer.toString(tempResult);
    }
    return result;
  }

  private static int makeTheCalculation(String operator, int op1Int, int op2Int) {
    int temp = 0;
    switch (operator) {
      case "+": temp = op1Int + op2Int;
        break;
      case "-": temp = op1Int - op2Int;
        break;
      case "/": temp = op1Int / op2Int;
        break;
      case "*": temp = op1Int * op2Int;
        break;
    }
    return temp;
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Enter operand1, operator and operand2 separated by space in one line:");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println(calc(input));
    scanner.close();

  }
}