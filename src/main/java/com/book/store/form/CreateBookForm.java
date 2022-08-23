package com.book.store.form;
import javax.validation.constraints.NotEmpty;

public class CreateBookForm {

    @NotEmpty(message = "Field cannot be empty")
    private String bookName;

    @NotEmpty(message = "Field cannot be empty")
    private String author;

    @NotEmpty(message = "Field cannot be empty")
    private String quantity;

    @NotEmpty(message = "Field cannot be empty")
    private String price;

    @NotEmpty(message = "Field cannot be empty")
    private String category;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
