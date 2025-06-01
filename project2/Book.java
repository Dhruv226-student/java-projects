package project2;

public class Book {
    int id;
    String title;
    String author;
    String category;


    Book(int id,String title,String author,String category){
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }
    
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Category: " + category;
    }
}
