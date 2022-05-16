package com.zyp.interview.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.zyp.interview.vo.ExportTemplateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/13 14:49
 */
@Api(tags = "测试EasyExcel")
@RequestMapping("testEasyExcel")
@RestController
@Slf4j
public class IndexController {

    @ApiOperation(value = "测试导入")
    @RequestMapping(value = "testImport", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    @ApiImplicitParam(name = "file", required = true, dataType = "MultipartFile", allowMultiple = true)
    public void testImport(@RequestParam(value = "file") MultipartFile file) throws Exception {
        final ImportParams params = new ImportParams();
        final List<ExportTemplateVO> lists = ExcelImportUtil.importExcel(file.getInputStream(), ExportTemplateVO.class, params);
        log.info("#IndexController.testImport 返回数据:{}", JSON.toJSONString(lists));

    }
}
