package lab07;



import java.util.*;

//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {


    /**
     * Converts an operator to its precedence priority
     *
     * We expect you to be able to handle +, -, *, /, ^, and (
     * (why don't you need ")" as well? see algorithm in part 4)
     *
     * The order of these is as follows:
     *    ^, * and /, + and -, (
     *
     * @param op a string representing an operator, e.g. "+" or "-"
     * @return an integer value reflecting its precedence
     */
    private static int opToPrcd(String op) {
        if (op.equals("^")){
            return 3;
        }
        if ( op.equals("*") || op.equals("/")) {
            return 2;
        }else if (op.equals("+") || op.equals("-")) {
            return 1;
        } else if(op.equals("(") || op.equals(")")) {
            return 0;
        }else {
            System.out.println("unknown/ wrong input, returning -1 for precedence");
            return -1;
        }
        //TODO: Lab Part 2.1



    }

    /**
     *  Determines if the first operator has same or greater
     *  precedence than the second
     *
     * @param op1 the first operator
     * @param op2 the second operator
     * @return the boolean result
     */
    private static boolean hasPrecedence(String op1, String op2) {
        //TODO: Lab Part 2.2
        int resOp1 = opToPrcd(op1);
        int resOp2 = opToPrcd(op2);

        if (resOp1 >= resOp2) {
            return true;
        }else {
            return false;
        }





    }

    /**
     * determines if the input token is an operator
     *
     * @param token the string token to check
     * @return a boolean reflecting the result
     */
    private static boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") ) {
            return true;
        }else {
            return false;
        }


        //TODO: Lab Part 2.3

    }

    /**
     * Evaluates an expression
     *
     * NOTE Beware the order of pop and evaluation when receiving operand1
     * and operand2 as input.
     *
     * @param operand1 the first operand
     * @param operator the operator to apply
     * @param operand2 the second operand
     * @return a double expressing the result
     * @throws IllegalArgumentException if operator passed is not one of
     *  "+", "-", "*", "/", or "^"
     *
     */
    private static double evaluate(double operand1, String operator, double operand2){
        //TODO: Lab Part 2.4
        if (operator.equals("*")) {
            return operand1 * operand2;
        }else if (operator.equals("/")) {
            return operand1 / operand2;
        }else if (operator.equals("+")) {
            return operand1 + operand2;
        }else if (operator.equals("-")) {
            return operand1 - operand2;
        }else if (operator.equals("^")) {
            return Math.pow(operand1, operand2);
        }
        System.out.println("Invalid operator!");
        throw new IllegalArgumentException();




    }


    /**
     * give a description of the purpose of this method
     * @param line fill in
     * @return fill in
     */
    public static double infixEvaluator(String line){

        StringSplitter data = new StringSplitter(line);


        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();

        while (data.hasNext()) {
            String current = data.peek();

            if(!isOperator(current) && !current.equals("(") && !current.equals(")")) {
                Double ourNum = Double.parseDouble(current);
                operands.push(ourNum);
                data.next();
            }

            if (current.equals("(")) {
                operators.push(current);
                data.next();
            }
            else if (current.equals(")")) {
                while(!operators.peek().equals("(")) {
                    String action = operators.pop();
                    double item1 = operands.pop();
                    double item2 = operands.pop();
                    double result = evaluate(item2, action, item1);
                    operands.push(result);
                }// end of while
                operators.pop();
                data.next();

            }// end of elif
            else if (isOperator(current)) {

                while (!operators.isEmpty() && opToPrcd(operators.peek()) >= opToPrcd(current)) {
                    String operator = operators.pop();
                    double item1 = operands.pop();
                    double item2 = operands.pop();

                    double result = evaluate(item2, operator, item1);
                    operands.push(result);


                }// end of while loop
                operators.push(current);
                data.next();

            }// end of elif




        }// end of while loop

        while(!operators.isEmpty()) {
            String op = operators.pop();
            double i1 = operands.pop();
            double i2 = operands.pop();
            double res = evaluate(i2, op, i1);
            operands.push(res);


        }// end of while loop


        //ATP thie operator stack MUST be empty and the operand stck must have ONE value








        //HINT: You must use the algorithm described in Lab Part 4
        return operands.pop(); // placeholder






    }

    /**
     * give a description of the purpose of this method
     * @param line fill in
     * @return fill in
     */
    public static String toPostfix(String line) {
        StringSplitter data = new StringSplitter(line);
        Stack<String> operators = new Stack<String>();
        String postfix = "";

        while (data.hasNext()) {
            String current = data.peek();
            // if we have a number
            if (!isOperator(current) && !current.equals("(") && !current.equals(")")) {
                postfix += current + " ";
                data.next();
            }
            else if (current.equals("(")) {
                operators.push(current);
                data.next();
            }
            else if (current.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    postfix += operators.pop() + " ";
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                }
                data.next();
            }
            // if we have an operator
            else if (isOperator(current)) {
                while (!operators.isEmpty() && !operators.peek().equals("(") &&
                        opToPrcd(operators.peek()) >= opToPrcd(current)) {
                    postfix += operators.pop() + " ";
                }
                operators.push(current);
                data.next();
            }
            else {
                data.next();
            }
        }

        while(!operators.isEmpty()) {
            postfix = postfix.concat(operators.pop().concat(" "));
        }

        String ans =  postfix.trim();
        return ans.replaceAll("\\s", "");
    }


    public static void main(String[] args){

        //Add Tests for Lab part 2
        //opToPrcd(String op) Tests
        //hasPrecedence(String op1, String op2) Tests
        //isOperator(String token) Tests
        //evaluate(double operand1, String operator, double operand2) Tests


        //Uncomment when you are ready to test Lab Part 3
        System.out.println(infixEvaluator("10 + 2"));
        if (infixEvaluator("10 + 2") != 12){
            System.out.println("test1 failed --> your answer should have been 12");
        }



        System.out.println(infixEvaluator("10 - 2 * 2 + 1"));
        if (infixEvaluator("10 - 2 * 2 + 1") != 7){
            System.out.println("test2 failed --> your answer should have been 7");

        }



        System.out.println(infixEvaluator("100 * 2 + 12"));
        if (infixEvaluator("100 * 2 + 12") != 212){
            System.out.println("test3 failed --> your answer should have been 212");

        }



        System.out.println(infixEvaluator("100 * ( 2 + 12 )"));
        if (infixEvaluator("100 * ( 2 + 12 )") != 1400){
            System.out.println("test4 failed --> your answer should have been 1400");
        }






        System.out.println(infixEvaluator("100 * ( 2 + 12 ) / 14"));
        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100){
            System.out.println("test5 failed --> your answer should have been 100");
        }

        if(infixEvaluator("( 6 + 2 ) * ( 3 + 1 ) / 2") != 16){
            System.out.println("u wrong!");
        }else{
            System.out.println("u good ");
        }

        System.out.println(infixEvaluator("10 + ( 3 * 2 ) - ( ( 8 / 4 ) + ( 2 ^ 3 ) )"));
        System.out.println("should be 6.0 ");



        System.out.println("Lab Testing Done!!!");

        /* uncomment the below lines for assignmemt */
        System.out.println(toPostfix(new String("(4+5)")));
		 if (!toPostfix(new String("(4+5)")).equals("45+"))
		     System.out.println("test1 failed --> should have been 45+");
        System.out.println(toPostfix(new String("((4+5)*6)")));
		 if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		     System.out.println("test2 failed --> should have been 45+6*");

		 if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		     System.out.println("test3 failed --> should have been 456*7/+8-");

		 if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		     System.out.println("test4 failed --> should have been 4567-*+8/");
        System.out.println(toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")));
		 if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		     System.out.println("test5 failed --> should have been 987*654^/3*-2*+");


        System.out.println(toPostfix(new String("A * B + C * D")));
        if (!toPostfix(new String("A * B + C * D")).equals("AB*CD*+")){
            System.out.println(" wrong");
        }


         System.out.println("Assignment Testing Done!!!");


    }

}
