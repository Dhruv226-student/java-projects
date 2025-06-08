package project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BookManagement {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choise;

        do {
            System.out.println("Book Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Update Book");
            System.out.println("6. Filter Books by Category");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choise = sc.nextInt();

            sc.nextLine(); // consume the leftover newline
            switch (choise) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    filterBooksByCategory();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choise != 7);

    }

    static void addBook() {
        System.out.print("Enter total number of Books you want to insert: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book details (id, title, author, category): ");
            // String line = sc.nextLine(); // read entire line

            // String[] parts = line.split(" "); // split by spaces
            // int id = Integer.parseInt(parts[0]);
            // String name = parts[1];
            // int age = Integer.parseInt(parts[2]);
            int id = sc.nextInt();
            String title = sc.next();
            String author = sc.next();
            String category = sc.next();
            books.add(new Book(id, title, author, category));
            System.out.println("Book " + (i + 1) + " added.");
        }
        viewBooks();
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books Found ");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    static void deleteBook() {
        if (books.isEmpty()) {
            System.out.println("No Books Found");
        } else {
            System.out.println("Enter book id to remove");
            int id = sc.nextInt();

            boolean removed = books.removeIf(b -> b.id == id);

            if (removed) {
                System.out.println("✅ Book deleted successfully.");
            } else {
                System.out.println("❌ Book with ID " + id + " not found.");
            }
            viewBooks();
        }
    }

    static void updateBook() {
        if (books.isEmpty()) {
            System.out.println("No Books Found");
        } else {
            System.out.println("Enter student id to update :");
            int id = sc.nextInt();

            for (Book b : books) {
                if (b.id == id) {
                    System.out.print("Enter new book title: ");
                    b.title = sc.next();

                    System.out.print("Enter new author: ");
                    b.author = sc.next();

                    System.out.print("Enter new category: ");
                    b.category = sc.next();

                    sc.nextLine();

                    System.out.println("✅ Student updated successfully.");
                    return;
                }
            }
            viewBooks();
        }
    }

    static void searchBook() {
        if (books.isEmpty()) {
            System.out.println("No Books Found");
        } else {

            System.out.println("Enter book author and title name :");
            String search = sc.nextLine().toLowerCase();

            boolean found = false;
            for (Book b : books) {
                if (b.title.toLowerCase().contains(search) || b.author.toLowerCase().contains(search)) {
                    System.out.println(b);
                    found = true;
                    if (!found)
                        System.out.println("❌ No books found matching your search.");
                }
            }
        }
    }

    static void filterBooksByCategory() {
        if (books.isEmpty()) {
            System.out.println("No Books Found");
        } else {

            // collect all unique category
            HashSet<String> categories = new HashSet<>();
            for (Book b : books) {
                categories.add(b.category);
            }

            // display all categories
            System.out.println("Available categories:");
            int i = 1;
            ArrayList<String> categoryList = new ArrayList<>(categories);
            for (String category : categoryList) {
                System.out.println(i + ". " + category);
                i++;
            }
            // Step 3: Ask user to select a category number
            System.out.print("Choose category number to filter books: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice < 1 || choice > categoryList.size()) {
                System.out.println("❌ Invalid choice.");
                return;
            }

            String selectedCategory = categoryList.get(choice - 1);

            // Step 4: Display books in that category
            System.out.println("\nBooks in category: " + selectedCategory);
            boolean found = false;
            for (Book b : books) {
                if (b.category.equalsIgnoreCase(selectedCategory)) {
                    System.out.println(b);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("❌ No books found in this category.");
            }

        }
    }

}
