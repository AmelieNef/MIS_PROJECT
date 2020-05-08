package actors;
import actors.authorization.action.Action;

public interface AuthorizationManager {
    boolean isAuthorized(Action aAction);
}
