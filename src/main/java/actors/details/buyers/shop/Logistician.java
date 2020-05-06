package actors.details.buyers.shop;

import actors.authorization.Modification;
import actors.authorization.Order;
import actors.authorization.See;
import actors.details.buyers.Shop;

public class Logistician extends Shop {
    public Logistician(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
