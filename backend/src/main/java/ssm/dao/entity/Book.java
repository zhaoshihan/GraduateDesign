package ssm.dao.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Book {
    private long id;
    private String bookname;
    private String author;
    private String category;
    private String nation;
    private Date publishDate;
    private BigDecimal price;
    private String description;

    // 书籍的平均评分, 根据Comment表的多对一关系计算得到
    private double averageGrade;
    // 书籍参与评分的人数，根据Comment表计算得到
    private int commentNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", nation='" + nation + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
