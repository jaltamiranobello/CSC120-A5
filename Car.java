import java.util.ArrayList;

public class Car {
    private int passengerCapacity;
    private ArrayList<Passenger> passengers;

    public Car(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
        this.passengers = new ArrayList<Passenger>(this.passengerCapacity);
    }

    public ArrayList<Passenger> getpassengers(){
        return this.passengers;
    }

    public int getpassengerCapacity(){
        return this.passengerCapacity;
    }

    public int seatsRemaining(){
        int total_passenger = passengers.size();
        int seats_remaining = this.passengerCapacity - total_passenger;
        return seats_remaining;
    }

    public void addPassenger(Passenger p){
        if (seatsRemaining() != 0){
            this.passengers.add(p);
        }

        else{
            throw new RuntimeException("Cannot add " + p.getname() + " because the train is full!");
        }
    }

    public void removePassenger(Passenger p){
        if (this.passengers.contains(p)){
            this.passengers.remove(p);
        }
        
        else{
            throw new RuntimeException((p.getname()) + " is not in the train.");
        }
    }

    public void printManifest(){
        if (this.passengers.isEmpty() == false){
            for (Passenger p: this.passengers) {
                System.out.println(p.getname());
            }
        }

        else{
            System.out.println("This car is empty!");
        }
    }
}