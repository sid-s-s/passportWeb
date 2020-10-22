package passport;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/p")
public class FormController {
	
	@Autowired
	private PassportDao passportDao;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String show(Map<String, Object> model) 
	{
		Passport p = new Passport();
		model.put("appForm", p);
		return "Application";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Valid @ModelAttribute("appForm") Passport p)
	{	
		passportDao.insert(p);
		return "Success";
	}

}
