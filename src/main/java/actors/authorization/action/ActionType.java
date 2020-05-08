package actors.authorization.action;

public enum ActionType implements IAction {
    Update, ReadAction, CreateOrder, ApproveOrder, ShowStock;

    @Override
    public void performAction() {

    }

    @Override
    public ActionType getType() {
        return null;
    }
}
