package actors.authorization.action;

import java.util.ArrayList;
import java.util.List;

public class ReadAction<T> implements Action{
    //chercher des trucs dans la DB

    private final boolean global;
    private final int serviceId;
    private final List<T> results = new ArrayList<>();

    public ReadAction(boolean global, int serviceId) {
        this.global = global;
        this.serviceId = serviceId;
    }

    @Override
    public void performAction() {
        // ConnectToDb
        // Stocker les resultats dans une list result
    }

    public List<T> getResult(){
        return results;
    }

    @Override
    public ActionType getType() {
        return ActionType.ReadAction;
    }

    public boolean isGlobal() {
        return global;
    }

    public int getServiceId() {
        return serviceId;
    }
}
