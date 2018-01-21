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
public class MainController {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorRepository actorRepository;

	private Logger logger = LogManager.getLogger(getClass().getName());
	
	@Autowired
	private MovieValidator movieValidator;
	
	
	@InitBinder("movie")
	private void initBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
		binder.registerCustomEditor(Date.class, customDateEditor);
		binder.setValidator(movieValidator);
	}
	
	@RequestMapping("/listMovies")
	public ModelAndView listMovies(ModelAndView modelAndView) {
		logger.info("Inside list Movies Info - Start");
		modelAndView.setViewName("listMovies");
		modelAndView.addObject("movies", movieRepository.findAll());
		logger.info("Inside list Movies Info - end");
		return modelAndView;
	}

	@RequestMapping("/movieForm")
	public ModelAndView getMovieForm(ModelAndView modelAndView) {
		modelAndView.addObject("movie", new Movie());
		Iterable<Actor> actors = actorRepository.findAll();
	    modelAndView.addObject("actors", actors);
		modelAndView.setViewName("movieForm");
		return modelAndView;
	}	
	
	@RequestMapping("/editMovieForm")
	public ModelAndView getMovieForm(@RequestParam(value="id", required=false) int id, ModelAndView modelAndView) {
		Iterable<Actor> actors = actorRepository.findAll();
	    modelAndView.addObject("actors", actors);
		if(id > 0 && movieRepository.exists(id)) {
			Movie movie = movieRepository.findOne(id);
			modelAndView.addObject("movie", movie);
			modelAndView.setViewName("editMovieForm");
		}
		else {
			modelAndView.addObject("movie", new Movie());
			modelAndView.setViewName("movieForm");
		}

		return modelAndView;
	}
	
	@RequestMapping("/addMovie")
	public ModelAndView addMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, ModelAndView modelAndView) {
		logger.info("Inside add Movie");
		if(!result.hasErrors()) {
			movieRepository.save(movie);
			modelAndView.addObject("message", "Add Successful!!");
			modelAndView.setViewName("listMovies");
			modelAndView.addObject("movies", movieRepository.findAll());
		}
		else
		{
			Iterable<Actor> actors = actorRepository.findAll();
		    modelAndView.addObject("actors", actors);
			modelAndView.setViewName("movieForm");			
		}
		return modelAndView;
	}
	
	@RequestMapping("/editMovie")
	public ModelAndView editMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, ModelAndView modelAndView) {
		logger.info("Inside edit Movies");
		if(!result.hasErrors()) {
			movieRepository.save(movie);
			modelAndView.addObject("message", "Edit Successful!!");
			modelAndView.setViewName("listMovies");
			modelAndView.addObject("movies", movieRepository.findAll());
		}
		else
		{
			Iterable<Actor> actors = actorRepository.findAll();
		    modelAndView.addObject("actors", actors);
			modelAndView.setViewName("editMovieForm");		
		}
		return modelAndView;
	}
	
	@RequestMapping("/deleteMovie")
	public ModelAndView deleteMovie(@RequestParam(value = "id") int id, ModelAndView modelAndView) {
		logger.info("Inside delete Movies");
		movieRepository.delete(id);
		modelAndView.setViewName("listMovies");
		modelAndView.addObject("message", "Delete Successful!!");		
		modelAndView.addObject("movies", movieRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/*")
	public ModelAndView getWelcomePage(ModelAndView modelAndView) {
		logger.info("Inside getWelcomePage");
		modelAndView.setViewName("index");
		modelAndView.addObject("guestName", "Friend");
		return modelAndView;
	}	
}
