package actors.details.buyers;

import actors.details.Buyer;
import actors.authorization.*;

public class Shop extends Buyer {
    protected long idService;

    public Shop(){
        this.see = new AutorizedGlobal();
        this.order = new FinalOrder();
    }

    public Shop(See aSee, Order aOrder, Modification aModification){
        super(aSee, aOrder, aModification);
    }
}
