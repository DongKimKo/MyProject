package my.web.dgm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import my.web.dgm.command.FCommand;
import my.web.dgm.command.FContentCommand;
import my.web.dgm.command.FDeleteCommand;
import my.web.dgm.command.FListCommand;
import my.web.dgm.command.FModifyCommand;
import my.web.dgm.command.FWriteCommand;
import my.web.dgm.util.Constant;

@Controller
public class FController {
	
	FCommand command;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}	
	
	@RequestMapping("/forum")
	public String forum(Model model) {
		System.out.println("forum()");	
		
		command = new FListCommand();
		command.execute(model);
		
		return "forum";
	}
	
	@RequestMapping("/writeform")
	public String writeform() {
		System.out.println("writeform()");	
		
		return "writeform";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
		command = new FContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
		command = new FWriteCommand();
		command.execute(model);	
		
		return "redirect:forum";
	}
	
	@RequestMapping("/modifyform")
	public String modifyform(HttpServletRequest request, Model model) {
		System.out.println("modifyform()");	
		
		model.addAttribute("request", request);
		command = new FContentCommand();
		command.execute(model);
		
		return "modifyform";
	}	

	@RequestMapping(method=RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");
		
		model.addAttribute("request", request);
		command = new FModifyCommand();		
		command.execute(model);		
		
		System.out.println();
		
		return "redirect:forum";
//		return "redirect:content_view?bId=" + ;
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new FDeleteCommand();
		command.execute(model);
		
		return "redirect:forum";
	}
	@RequestMapping("/MyGame")
	public String MyGame() {
		System.out.println("MyGame()");	
		
		return "MyGame";
	}
}
