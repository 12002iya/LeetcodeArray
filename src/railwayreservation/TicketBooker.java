package railwayreservation;

import java.util.*;

public class TicketBooker {
    static int availableLower = 1;
    static int availableMiddle = 1;
    static int availableUpper = 1;

    static int availableRac = 1;
    static int availableWaitingList = 1;

    static Queue<Passenger> racList = new LinkedList<>();
    static Queue<Passenger> waitingList = new LinkedList<>();
    static Map<Integer, Passenger> confirmedList = new HashMap<>();


    public static void bookTicket(Passenger passenger) {

        if (passenger.age < 5) {
            passenger.setStatus("Berth-Not Allotted");
            confirmedList.put(passenger.passengerId, passenger);
            System.out.println("Child below 5 -no berth allocated");
            return;
        }
        if (availableMiddle > 0 || availableLower
                > 0 || availableUpper > 0) {

            if ((passenger.age > 60 || passenger.gender.equalsIgnoreCase("FEMALE"))
                    && availableLower > 0) {

                availableLower--;
                passenger.setAllottedPreference("Lower");
            } else if (passenger.berthPreference.equalsIgnoreCase("Lower") && availableLower > 0) {
                availableLower--;
                passenger.setAllottedPreference("Lower");
            } else if (passenger.berthPreference.equalsIgnoreCase("Middle") && availableMiddle > 0) {
                availableMiddle--;
                passenger.setAllottedPreference("Middle");
            } else if (passenger.berthPreference.equalsIgnoreCase("Upper") && availableUpper > 0) {
                availableUpper--;
                passenger.setAllottedPreference("Upper");
            } else if (availableLower > 0) {
                availableLower--;
                passenger.setAllottedPreference("Lower");
            } else if (availableMiddle > 0) {
                availableMiddle--;
                passenger.setAllottedPreference("Middle");
            } else {
                availableUpper--;
                passenger.setAllottedPreference("Upper");
            }
            passenger.setStatus("Confirmed");
            confirmedList.put(passenger.passengerId, passenger);
            System.out.println("Ticket Confirmed! ");

        } else if (availableRac > 0) {
            availableRac--;
            passenger.setStatus("RAC");
            passenger.setAllottedPreference("Side-Lower");
            racList.add(passenger);
            System.out.println("Ticket in RAC");
        } else if (availableWaitingList > 0) {
            availableWaitingList--;
            passenger.setStatus("Waiting_list");
            waitingList.add(passenger);
            System.out.println("Ticket in waiting List");
        } else {
            System.out.println("No tickets available");
        }
    }

    public static void cancelTicket(int passengerId) {


        Passenger passenger = confirmedList.get(passengerId);
        if (passenger != null) {

            confirmedList.remove(passengerId);


            if ("child not booked".equals(passenger.getAllottedPreference())) {
                System.out.println("child Ticket cancel");
                return;
            }
            String feedBerth = passenger.getAllottedPreference();
            if (!racList.isEmpty()) {

                Passenger racPassenger = racList.poll();

                if (racPassenger != null) {

                    racPassenger.setStatus("confirmed");
                    racPassenger.setAllottedPreference(feedBerth);
                    confirmedList.put(racPassenger.passengerId, racPassenger);
                    availableRac++;
                    System.out.println("Rac passenger move to confirmed");

                    Passenger waitingListPassenger = waitingList.poll();

                    if (waitingListPassenger != null) {
                        availableWaitingList++;
                        waitingListPassenger.setStatus("RAC");
                        waitingListPassenger.setAllottedPreference("side lower");
                        racList.offer(waitingListPassenger);
                        availableRac--;
                        System.out.println("waiting list moved to rac");
                    }
                }


            } else {
                if ("Lower".equals(feedBerth))
                    availableLower++;
                else if ("middle".equals(feedBerth))
                    availableMiddle++;
                else if ("upper".equals(feedBerth))
                    availableUpper++;
            }
            return;
        }
        Iterator<Passenger> passengerIterator = racList.iterator();

        while (passengerIterator.hasNext()) {

            Passenger passenger1 = passengerIterator.next();

            if (passenger1.passengerId == passengerId) {

                passengerIterator.remove();
                availableRac++;
                System.out.println("Rac ticket cancel");
                Passenger waitingListPassenger = waitingList.poll();
                if (waitingListPassenger != null) {

                    availableWaitingList++;

                    waitingListPassenger.setStatus("RAC");
                    waitingListPassenger.setAllottedPreference("side Lower");
                    racList.offer(waitingListPassenger);
                    availableRac--;
                    System.out.println("Waiting List Ticket Move to RAC");

                }
                return;
            }
        }
        Iterator<Passenger> waitingListPas = waitingList.iterator();
        while (waitingListPas.hasNext()) {

            Passenger waitPas = waitingListPas.next();

            if (waitPas.passengerId == passengerId) {

                waitingListPas.remove();
                availableWaitingList++;

                System.out.println("Waiting ticket cancelled");
                return;
            }
        }
        System.out.println("Passenger not found");

    }

    public static void printBookedTickets() {

        System.out.println("\n========== BOOKED TICKETS ==========");


        System.out.println("\n--- Confirmed Tickets ---");
        if (confirmedList.isEmpty()) {
            System.out.println("No Confirmed Tickets");
        } else {
            for (Passenger p : confirmedList.values()) {
                System.out.println(p);
            }
        }


        System.out.println("\n--- RAC Tickets ---");
        if (racList.isEmpty()) {
            System.out.println("No RAC Tickets");
        } else {
            for (Passenger p : racList) {
                System.out.println(p);
            }
        }

        System.out.println("\n--- Waiting List Tickets ---");
        if (waitingList.isEmpty()) {
            System.out.println("No Waiting List Tickets");
        } else {
            for (Passenger p : waitingList) {
                System.out.println(p);
            }
        }

        System.out.println("\n=====================================");
    }
    public static void printAvailableTickets() {

        System.out.println("------ Available Tickets ------");

        System.out.println("Available Lower Berth  : " + availableLower);
        System.out.println("Available Middle Berth : " + availableMiddle);
        System.out.println("Available Upper Berth  : " + availableUpper);
        System.out.println("Available RAC Tickets  : " + availableRac);
        System.out.println("Available Waiting List : " + availableWaitingList);

        System.out.println("--------------------------------");
    }


}





