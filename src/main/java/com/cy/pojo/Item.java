package com.cy.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

@TableName("tb_item")
@Data
public class Item implements Serializable {
	@TableId
	@Excel(name = "序号")
    private Long id;
	
	@Excel(name = "标题")
    private String title;
	
	@Excel(name = "卖点")
    private String sellPoint;

	@Excel(name = "价格")
    private Long price;

	@Excel(name = "数量")
    private Integer num;

	@Excel(name = "尺寸")
    private String barcode;

	@Excel(name = "图片")
    private String image;

	@Excel(name = "商品id")
    private Long cid;
	
	@Excel(name = "入库时间",format = "yyyy-MM-dd HH-mm-ss",orderNum = "1")
    private Date created;

	@Excel(name = "修改时间",format = "yyyy-MM-dd HH-mm-ss")
    private Date updated;
	
	@Excel(name = "状态码")
    private byte status;
	
	
}