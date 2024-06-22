import java.util.Scanner;

public class CinemaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema("UTP A Cinema", 10);

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Pick your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    User user = cinema.authenticateUser(email, password);

                    if (user != null) {
                        System.out.println("Login Success");
                        dashboard(cinema, user, scanner);
                    } else {
                        System.out.println("Login failed");
                    }
                    break;
                case 2:
                    System.out.print("Fullname: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Password: ");
                    String newPassword = scanner.nextLine();

                    User newUser = new User(newEmail, newPassword, fullName, 10000);
                    if (cinema.registerUser(newUser)) {
                        System.out.println("Successfully registered User!");
                    } else {
                        System.out.println("Registration failed");
                    }
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void dashboard(Cinema cinema, User user, Scanner scanner) {
        while (true) {
            System.out.println("Welcome " + user.getFullName() + " to " + cinema.getName() + "!");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Tampilkan Tiket milik Saya");
            System.out.println("3. Lihat Studio yang Ada");
            System.out.println("4. Lihat Detail Studio");
            System.out.println("5. Top Up Saldo");
            System.out.println("6. Exit Program");
            System.out.print("Pick your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    cinema.displayListStudio();
                    System.out.print("Pilih Studio: ");
                    int studioNumber = scanner.nextInt();
                    scanner.nextLine();
                    cinema.displayStudioDetail(studioNumber);

                    System.out.print("Masukkan baris: ");
                    char row = scanner.nextLine().toUpperCase().charAt(0);
                    System.out.print("Masukkan kolom: ");
                    int col = scanner.nextInt();
                    scanner.nextLine();

                    if (cinema.bookTicket(user, studioNumber, row, col)) {
                        System.out.println("Berhasil memesan tiket");
                        System.out.println("Saldo anda sekarang: Rp. " + user.getBalance());
                    } else {
                        System.out.println("Gagal memesan tiket");
                    }
                    break;
                case 2:
                    user.displayAllTickets();
                    break;
                case 3:
                    cinema.displayListStudio();
                    break;
                case 4:
                    System.out.print("Pilih Studio: ");
                   int studioNum = scanner.nextInt();
                    scanner.nextLine();
                    cinema.displayStudioDetail(studioNum);
                    break;
                case 5:
                    System.out.print("Masukkan saldo yang ingin ditopup: ");
                    double topUpAmount = scanner.nextDouble();
                    scanner.nextLine();
                    user.setBalance(user.getBalance() + topUpAmount);
                    System.out.println("Top Up berhasil");
                    System.out.println("Saldo anda sekarang Rp. " + user.getBalance());
                    break;
                case 6:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}