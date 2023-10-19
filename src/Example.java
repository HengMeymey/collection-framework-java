import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Stock {
    private static int nextId = 1;
    private int id;
    private String name;
    private int quantity;
    private double price;
    private Date importedDate;

    public Stock(String name, int quantity, double price) {
        this.id = nextId++;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.importedDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImportedDate() {
        return importedDate;
    }
}

class StockManagement {
    private List<Stock> stocks;
    private int currentPage;
    private int rowsPerPage;

    public StockManagement() {
        stocks = new ArrayList<>();
        currentPage = 1;
        rowsPerPage = 5; // Default value
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void displayStocks() {
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, stocks.size());

        System.out.println("--- Stocks ---");
        for (int i = startIndex; i < endIndex; i++) {
            Stock stock = stocks.get(i);
            System.out.println("ID: " + stock.getId());
            System.out.println("Name: " + stock.getName());
            System.out.println("Quantity: " + stock.getQuantity());
            System.out.println("Price: " + stock.getPrice());
            System.out.println("Imported Date: " + stock.getImportedDate());
            System.out.println("------------------");
        }

        System.out.println("Page " + currentPage + " of " + getTotalPages());
    }

    public void writeStocks() {
        StringBuilder sb = new StringBuilder();

        for (Stock stock : stocks) {
            sb.append(stock.getId()).append(",").append(stock.getName()).append(",")
                    .append(stock.getQuantity()).append(",").append(stock.getPrice()).append(",")
                    .append(stock.getImportedDate()).append("\n");
        }

        String stockData = sb.toString();
        System.out.println(stockData);
        System.out.println("Stocks written.");
    }

    public void readStocks() {
        String stockData = "1,Stock1,10,100.0,2022-01-01\n" +
                "2,Stock2,20,200.0,2022-01-02\n" +
                "3,Stock3,30,300.0,2022-01-03\n";

        String[] lines = stockData.split("\n");

        for (String line : lines) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);
            String importedDate = parts[4];

            Stock stock = new Stock( name, quantity, price);
            stocks.add(stock);
        }

        System.out.println("Stocks read.");
    }

    public void updateStock(int id, int newQuantity, double newPrice) {
        for (Stock stock : stocks) {
            if (stock.getId() == id) {
                stock.setQuantity(newQuantity);
                stock.setPrice(newPrice);
                System.out.println("Stock updated successfully.");
                return;
            }
        }

        System.out.println("Stock not found.");
    }

    public void deleteStock(int id) {
        for (Stock stock : stocks) {
            if (stock.getId() == id) {
                stocks.remove(stock);
                System.out.println("Stock deleted successfully.");
                return;
            }
        }

        System.out.println("Stock not found.");
    }

    public void goToFirstPage() {
        currentPage = 1;
    }

    public void goToLastPage() {
        currentPage = getTotalPages();
    }

    public void goToNextPage() {
        if (currentPage < getTotalPages()) {
            currentPage++;
        }
    }

    public void goToPreviousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    private int getTotalPages() {
        return (int) Math.ceil((double) stocks.size() / rowsPerPage);
    }
}

public class Example {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockManagement stockManagement = new StockManagement();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Stock Management Menu ---");
            System.out.println("1. Add Stock");
            System.out.println("2. Display Stocks");
            System.out.println("3. Write Stocks to File");
            System.out.println("4. Read Stocks from File");
            System.out.println("5. Update Stock");
            System.out.println("6. Delete Stock");
            System.out.println("7. Go to First Page");
            System.out.println("8. Go to Last Page");
            System.out.println("9. Go to Next Page");
            System.out.println("10. Go to Previous Page");
            System.out.println("11. Set Rows per Page");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter stock name: ");
                    String name = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    Stock stock = new Stock(name, quantity, price);
                    stockManagement.addStock(stock);
                    break;
                case 2:
                    stockManagement.displayStocks();
                    break;
                case 3:
                    stockManagement.writeStocks();
                    break;
                case 4:
                    stockManagement.readStocks();
                    break;
                case 5:
                    System.out.print("Enter stock ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    stockManagement.updateStock(idToUpdate, newQuantity, newPrice);
                    break;
                case 6:
                    System.out.print("Enter stock ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    stockManagement.deleteStock(idToDelete);
                    break;
                case 7:
                    stockManagement.goToFirstPage();
                    break;
                case 8:
                    stockManagement.goToLastPage();
                    break;
                case 9:
                    stockManagement.goToNextPage();
                    break;
                case 10:
                    stockManagement.goToPreviousPage();
                    break;
                case 11:
                    System.out.print("Enter rows per page: ");
                    int rowsPerPage = scanner.nextInt();
                    stockManagement.setRowsPerPage(rowsPerPage);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Exiting Stock Management System.");
        scanner.close();
    }
}
