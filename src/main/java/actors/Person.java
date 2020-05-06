package actors;

import actors.authorization.*;

public class Person {

    protected See see = new UnautorizedSee();
    protected Order order = new UnautorizedOrder();
    protected Modification modification = new UnautorizedModification();

    public Person(See aSee, Order aOrder, Modification aModification){
        this.see = aSee;
        this.order = aOrder;
        this.modification = aModification;
    }

    public Person() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order aOrder) {
        this.order = aOrder;
    }

    public See getSee(){
        return see;
    }

    public void setSee(See aSee){
        this.see = aSee;
    }

    public Modification getModification(){
        return modification;
    }

    public void setModification(Modification aModification){
        this.modification = aModification;
    }

    public String toString() {
        return "actors.Person{" +
                "order=" + order +
                ", see=" + see +
                ", modification=" + modification +
                '}';
    }

    public void accessed(){
        see.observeDB();
    }
    public void ordered(){
        order.orderProduct();
        order.finalizeOrder();
    }
    public void modificated(){
        modification.modificationDB();
    }

}
