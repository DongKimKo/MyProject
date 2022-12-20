package my.web.dgm.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import my.web.dgm.dao.FDao;
import my.web.dgm.dto.FDto;

public class FContentCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		FDao dao = new FDao();
		FDto dto = dao.contentView(bId);
		
		model.addAttribute("content_view", dto);

		}
}
