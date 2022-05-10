package com.zyp.interview.vo;

//import com.alibaba.excel.annotation.ExcelProperty;
//import com.alibaba.excel.annotation.write.style.ColumnWidth;
//import com.alibaba.excel.annotation.write.style.ContentRowHeight;
//import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/10/13 14:48
 */
@Data
@NoArgsConstructor
public class ExportTemplateVO {

    @Excel(name = "姓名",width = 10)
    private String personalName;

    @Excel(name = "身份证号",width = 10,desensitizationRule = "3_4")
    private String personalIdCard;

    @Excel(name = "创建时间",width = 10,format = "yyyy-MM-dd")
    private Date createTime;
}
