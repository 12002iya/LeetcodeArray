package railwayreservation;

import java.util.Scanner;

public class RailwayReservationSystem {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n========Railway Reservation System=========");

            System.out.println("1.Book ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Print Booked Tickets");
            System.out.println("4.Print Available Tickets");
            System.out.println("5.Exit");
            System.out.println("Enter your Choice");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1:
                    System.out.println("Enter your name :");
                    String name = sc.nextLine();

                    System.out.println("Enter your Age :");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Gender (MALE/FEMALE) :");
                    String gender = sc.nextLine();

                    System.out.println("Enter your Berth Preference (Lower/Middle/Upper) :");
                    String berthPreference = sc.nextLine();

                    Passenger passenger = new Passenger(name, age, gender, berthPreference);
                    TicketBooker.bookTicket(passenger);
                    break;

                case 2:
                    System.out.println("Enter passenger ID");
                    int passengerId = sc.nextInt();
                    TicketBooker.cancelTicket(passengerId);
                    break;

                case 3:
                    TicketBooker.printBookedTickets();
                    break;
                case 4:
                    TicketBooker.printAvailableTickets();
                    break;
                case 5:
                    System.out.println("Thank you for using Railway reservation System");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Choice ! Please Enter 1-5");
            }


        }


    }
}
