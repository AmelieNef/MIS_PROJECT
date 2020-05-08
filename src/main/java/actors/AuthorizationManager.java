package actors;

import actors.authorization.action.IAction;
import actors.authorization.action.ReadAction;

import java.util.Set;

public class AuthorizationManager implements IAuthorizationManager {

    private Set<ActorType> lowSelectif = Set.of(ActorType.AssistantLogistician, ActorType.AssistantPharmacist,
            ActorType.HeadPharmacist, ActorType.Logistician, ActorType.Midwife, ActorType.Nurse);
    private Set<ActorType> highSelectif = Set.of(ActorType.AssistantLogistician, ActorType.AssistantPharmacist,
            ActorType.HeadPharmacist, ActorType.Logistician);
    private Actor user;

    public AuthorizationManager(Actor user) {
        this.user = user;
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
        //Vérifier que la personne à le droit à voire tels et tels db locale
        //if(readAction.getServiceId() == aActor.getServiceId()) {
            //return true;
        //}

        return false;
    }
}
