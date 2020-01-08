package projects.pluralsight.calengine;

public class Subtracter extends CalculateBase {

    public Subtracter(){}

    public Subtracter(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        setResult(super.getLeftVal()-super.getRightVal());
    }

}
