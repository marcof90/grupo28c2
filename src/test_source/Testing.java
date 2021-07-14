package test_source;

import model.Owner;

public class Testing {

    public Testing() {
        super();
    }

    public void escenarioOwner(){
        Owner owner1 = new Owner("Juan");
        Owner owner2 = new Owner("Pedro");

        boolean r1 = assertTrue("Juan", owner1.getNombre());        
        System.out.println("Prueba nombre " + ((r1)? "Paso": "No paso" ));
    }
    
    public boolean assertTrue(String expected, String received){
        if(expected.equalsIgnoreCase(received)){
            return true;
        }
        return false;
    }

    public boolean assertTrue(int expected, int received){
        if(expected == received){
            return true;
        }
        return false;
    }

    public boolean assertFalse(String expected, String received) {
        if(expected.equalsIgnoreCase(received)){
            return false;
        }
        return true;
    }


}
