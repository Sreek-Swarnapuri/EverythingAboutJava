package projects.pluralsight.calengine;

public class CalculateHelper {

    private static final char ADD_SYMBOL='+';
    private static final char SUBTRACT_SYMBOL='-';
    private static final char MULTIPLY_SYMBOL='*';
    private static final char DIVIDE_SYMBOL='/';

    MathCommand command;
    double leftVal;
    double rightVal;
    double result;

    public void process(String statement){
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        String commandString = parts[0]; // add
        leftVal = Double.parseDouble(parts[1]); // 1.0
        rightVal = Double.parseDouble(parts[2]); // 2.0

        setCommandFromString(commandString);

        CalculateBase calculator = null;

        switch (command){
            case Add:
                calculator = new Adder(leftVal,rightVal);
                break;
            case Subtract:
                calculator = new Subtracter(leftVal,rightVal);
                break;
            case Multiply:
                calculator = new Multiplier(leftVal,rightVal);
                break;
            case Divide:
                calculator = new Divider(leftVal,rightVal);
                break;
        }

        calculator.calculate();

        result = calculator.getResult();
    }


    private void setCommandFromString(String commandString){
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString())){
            command = MathCommand.Add;
        }
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    @Override
    public String toString() {
        char symbol = ' ';

        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);

        sb.append(leftVal);

        sb.append(" " + symbol + " " + rightVal +" = " + result );

        return sb.toString();
    }
}
