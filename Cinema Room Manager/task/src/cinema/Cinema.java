package cinema;

import java.util.Scanner;

public class Cinema {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean[][] bookedSeats;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int numberRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberSeatsByRow = scanner.nextInt();
        System.out.println();
        bookedSeats = new boolean[numberRows][numberSeatsByRow];

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    printCinema(numberRows, numberSeatsByRow);
                    break;
                case 2:
                    buyTicket(numberRows, numberSeatsByRow);
                    break;
                case 3:
                   showStatistics(numberRows, numberSeatsByRow);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Affiche la disposition actuelle des sièges dans le cinéma.
     * Les sièges réservés sont marqués par un "B", les sièges disponibles par un "S"
     * @param  rows Le nombre total de rangées dans le cinéma
     * @param seats Le nombre de sièges par rangée
     */
    public static void printCinema(int rows, int seats) {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            System.out.print(row + 1 + " ");
            for (int seat = 0; seat < seats; seat++) {
                System.out.print(bookedSeats[row][seat] ? "B " : "S ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Permet à l'utilisateur d'acheter un billet pour un siège spécifique
     * Si le siège est déjà réservé, l'utilisateur est invité à en choisir un autre
     * Affiche le prix du billet après sélection
     *
     * @param totalRows Le nombre total de rangées dans le cinéma
     * @param seatsPerRow Le nombre de sièges par rangée
     */
    public static void buyTicket(int totalRows, int seatsPerRow) {
        boolean isBooked;
        int numRow;
        int numSeat;
        do {
            System.out.println("Enter a row number:");
            numRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            numSeat = scanner.nextInt();

            if (numRow > totalRows || numSeat > seatsPerRow || numRow < 1 || numSeat < 1) {
                System.out.println("Wrong input!");
                isBooked = true;
            } else if (bookedSeats[numRow - 1][numSeat - 1]) {
                System.out.println("That ticket has already been purchased!");
                isBooked = true;
            } else {
                isBooked = false;
            }
        } while (isBooked);

            bookedSeats[numRow - 1][numSeat - 1] = true;
            int ticketPrice = calculateTicketPrice(totalRows, seatsPerRow, numRow);
            System.out.println("Ticket price: $" + ticketPrice);
            System.out.println();
    }


    /**
     * Calcule le prix du billet basé sur la position du siège
     * Tarif : 10$ pour la première moitié des rangées, 8£ pour la seconde moitié
     * Si le cinéma contient jusqu'à 60 sièges, tarif unique : 10£
     * @param totalRows Le nombre total de rangées
     * @param seatsPerRow Le nombre de sièges par rangée
     * @param selectedRow La rangée sélectionnée
     * @return Le prix du billet du siège sélectionné
     */
    public static int calculateTicketPrice(int totalRows, int seatsPerRow, int selectedRow) {
        int totalSeats = totalRows * seatsPerRow;
        if (totalSeats <= 60) {
            return 10;
        } else {
            int firstHalf = totalRows / 2;
            return selectedRow <= firstHalf ? 10 : 8;
        }
    }

    /**
     * Affiches les statistiques du cinéma (tickets , pourcentage d'occupation, revenu courant, et revenu total)
     * @param totalRows Le nombre total de rangées dans le cinéma
     * @param seatsPerRow Le nombre de sièges par rangée
     */
    public static void showStatistics(int totalRows, int seatsPerRow){
        int ticketsSold = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (bookedSeats[i][j]) {
                    ticketsSold++;
                    currentIncome += calculateTicketPrice(totalRows, seatsPerRow, i + 1);
                }
                totalIncome += calculateTicketPrice(totalRows, seatsPerRow, i + 1);
            }
        }

        System.out.println("Number of purchased tickets: " + ticketsSold);
        System.out.printf("Percentage: %.2f%%\n", 100.0 * ticketsSold / (totalRows * seatsPerRow));
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }
}
