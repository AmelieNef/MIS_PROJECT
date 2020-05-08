package actors;

import actors.authorization.action.Action;
import actors.authorization.action.ReadAction;

import java.util.Set;

public class AuthorizationManagerImpl implements AuthorizationManager {

    private Set<ActorType> lowSelectif = Set.of(ActorType.AssistantLogistician, ActorType.AssistantPharmacist,
            ActorType.HeadPharmacist, ActorType.Logistician, ActorType.Midwife, ActorType.Nurse);
    private Set<ActorType> highSelectif = Set.of(ActorType.AssistantLogistician, ActorType.AssistantPharmacist,
            ActorType.HeadPharmacist, ActorType.Logistician);
    private Actor user;

    public AuthorizationManagerImpl(Actor user) {
        this.user = user;
    }

    @Override
    public boolean isAuthorized(Action aAction) {
        switch (aAction.getType()) {
            case CreateOrder:
                return lowSelectif.contains(user.getActorType());
            case ReadAction:
                return validateReadAccess(aAction, user);
            case ApproveOrder:
                return highSelectif.contains(user.getActorType());
            case Update:
                return lowSelectif.contains(user.getActorType());
            case ShowStock:
                return lowSelectif.contains(user.getActorType());
        }

        return false;
    }

    private boolean validateReadAccess(Action aAction, Actor aActor) {
        ReadAction readAction = (ReadAction) aAction;
        if(readAction.isGlobal() && aActor.getActorType() == ActorType.Logistician) {
            return true;
        }

        if(readAction.getServiceId() == aActor.getServiceId()) {
            return true;
        }

        return false;
    }
}
