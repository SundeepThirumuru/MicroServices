package com.sundeep.movieBooking;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActorController {
	
	@Autowired
	private ActorRepository actorRepository;

	private Logger logger = LogManager.getLogger(getClass().getName());
	
	@Autowired
	private ActorValidator actorValidator;
	
	@InitBinder("actor")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(actorValidator);
	}
	
	@RequestMapping("/listActors")
	public ModelAndView listactors(ModelAndView modelAndView) {
		logger.info("Inside list Actors Info - Start");
		modelAndView.setViewName("listActors");
		modelAndView.addObject("actors", actorRepository.findAll());
		logger.info("Inside list actors Info - end");
		return modelAndView;
	}

	@RequestMapping("/actorForm")
	public ModelAndView getactorForm(ModelAndView modelAndView) {
		modelAndView.addObject("actor", new Actor());
		modelAndView.setViewName("actorForm");
		return modelAndView;
	}	
	
	@RequestMapping("/editActorForm")
	public ModelAndView getactorForm(@RequestParam(value="id", required=false) int id, ModelAndView modelAndView) {
		if(id > 0 && actorRepository.exists(id)) {
			Actor actor = actorRepository.findOne(id);
			modelAndView.addObject("actor", actor);
			modelAndView.setViewName("editActorForm");
		}
		else {
			modelAndView.addObject("actor", new Actor());
			modelAndView.setViewName("actorForm");
		}

		return modelAndView;
	}
	
	@RequestMapping("/addActor")
	public ModelAndView addactor(@Valid @ModelAttribute("actor") Actor actor, BindingResult result, ModelAndView modelAndView) {
		logger.info("Inside add actor");
		if(!result.hasErrors()) {
			actorRepository.save(actor);
			modelAndView.addObject("message", "Add Successful!!");
			modelAndView.setViewName("listActors");
			modelAndView.addObject("actors", actorRepository.findAll());
		}
		else
		{
			modelAndView.setViewName("actorForm");			
		}
		return modelAndView;
	}
	
	@RequestMapping("/editActor")
	public ModelAndView editactor(@Valid @ModelAttribute("actor") Actor actor, BindingResult result, ModelAndView modelAndView) {
		logger.info("Inside edit actors");
		if(!result.hasErrors()) {
			actorRepository.save(actor);
			modelAndView.addObject("message", "Edit Successful!!");
			modelAndView.setViewName("listActors");
			modelAndView.addObject("actors", actorRepository.findAll());
		}
		else
		{
			modelAndView.setViewName("editActorForm");		
		}
		return modelAndView;
	}
	
	@RequestMapping("/deleteActor")
	public ModelAndView deleteactor(@RequestParam(value = "id") int id, ModelAndView modelAndView) {
		logger.info("Inside delete actors");
		actorRepository.delete(id);
		modelAndView.setViewName("listActors");
		modelAndView.addObject("message", "Delete Successful!!");		
		modelAndView.addObject("actors", actorRepository.findAll());
		return modelAndView;
	}

}
