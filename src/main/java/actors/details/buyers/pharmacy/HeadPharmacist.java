package actors.details.buyers.pharmacy;

import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;
import actors.details.buyers.Pharmacy;

public class HeadPharmacist extends Pharmacy {
    public HeadPharmacist(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
