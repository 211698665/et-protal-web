package cn.henu.protal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.henu.content.service.ContentService;
import cn.henu.pojo.TbContent;

@Controller
public class IndexController {

	/**
	 * 首页展示的controller
	 */
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/index") //注意这里省略了.html后缀
	public String showIndex(Model model) {
		List<TbContent> ad1List = contentService.getContentByCid(CONTENT_LUNBO_ID);
		//把结果传递给页面
		model.addAttribute("ad1List",ad1List);
		return "index";
	}
}
