package com.xwtech.demo.param;

import io.swagger.models.auth.In;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TestVo {
    @NotBlank(message = "信息不能为空")
    private String msg;
    @NotNull(message = "id不能为空")
    @Max(10)
    @Min(0)
    private Integer id;
}
