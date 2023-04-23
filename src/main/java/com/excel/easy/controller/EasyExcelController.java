package com.excel.easy.controller;

import com.excel.easy.pojo.dto.CountersignDTO;
import com.excel.easy.pojo.dto.OnlineUpdateWorkRecordDto;
import com.excel.easy.service.ExcelService;
import com.excel.easy.util.Result;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/easy")
public class EasyExcelController {

    private final ExcelService schemeInfoService;

    public EasyExcelController(ExcelService schemeInfoService) {
        this.schemeInfoService = schemeInfoService;
    }

    //多数组导出
    @PostMapping("/excel")
    public Result excel(@RequestBody CountersignDTO dto,
                        @RequestHeader("userId") String userId) {
        return schemeInfoService.countersign(dto, userId);
    }

    //包含合并列后导出图片
    @PostMapping("/excelImg")
    public void excelImg(@RequestBody OnlineUpdateWorkRecordDto dto) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().
                getResourceAsStream("template/施工日志模板.xlsx");
        schemeInfoService.excelImg(resourceAsStream,dto);
    }

}
