package actors.details;

import actors.Person;
import actors.authorization.AutorizedModification;
import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;

public class Buyer extends Person {
    public Buyer(){
        this.modification = new AutorizedModification();
    }

    public Buyer(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
