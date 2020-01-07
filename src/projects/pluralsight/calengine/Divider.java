package projects.pluralsight.calengine;

public class Divider extends  CalculateBase{

    public Divider(){}

    public Divider(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        setResult(super.getRightVal()!=0.0d?super.getLeftVal()/super.getRightVal():0.0d);
    }
}
