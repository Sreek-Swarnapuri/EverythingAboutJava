package projects.pluralsight.calengine;

public class Divider extends  CalculateBase implements MathProcessing{

    public Divider(){}

    public Divider(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        setResult(super.getRightVal()!=0.0d?super.getLeftVal()/super.getRightVal():0.0d);
    }

    @Override
    public String getKeyword() {
        return "divide";
    }

    @Override
    public char getSymbol() {
        return '/';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();

        return getResult();
    }
}
