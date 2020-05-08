package actors;

import java.time.LocalDateTime;

public enum ActorType {
    Caregiver(1), Doctor(2), Midwife(3), Nurse(4), AssistantPharmacist(5), HeadPharmacist(6), AssistantLogistician(7), Logistician(8);

    private int id;

    ActorType(int id) {
        id = id;
    }

    public int getId() {
        return id;
    }

    public static ActorType from( int id ) {
        switch (id){
            case 1:
                return Caregiver;
            case 2:
                return Doctor;
            case 3:
                return Midwife;
            case 4:
                return Nurse;
            case 5:
                return AssistantPharmacist;
            case 6:
                return HeadPharmacist;
            case 7 :
                return AssistantPharmacist;
            case 8 :
                return Logistician;
            default:
                throw new IllegalArgumentException("Unknown actor id: " + id);
        }
    }
}
