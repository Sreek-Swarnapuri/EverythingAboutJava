package projects.pluralsight.calengine;

public class Subracter extends CalculateBase {

    public Subracter(){}

    public Subracter(double leftVal, double rightVal){
        super(leftVal,rightVal);
    }

    @Override
    public void calculate(){
        setResult(super.getLeftVal()-super.getRightVal());
    }

}
