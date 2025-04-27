package javaconsoleapplicationjewelery;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseOperations {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase123";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456";

    private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    try {
        System.out.println("-------WELCOME TO MY Project-----");
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    insertDataMenu(connection);
                    break;
                case 2:
                    displayAllFoundObjects(connection);
                    break;
                case 3:
                    displayObjectsOlderThan(connection);
                    break;
                case 4:
                    displayNumberOfFoundObjects(connection);
                    break;
                case 5:
                    displayTableRecords(connection);
                    break;
                case 6:
                    displayTextFileData();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }

        connection.close(); // Close connection when done
        System.out.println("Exiting program.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


private static void displayMenu() {
    System.out.println("\nMenu:");
    System.out.println("1. Insert new data");
    System.out.println("2. Display all found objects");
    System.out.println("3. Display objects older than a given date");
    System.out.println("4. Display the number of found objects");
    System.out.println("5. Display records from a specific table");
    System.out.println("6. Display data from text file");
    System.out.println("7. Exit");
    System.out.print("Enter your choice: ");
}
private static void displayTextFileData() {
    try {
        // Assuming funn.txt is in the resources folder of the project
        Scanner fileScanner = new Scanner(DatabaseOperations.class.getResourceAsStream("/javaconsoleapplicationjewelery/funn.txt"));
        System.out.println("\nContents of funn.txt:");
        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }
        fileScanner.close();
    } catch (Exception e) {
        System.out.println("Error reading or displaying text file data: " + e.getMessage());
    }
}


    private static void insertDataMenu(Connection connection) throws SQLException {
        System.out.println("\nInsert Data Menu:");
        System.out.println("1. Insert new Person");
        System.out.println("2. Insert new Museum");
        System.out.println("3. Insert new Coin");
        System.out.println("4. Insert new Weapon");
        System.out.println("5. Insert new Jewelry");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                insertNewPerson(connection);
                break;
            case 2:
                insertNewMuseum(connection);
                break;
            case 3:
                insertNewCoin(connection);
                break;
            case 4:
                insertNewWeapon(connection);
                break;
            case 5:
                insertNewJewelry(connection);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void insertNewPerson(Connection connection) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO person (name, phone_number, email) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setString(3, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new person was inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting person: " + e.getMessage());
        }
    }

    private static void insertNewMuseum(Connection connection) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        String sql = "INSERT INTO museum (name, location) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, location);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new museum was inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting museum: " + e.getMessage());
        }
    }

    private static void insertNewCoin(Connection connection) throws SQLException {
        System.out.print("Enter latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Enter longitude: ");
        double longitude = scanner.nextDouble();
        System.out.print("Enter finder ID: ");
        int finderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter found date (yyyy-mm-dd): ");
        String foundDateStr = scanner.nextLine();
        Date foundDate = Date.valueOf(foundDateStr);
        System.out.print("Enter estimated year: ");
        int estimatedYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter museum ID (optional, enter 0 if none): ");
        int museumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter denomination: ");
        int denomination = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter material: ");
        String material = scanner.nextLine();

        String sql = "INSERT INTO found_object (latitude, longitude, finder_id, found_date, estimated_year, museum_id, type, denomination, material) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, latitude);
            statement.setDouble(2, longitude);
            statement.setInt(3, finderId);
            statement.setDate(4, foundDate);
            statement.setInt(5, estimatedYear);
            statement.setInt(6, museumId);
            statement.setString(7, type);
            statement.setInt(8, denomination);
            statement.setString(9, material);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new coin was inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting coin: " + e.getMessage());
        }
    }

    private static void insertNewWeapon(Connection connection) throws SQLException {
        System.out.print("Enter latitude: ");
        double latitude = scanner.nextDouble();
        System.out.print("Enter longitude: ");
        double longitude = scanner.nextDouble();
        System.out.print("Enter finder ID: ");
        int finderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter found date (yyyy-mm-dd): ");
        String foundDateStr = scanner.nextLine();
        Date foundDate = Date.valueOf(foundDateStr);
        System.out.print("Enter estimated year: ");
        int estimatedYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter museum ID (optional, enter 0 if none): ");
        int museumId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter material: ");
        String material = scanner.nextLine();
        System.out.print("Enter damage rating: ");
        int damageRating = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String sql = "INSERT INTO weapon (latitude, longitude, finder_id, found_date, estimated_year, museum_id, type, material, damage_rating) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, latitude);
            statement.setDouble(2, longitude);
            statement.setInt(3, finderId);
            statement.setDate(4, foundDate);
            statement.setInt(5, estimatedYear);
            statement.setInt(6, museumId);
            statement.setString(7, type);
            statement.setString(8, material);
            statement.setInt(9, damageRating);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new weapon was inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting weapon: " + e.getMessage());
        }
    }
