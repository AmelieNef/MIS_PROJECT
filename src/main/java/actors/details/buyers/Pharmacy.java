package actors.details.buyers;

import actors.details.Buyer;
import actors.authorization.*;

public class Pharmacy extends Buyer {
    protected long idService;

    public Pharmacy(){
        this.see = new AutorizedGlobal();
        this.order = new FinalOrder();
    }

    public Pharmacy(See aSee, Order aOrder, Modification aModification){
        super(aSee,aOrder, aModification);
    }
}
