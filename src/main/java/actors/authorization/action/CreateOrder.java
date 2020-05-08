package actors.authorization.action;

public class CreateOrder implements Action{
    //Champs nécessaire pour la commande

    @Override
    public void performAction() {
        //connect to DB
    }

    @Override
    public ActionType getType() {
        return ActionType.CreateOrder;
    }
}
