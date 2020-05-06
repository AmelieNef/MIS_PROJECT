package actors.details.buyers.pharmacy;

import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;
import actors.details.buyers.Pharmacy;

public class AssistantPharmacist extends Pharmacy {
    public AssistantPharmacist(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
