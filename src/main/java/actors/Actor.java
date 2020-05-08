package actors;
public class Actor {

    private ActorType actorType;
    private int serviceId;
    private int idActor;

    public Actor(ActorType actorType, int serviceId, int idPersonnel) {
        this.actorType = actorType;
        this.serviceId = serviceId;
        this.idActor = idPersonnel;
    }

    public int getServiceId() {
        return serviceId;
    }
    public int getIdActor(){return idActor;}

    public ActorType getActorType() {
        return actorType;
    }

}
