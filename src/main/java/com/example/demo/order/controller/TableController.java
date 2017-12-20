package com.example.demo.order.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.order.pojo.Table;
import com.example.demo.order.service.ITableService;

/**
 * 处理对于台位请求的信息
 * @author 勾洪成
 *
 */
@Controller
@RequestMapping("api/table")
public class TableController {

	@Resource(name="tableServiceImpl")
	private ITableService tableService;
	
	private static final Logger logger = LoggerFactory.getLogger(TableController.class);
	
	@RequestMapping(value="/tables",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
	public @ResponseBody String tables() {
		logger.error("time:" + new Date() + "name:勾洪成" );
		return tableService.selectTable();
	}
}
