package projects.pluralsight.calengine;

public class Main {

    public static void main(String[] args){
//        useMathEquation();
//        useCalculatorBase();

        String[] statements ={
                "add 1.0",                  // Error: Incorrect number of values
                "add xx 25.0",              // Error: non numeric data
                "addX 0.0 0.0",             // Error: invalid command
                "divide 100.0 50.0",
                "add 1202.2121 1422.03",
                "subtract 1234.09 35.08",
                "multiply 122.54 45.23"
        };

        CalculateHelper calculateHelper = new CalculateHelper();

        for (String stmt:
             statements) {
            try {
                calculateHelper.process(stmt);
                System.out.println(calculateHelper);
            }catch (InvalidStatementException e){
                System.out.println("Error: " + e.getMessage());
                if(e.getCause() != null)
                    System.out.println("Error Cause: " + e.getCause().getMessage());
            }
        }



    }

//    public static MathEquation create(double leftVal, double rightVal, char opCode){
//        MathEquation  mathEquation = new MathEquation();
//
//        mathEquation.setLeftVal(leftVal);
//        mathEquation.setRightVal(rightVal);
//        mathEquation.setOpCode(opCode);
//
//        return mathEquation;
//    }

    static void useMathEquation() {

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d,50.0d,'d');
        equations[1] = new MathEquation(123.0d,513.5d,'a');
        equations[2] = new MathEquation(125.0d,50.5d,'s');
        equations[3] = new MathEquation(100.0d,50.0d,'m');

        for (MathEquation m:
                equations) {
            m.execute();
            System.out.println("result = " + m.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads:");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(9.0d,4.0d);

        System.out.println("result = " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;

        equationOverload.execute(leftInt,rightInt);

        System.out.println("result = " + equationOverload.getResult());

        //Since we are casting leftInt to double, system will only call the execute() which has doubles as parameters as its is the only feasible method
        equationOverload.execute(leftInt,rightInt);

        System.out.println("result = " + equationOverload.getResult());


    }

    static void useCalculatorBase(){
        System.out.println();
        System.out.println("Using Inheritance:");
        System.out.println();

        CalculateBase[] calculateBases = {
                new Divider(100.0d,20.0d),
                new Multiplier(209.9d,56.2d),
                new Adder(2435.2514d, 26541.365d),
                new Subtracter(125253.478845d, 26485.6985d)
        };

        for (CalculateBase calculateBase:
                calculateBases) {
            calculateBase.calculate();
            System.out.println("result = " + calculateBase.getResult());
        }

    }

}