private static void insertNewJewelry(Connection connection) throws SQLException {
    System.out.print("Enter latitude: ");
    double latitude = scanner.nextDouble();
    System.out.print("Enter longitude: ");
    double longitude = scanner.nextDouble();
    System.out.print("Enter finder ID: ");
    int finderId = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.print("Enter found date (yyyy-mm-dd): ");
    String foundDateStr = scanner.nextLine();
    Date foundDate = Date.valueOf(foundDateStr);
    System.out.print("Enter estimated year: ");
    int estimatedYear = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.print("Enter museum ID (optional, enter 0 if none): ");
    int museumId = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.print("Enter type: ");
    String type = scanner.nextLine();
    System.out.print("Enter value estimate: ");
    int valueEstimate = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.print("Enter material: ");
    String material = scanner.nextLine();
    System.out.print("Enter gemstone: ");
    String gemstone = scanner.nextLine();

    String sql = "INSERT INTO jewelry (latitude, longitude, finder_id, found_date, estimated_year, museum_id, type, value_estimate, material, gemstone) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setDouble(1, latitude);
        statement.setDouble(2, longitude);
        statement.setInt(3, finderId);
        statement.setDate(4, foundDate);
        statement.setInt(5, estimatedYear);
        statement.setInt(6, museumId);
        statement.setString(7, type);
        statement.setInt(8, valueEstimate);
        statement.setString(9, material);
        statement.setString(10, gemstone);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new jewelry item was inserted successfully.");
        }
    } catch (SQLException e) {
        System.out.println("Error inserting jewelry: " + e.getMessage());
    }
}

private static void displayTableRecords(Connection connection) {
    System.out.println("\nDisplay Records Menu:");
    System.out.println("1. Display records from Person table");
    System.out.println("2. Display records from Museum table");
    System.out.println("3. Display records from Coin table");
    System.out.println("4. Display records from Weapon table");
    System.out.println("5. Display records from Jewelry table");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    String tableName;
    switch (choice) {
        case 1:
            tableName = "person";
            break;
        case 2:
            tableName = "museum";
            break;
        case 3:
            tableName = "coin";
            break;
        case 4:
            tableName = "weapon";
            break;
        case 5:
            tableName = "jewelry";
            break;
        default:
            System.out.println("Invalid choice.");
            return;
    }

    String sql = "SELECT * FROM " + tableName;
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        ResultSet resultSet = statement.executeQuery();

        // Print column headers
        System.out.println("\nRecords from " + tableName + " table:");
        switch (tableName) {
            case "person":
                System.out.printf("%-5s %-20s %-15s %-30s\n", "ID", "Name", "Phone Number", "Email");
                break;
            case "museum":
                System.out.printf("%-5s %-30s %-30s\n", "ID", "Name", "Location");
                break;
            case "coin":
            case "weapon":
            case "jewelry":
                System.out.printf("%-5s %-10s %-10s %-10s %-15s %-15s %-10s %-10s %-15s %-15s\n", "ID", "Latitude", "Longitude", "Finder ID", "Found Date", "Estimated Year", "Museum ID", "Type", "Material", "Additional");
                break;
            default:
                System.out.println("Invalid table name.");
                return;
        }

        // Print records
        while (resultSet.next()) {
            switch (tableName) {
                case "person":
                    System.out.printf("%-5d %-20s %-15s %-30s\n",
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("email"));
                    break;
                case "museum":
                    System.out.printf("%-5d %-30s %-30s\n",
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("location"));
                    break;
                case "coin":
                case "weapon":
                case "jewelry":
                    System.out.printf("%-5d %-10.6f %-10.6f %-10d %-15s %-15d %-10d %-10s %-15s",
                            resultSet.getInt("id"),
                            resultSet.getDouble("latitude"),
                            resultSet.getDouble("longitude"),
                            resultSet.getInt("finder_id"),
                            resultSet.getDate("found_date"),
                            resultSet.getInt("estimated_year"),
                            resultSet.getInt("museum_id"),
                            resultSet.getString("type"),
                            resultSet.getString("material"));
                    if (tableName.equals("jewelry")) {
                        System.out.printf(" %-15s\n", resultSet.getString("gemstone"));
                    } else {
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Invalid table name.");
                    return;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving records: " + e.getMessage());
    }
}

// Add other methods for displaying found objects, number of found objects, etc.
// These methods would be similar to the displayTableRecords method, tailored for each query.



    private static void displayAllFoundObjects(Connection connection) {
        String sql = "SELECT * FROM found_object";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                int finderId = resultSet.getInt("finder_id");
                Date foundDate = resultSet.getDate("found_date");
                int estimatedYear = resultSet.getInt("estimated_year");
                int museumId = resultSet.getInt("museum_id");

                System.out.printf("ID: %d, Latitude: %.2f, Longitude: %.2f, Finder ID: %d, Found Date: %s, Estimated Year: %d, Museum ID: %d%n",
                        id, latitude, longitude, finderId, foundDate.toString(), estimatedYear, museumId);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying found objects: " + e.getMessage());
        }
    }

    private static void displayObjectsOlderThan(Connection connection) {
        System.out.print("Enter a date (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);

        String sql = "SELECT * FROM found_object WHERE found_date < ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                int finderId = resultSet.getInt("finder_id");
                Date foundDate = resultSet.getDate("found_date");
                int estimatedYear = resultSet.getInt("estimated_year");
                int museumId = resultSet.getInt("museum_id");

                System.out.printf("ID: %d, Latitude: %.2f, Longitude: %.2f, Finder ID: %d, Found Date: %s, Estimated Year: %d, Museum ID: %d%n",
                        id, latitude, longitude, finderId, foundDate.toString(), estimatedYear, museumId);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying objects older than the given date: " + e.getMessage());
        }
    }

    private static void displayNumberOfFoundObjects(Connection connection) {
        String sql = "SELECT COUNT(*) AS count FROM found_object";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                System.out.println("Number of found objects: " + count);
            }
        } catch (SQLException e) {
            System.out.println("Error displaying number of found objects: " + e.getMessage());
        }
    }


}

