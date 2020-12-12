package com.boot.bootlanuch.model.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksInfo {
    @Min(2)
    @NotNull(message = "id不能为空")
    private Integer id;
    private String auto;
    private String money;
    @DateTimeFormat(pattern="YYYY-MM-DD")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;
    private String remark;
    private ReadInfo read;

}

