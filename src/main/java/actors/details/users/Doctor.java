package actors.details.users;

import actors.details.User;
import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;

public class Doctor extends User {
    public Doctor(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
