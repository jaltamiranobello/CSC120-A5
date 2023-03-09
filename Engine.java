public class Engine {

    private FuelType fuelType;
    private double current_fuel;
    private double fuelCapacity;

    public Engine(FuelType fuelType, double fuelCapacity){
        this.fuelType = fuelType;
        this.current_fuel = fuelCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public FuelType getfuelType(){
        return this.fuelType;
    }

    public double getcurrent_fuel(){
        return this.current_fuel;
    }

    public double getfuelCapacity(){
        return fuelCapacity;
    }
    
    public void refuel(){
        if (this.current_fuel < fuelCapacity){
            this.current_fuel = fuelCapacity;
            System.out.print("The current fuel level is: " + this.current_fuel);
        }
    }

    public void go(){
        if (this.current_fuel == 0){
            throw new RuntimeException("Out of fuel");
        }

        else{
            this.current_fuel -= 25.0;
        }
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
        myEngine.refuel();
    }

}