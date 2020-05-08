package actors.authorization.action;

public interface Action {
    void performAction();
    ActionType getType();
}
