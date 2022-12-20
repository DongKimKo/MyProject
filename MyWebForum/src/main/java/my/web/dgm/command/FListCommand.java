package my.web.dgm.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import my.web.dgm.dao.FDao;
import my.web.dgm.dto.FDto;

public class FListCommand implements FCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		FDao dao = new FDao();
		ArrayList<FDto>dtos =  dao.list();
		
		model.addAttribute("list", dtos);
		
	}

}
