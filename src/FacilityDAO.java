import java.util.ArrayList;
/**
 * The FacilityDAO is in charge of the Facility objects in the system.
 */
public class FacilityDAO{

    private ArrayList<Facility> facilityList;

    /**
     * Constructs a FacilityDAO with the initial list
     * of Facility (refer to project writeup)
     */
    public FacilityDAO(){
        // TODO

        facilityList = new ArrayList<Facility>();
//        Facility f = new Facility("F001","Room2-1",4);
//        facilityList.add(f);
        facilityList.add(new Facility("F001","Room2-1",4));
        facilityList.add(new Facility("F002","Room2-2",6));
        facilityList.add(new Facility("F003","Room2-3",8));
        facilityList.add(new Facility("F004","Room2-4",10));
        facilityList.add(new Facility("F005","Room2-5",12));
        facilityList.add(new Facility("F006","Room2-6",14));
        facilityList.add(new Facility("F007","Room2-7",16));

        // initialize the sample data
    }

    /**
     * Retrieves all the Facility objects currently available in the System.
     * This should only be used for the "List all facility" functionality.
     * @return list of all Facility objects
     */
    public ArrayList<Facility> retrieveAll() {
        if (facilityList.size() == 0){
            return null;
        }
        else{
            return facilityList;
        }

    }

    /**
     * Retrieves a facility with the specified facilityID

     * @return the Facility object, returns null if the facility does not exist.
     */
    public Facility retrieve(String facilityID) {
        for (int i = 0; i < facilityList.size(); i ++){
            Facility checker = facilityList.get(i);
            String checkerID = checker.getId();
            if (checkerID.equals(facilityID)){
                return checker;
            }
        }
        return null;
    }

}
