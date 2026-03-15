package railwayreservation;

public class Passenger {
    static int idCounter=1;
    int passengerId;
    String name;
    int age;
    String gender;
    String berthPreference;


    String allottedPreference;
    String status;
    public Passenger(String name, int age, String gender, String berthPreference) {
        this.passengerId=idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Passenger.idCounter = idCounter;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public String getAllottedPreference() {
        return allottedPreference;
    }

    public void setAllottedPreference(String allottedPreference) {
        this.allottedPreference = allottedPreference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ID: " + passengerId +
                ", Name: " + name +
                ", Age: " + age +
                ", Gender: " + gender +
                ", Status: " + status +
                ", Berth: " + allottedPreference;
    }
}
