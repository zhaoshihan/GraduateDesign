package ssm.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
