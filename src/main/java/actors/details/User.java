package actors.details;

import actors.Person;
import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;

public class User extends Person {
    protected long idService;

    public User(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }

    public User() {
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long aIdService) {
        this.idService = aIdService;
    }
}
