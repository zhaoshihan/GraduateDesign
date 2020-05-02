package ssm.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @NotNull(message = "content属性不能为空")
    private String content;
    @NotNull(message = "grade属性不能为空")
    private byte grade;
    @NotNull(message = "bookID属性不能为空")
    private long bookID;
    @NotNull(message = "memberID属性不能为空")
    private long memberID;
}
