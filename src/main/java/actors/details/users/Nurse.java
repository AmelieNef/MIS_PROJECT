package actors.details.users;

import actors.details.User;
import actors.authorization.*;

public class Nurse extends User {
    public Nurse() {
        this.see = new AutorizedLocal();
        this.order = new IntermediateOrder();
        this.modification = new AutorizedModification();
    }

    public Nurse(See aSee, Order aOrder, Modification aModification) {
        super(aSee, aOrder, aModification);
    }
}
