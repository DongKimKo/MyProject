package my.web.dgm.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import my.web.dgm.dao.FDao;

public class FDeleteCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bId");
		FDao dao = new FDao();
		dao.delete(bid);
	}

}
