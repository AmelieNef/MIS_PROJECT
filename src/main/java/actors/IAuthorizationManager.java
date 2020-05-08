package actors;
import actors.authorization.action.IAction;

public interface IAuthorizationManager {
    boolean isAuthorized(IAction aIAction);
}
