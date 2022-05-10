//package com.zyp.interview.config.util;
//
////import com.alibaba.excel.EasyExcel;
////import com.alibaba.excel.write.metadata.style.WriteCellStyle;
////import com.alibaba.excel.write.metadata.style.WriteFont;
////import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.IndexedColors;
//
//import javax.servlet.http.HttpServletResponse;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author zyp
// * @Description TODO
// * @Date 2021/7/2 17:47
// */
//public class EasyExcelUtil<T> {
//
//    public void exportExcel(String sheetName, List<T> datas, HttpServletResponse response,Class<T> t) {
//
//        if (CollectionUtils.isEmpty(datas)) {
//            datas = new ArrayList<T>();
//        }
//        try {
//            String fileName = DateUtil.getYmdHmsV2(new Date()) + sheetName;
//
//            response.setContentType("application/vnd.ms-excel");
//            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
//
//            WriteCellStyle headWriteCellStyle = new WriteCellStyle();
//            /** 设置表头对齐方式 */
//            headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
//            /** 上边框 */
//            headWriteCellStyle.setBorderTop(BorderStyle.THIN);
//            /** 下边框 */
//            headWriteCellStyle.setBorderBottom(BorderStyle.THIN);
//            /** 左边框 */
//            headWriteCellStyle.setBorderLeft(BorderStyle.THIN);
//            /** 右边框 */
//            headWriteCellStyle.setBorderRight(BorderStyle.THIN);
//            /** 设置背景颜色 */
//            headWriteCellStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.getIndex());
//            WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//            /** 设置内容对齐方式 */
//            contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
//            /** 内容上边框 */
//            contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
//            /** 内容下边框 */
//            contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
//            /** 内容左边框 */
//            contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
//            /** 内容右边框 */
//            contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
//            /** 设置自动换行 */
//            contentWriteCellStyle.setWrapped(Boolean.TRUE);
//
//            WriteFont writeFont = new WriteFont();
//            /** 字体 */
//            writeFont.setFontName("宋体");
//            contentWriteCellStyle.setWriteFont(writeFont);
//            /** 单元格填充样式 */
//            contentWriteCellStyle.setFillPatternType(FillPatternType.NO_FILL);
//            /** 背景填充颜色 */
//            contentWriteCellStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.getIndex());
//
//            HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
//
//            EasyExcel.write(response.getOutputStream()).registerWriteHandler(horizontalCellStyleStrategy).head(t)
//                    .sheet(fileName).doWrite(datas);
//        } catch (Exception e) {
//        }
//
//    }
//}
