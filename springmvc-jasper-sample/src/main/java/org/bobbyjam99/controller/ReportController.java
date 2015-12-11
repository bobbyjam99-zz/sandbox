package org.bobbyjam99.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.bobbyjam99.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/report")
public class ReportController {

	public ModelAndView hoge(ModelAndView modelAndView) {

		Map<String, Object> parameterMap = new HashMap<>();
		List<Member> usersList = set();
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("pdfReport", parameterMap);
		return modelAndView;
	}

	private List<Member> set() {
		List<Member> memberList = new ArrayList<>();
		Member kanako = new Member();
		kanako.setName("百田夏菜子");
		memberList.add(kanako);
		Member shiori = new Member();
		shiori.setName("玉井詩織");
		memberList.add(shiori);

		return memberList;
	}
}
