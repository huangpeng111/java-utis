package com.cy.excel;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cy.pojo.Item;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;

@Controller
@RequestMapping("/excel/")
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	@RequestMapping("/index")
	public String doPage() {
		return "excel";
	}
	@RequestMapping("/importExcel")
	@ResponseBody
	public String doExcel(MultipartFile file) {
		if(file==null) {
			return "文件不能为空!";
		}
		System.out.println("文件大小::"+file.getSize());
		String filename = file.getOriginalFilename();
		System.out.println("filename:::"+filename);
		String filePattern = filename.substring(filename.lastIndexOf(".")+1);
		System.out.println("filepattern:::"+filePattern);
		if(!Objects.equals("xls", filePattern)) {
			return "文件格式不正确,只能为.xls!";
		}
		List<Item> list = null;
		ImportParams params = new ImportParams();
		params.setTitleRows(1);
		params.setHeadRows(1);
		params.setStartSheetIndex(0);
		try {
			list = ExcelImportUtil.importExcel(file.getInputStream(), Item.class, params);
			System.out.println(list.size());
			System.out.println(list.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("文件导入异常!");
		}
		return "导入成功";
	}
	
	@ResponseBody
	@RequestMapping("/exportExcel")
	public void exportExcel(HttpServletResponse response) {
		List<Item> list = excelService.findAll();
		System.err.println("excel开始导出!");
		try {
			String fileName = new String("商品信息表.xls".getBytes("utf-8"), "ISO-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            //导出
            Workbook book = ExcelExportUtil.exportExcel(new ExportParams("商品表","京淘"), Item.class, list);
            book.write(response.getOutputStream());
            System.err.println("excel导出完毕!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("excel导出失败!");
		}
	}

}
