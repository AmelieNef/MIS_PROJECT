package actors.details.users;

import actors.details.User;
import actors.authorization.*;

public class Midwife extends User {
    public Midwife() {
        this.see = new AutorizedLocal();
        this.order = new IntermediateOrder();
        this.modification = new AutorizedModification();
    }

    public Midwife(See aSee, Order aOrder, Modification aModification) {
        super(aSee, aOrder, aModification);
    }
}
