package actors;
public class Actor {

    private ActorType actorType;
    private int serviceId;

    public Actor(ActorType actorType, int serviceId) {
        this.actorType = actorType;
        this.serviceId = serviceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public ActorType getActorType() {
        return actorType;
    }

}
