package actors.authorization.action;

public interface IAction {
    void performAction();
    ActionType getType();
}
