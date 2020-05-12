package actors;

import actors.authorization.action.IAction;
import actors.authorization.action.ReadAction;

import java.util.HashSet;
import java.util.Set;

public class AuthorizationManager implements IAuthorizationManager {


    private Actor user;
    private Set lowSelectif = new HashSet();
    private Set highSelectif = new HashSet();

    public AuthorizationManager(Actor user) {

        this.user = user;
        lowSelectif.add(ActorType.AssistantLogistician);
        lowSelectif.add(ActorType.AssistantPharmacist);
        lowSelectif.add(ActorType.HeadPharmacist);
        lowSelectif.add(ActorType.Logistician);
        lowSelectif.add(ActorType.Midwife);
        lowSelectif.add(ActorType.Nurse);

        highSelectif.add(ActorType.AssistantLogistician);
        highSelectif.add(ActorType.AssistantPharmacist);
        highSelectif.add(ActorType.HeadPharmacist);
        highSelectif.add(ActorType.Logistician);
    }

    @Override
    public boolean isAuthorized(IAction aIAction) {
        switch (aIAction.getType()) {
            case CreateOrder:
                return lowSelectif.contains(user.getActorType());
            case ReadAction:
                return validateReadAccess(aIAction, user);
            case ApproveOrder:
                return highSelectif.contains(user.getActorType());
            case Update:
                return lowSelectif.contains(user.getActorType());
            case ShowStock:
                return lowSelectif.contains(user.getActorType());
        }

        return false;
    }

    private boolean validateReadAccess(IAction aIAction, Actor aActor) {
        ReadAction readAction = (ReadAction) aIAction;
        if(readAction.isGlobal() && highSelectif.contains(aActor.getActorType())) {
            return true;
        }
        //V�rifier que la personne � le droit � voir tels et tels db locale
        //if(readAction.getServiceId() == aActor.getServiceId()) {
            //return true;
        //}

        return false;
    }
}
