package actors.authorization.action;

public class CreateOrder implements IAction {
    //Champs n�cessaire pour la commande

    @Override
    public void performAction() {
        //connect to DB
    }

    @Override
    public ActionType getType() {
        return ActionType.CreateOrder;
    }
}