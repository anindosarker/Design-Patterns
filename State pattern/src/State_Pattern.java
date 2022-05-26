interface MobileAlertState{
    public void alert(AlertStateContext context);
}

class Vibration implements MobileAlertState{

    @Override
    public void alert(AlertStateContext context) {
        System.out.println("-----Vibration----");
    }
}

class Silent implements MobileAlertState{
    @Override
    public void alert(AlertStateContext context) {
        System.out.println("----Silent----");
    }
}

class AlertStateContext{
    private MobileAlertState currentState;

    public AlertStateContext() {
        this.currentState = new Silent();
    }

    public MobileAlertState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MobileAlertState currentState) {
        this.currentState = currentState;
    }

    public void alert(){
        this.currentState.alert(this);
    }
}

public class State_Pattern {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.setCurrentState(new Vibration());
        stateContext.alert();
        stateContext.setCurrentState(new Silent());
        stateContext.alert();

    }
}
