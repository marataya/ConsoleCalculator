class Validate {
  // BAJINDATOP
  private static boolean isRoman(String inputStr){
    return inputStr.matches("^I$|^II$|^III$|^IV$|^V$|^VI$|^VII$|^VIII$|^IX$|^X$");
  }

  private static boolean isStringInt(String s)
  {
    try
    {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException ex)
    {
      return false;
    }
  }
  
  public static String validateInput(String input1, String input2, String operator) {
    String result = "";
    
    if (!operator.matches("[-+*/]{1}")){
      throw new RuntimeException("Operators not in set of [+,-,*,/]");
    }
    
    if (isRoman(input1) ^ isRoman(input2)){
      throw new RuntimeException("Different numeric systems");
    }
    if (!isRoman(input1) && !isRoman(input2) && (!isStringInt(input1) || !isStringInt(input1))) {
      throw new RuntimeException("Roman numerals out of bounds or numbers are not of type int");
    }

    int op1 = 0;
    int op2 = 0;

    if(isRoman(input1)) {
      RomanConversionUtils romanOp = new RomanConversionUtils();
      op1 = romanOp.romanToInt(input1);
      op2 = romanOp.romanToInt(input2);
    }
    else {
      op1 = Integer.parseInt(String.valueOf(input1));
      op2 = Integer.parseInt(String.valueOf(input2));
    }

    if (((op1 < 1) || (op1 > 10)) || ((op2 < 1) || (op2 > 10))) {
      throw new RuntimeException("Numbers are out bounds");
    }

    if (isRoman(input1)) {
      result = "roman";
    }
    else {
      result = "decimal";
    }
    
    return result;
  }
}