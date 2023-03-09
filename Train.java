import java.util.ArrayList;
public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;


    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.cars = new ArrayList<Car>(nCars);
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity));
        }
        this.engine = new Engine(fuelType, fuelCapacity);
        
    }

    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i){
        return this.cars.get(i-1);
    }

    public int getMaxCapacity(){
        int passengerCapacity = 0; 
        for (Car c: cars){
            passengerCapacity += c.getpassengerCapacity();
        }
        return passengerCapacity;
    }

    public int seatsRemaining(){
        int total_seats_remaining = 0;
        for (Car c: cars){
            total_seats_remaining += c.seatsRemaining();
        }
        return total_seats_remaining;
    }

    public void printManifest(){
        for (Car c: cars){
            c.printManifest();
        }
    }

    public static void main(String[] args) {
        Train my_train = new Train(FuelType.ELECTRIC, 100.0, 3, 4);
        Engine my_engine = my_train.getEngine();
        Passenger p1 = new Passenger("Julie");
        Passenger p2 = new Passenger("Kim");
        Passenger p3 = new Passenger("Taylor");
        Car car1 = my_train.getCar(1);
        Car car2 = my_train.getCar(2);
        Car car3 = my_train.getCar(3);
        p1.boardCar(car1);
        p2.boardCar(car1);
        p3.boardCar(car1);
        System.out.println("Passengers in Car One:");
        car1.printManifest();
        System.out.print("\n");
        System.out.println("Passengers in Car Two:");
        car2.printManifest();
        System.out.print("\n");
        System.out.println("Passengers in Car Three:");
        car3.printManifest();
        System.out.print("\n");
        System.out.println("Seats remaining in Car One: " + car1.seatsRemaining());
        System.out.println("Seats remaining in Car Two: " + car2.seatsRemaining());
        System.out.println("Seats remaining in Car Three: " + car3.seatsRemaining());
        System.out.print("\n");
        my_engine.go();
        car1.removePassenger(p3);
        System.out.println(p3.getname() + " has left the train.\n");
        System.out.println("Updated roster for Car 1:");
        car1.printManifest();
        System.out.print("\n");
        my_engine.refuel();
    }
}
