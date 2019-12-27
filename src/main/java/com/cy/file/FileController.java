package com.cy.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class FileController {
	
	@RequestMapping("/login")
	public String loginPage() {
		return "File";
	}
	
	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public String file(String username,String password,MultipartFile file) {
		
		System.out.println(username+"----"+password+"-----");
		if(!file.isEmpty()) {
		String filename = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String dirpath = "E:/test/"+sdf.format(new Date());
		System.err.println(dirpath+"**********");
		File dir = new File(dirpath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		try {
			file.transferTo(new File(dirpath+"/"+filename));
			//return "文件上传成功";
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "文件上传成功";
		}else
		return "文件不能为空";
	}
//	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
//	@ResponseBody
//	public String file(HttpServletRequest request) {
//		//只能得到文件名
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String file = request.getParameter("file");
//		System.out.println(username+"----"+password+"-----"+file);
//		return "dddd";
//	}
	
//	@RequestMapping(value="/doLogin",method = RequestMethod.POST)
//	@ResponseBody
//	public String file(HttpServletRequest request) {
//		//通过apache的commons-fileupload
//		//1.判断该类型是否支持文件上传  enctype=multipart/form-data
//		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
//		if(!multipartContent) {
//			return "该类型不支持文件上传";
//		}
//		//2.创建一个DiskFileItemFactory对象
//		DiskFileItemFactory fac = new DiskFileItemFactory();
//		//3.创建一个servletFileUpload对象,文件上传的核心
//		ServletFileUpload file = new ServletFileUpload(fac);
//		//4.解析表单对象
//		try {
//			List<FileItem> items = file.parseRequest(request);
//			System.err.println("执行??"+items);
//			int i =0;
//			//5.遍历集合 判断每一项
//			for (FileItem fileItem : items) {
//				System.err.println(i++);
//				if(fileItem.isFormField()) {
//					//普通表单项
//					try {
//						String name = fileItem.getName();
//						String value = fileItem.getString("utf-8");
//						System.err.println(name+"="+value);
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}else {
//					//文件
//					//获得文文件名
//					String fileName = fileItem.getName();
//					//获得输入流
//					try {
//						InputStream input = fileItem.getInputStream();
//						//创建输出流
//						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//						String path = "E:/test/"+sdf.format(new Date());
//						System.err.println(path+"**********");
//						File file2 = new File(path,fileName);
//						if(!file2.exists()) {
//							file2.mkdirs();
//						}
//						FileOutputStream os = new FileOutputStream(file2);
//						byte[] bytes = new byte[1024];
//						int len = -1;
//						while((len=input.read(bytes))!=-1) {
//							os.write(bytes, 0, len);
//						}
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		} catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "上传成功";
//	}
}
