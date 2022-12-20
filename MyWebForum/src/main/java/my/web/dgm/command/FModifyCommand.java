package my.web.dgm.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import my.web.dgm.dao.FDao;

public class FModifyCommand implements FCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String bId = request.getParameter("bId");
		String bCategory = request.getParameter("bCategory");
		String bTitle = request.getParameter("bTitle");
		String bName = request.getParameter("bName");
		String bContent = request.getParameter("bContent");
		String bAccount = request.getParameter("bAccount");

		FDao dao = new FDao();
		dao.modify(bId, bCategory, bTitle, bName, bContent, bAccount);
	}

}
