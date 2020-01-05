package projects.pluralsight.calengine;

public class Main {

    public static void main(String[] args){

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

//    public static MathEquation create(double leftVal, double rightVal, char opCode){
//        MathEquation  mathEquation = new MathEquation();
//
//        mathEquation.setLeftVal(leftVal);
//        mathEquation.setRightVal(rightVal);
//        mathEquation.setOpCode(opCode);
//
//        return mathEquation;
//    }

}
