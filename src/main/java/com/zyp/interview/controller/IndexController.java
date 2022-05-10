package com.zyp.interview.controller;

//import com.zyp.interview.config.util.EasyExcelUtil;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.alibaba.fastjson.JSON;
import com.zyp.interview.config.annotion.RsaVerify;
import com.zyp.interview.demo.design_pattern.responsibility_chain.ChainPatternDemo;
import com.zyp.interview.demo.design_pattern.strategy.FileStrategy;
import com.zyp.interview.demo.design_pattern.strategy.FileTypeResolveEnum;
import com.zyp.interview.demo.design_pattern.strategy.StrategyUseService;
import com.zyp.interview.mapper.LoginMapper;
import com.zyp.interview.service.LoginService;
import com.zyp.interview.util.LocalJsonUtil;
import com.zyp.interview.vo.ExportTemplateVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
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

    @Autowired
    @Qualifier(value = "chainPatternDemo")
    private ChainPatternDemo chainPatternDemo;

    @Autowired
    private StrategyUseService strategyUseService;


    @GetMapping(value = "test")
    @ApiOperation(value = "测试")
    public void test( ModelMap map,
                     HttpServletRequest request,
                     HttpServletResponse response) {
        strategyUseService.resolveFile(FileTypeResolveEnum.File_A_RESOLVE,null);
    }

    @ApiOperation(value = "测试导入")
    @RequestMapping(value = "testImport", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    @ApiImplicitParam(name = "file", required = true, dataType = "MultipartFile", allowMultiple = true)
    public void testImport(@RequestParam(value = "file") MultipartFile file) throws Exception {
        final ImportParams params = new ImportParams();
        final List<ExportTemplateVO> lists = ExcelImportUtil.importExcel(file.getInputStream(), ExportTemplateVO.class, params);
        log.info("#IndexController.testImport 返回数据:{}", JSON.toJSONString(lists));

    }
}
