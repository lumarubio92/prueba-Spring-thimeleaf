package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import configuration.Pages;
import model.Inicio;
import model.Post;

@Controller
@RequestMapping("/home")
public class controlador {
		//albahaca
	public List<Post> getPost(){
		
		ArrayList<Post> post=new ArrayList<>();
		post.add(new Post(1,
				"Valorada sobre todo por sus propiedades culinarias y su agradable y fresco perfume, la Albahaca es también un potente repelente natural de los mosquitos, por lo que no está de más tenerla cerca en verano.",
				"../img/albahaca.jpg"
				,new Date(0)
				,"Albahaca"
				));
		//aloe vera
		post.add(new Post(2,
				"Es una de las plantas más fáciles de encontrar en las casas, porque es muy resistente, aunque"
				+ " no tolera un exceso de sol en verano o temperaturas por debajo de los -10ºC. Además es de "
				+ "fácil mantenimiento, basta con regalarla de manera constante, pero sin encharcarla. ",
				"../img/aloe.jpg"
				,new Date(0)
				,"Aloe Vera"
				));
		//anturio
		post.add(new Post(3,
				"Su característica y rica floración, con un espádice tipo espiga rodeado de una hoja "
				+ "o espata de color rojo en forma de corazón, convierten al Anturio en una buena opción"
				+ " para decorar cualquier rincón de casa",
				"../img/anturio.jpg"
				
				,new Date(0)
				,"Anturio"
				));
		//areca
		post.add(new Post(4,
				"La Areca es de la familia de las palmeras, de ahí que sea una planta que puede alcanzar"
				+ " hasta 9 metros de altura. Sus estilizadas hojas verdes la hacen muy decorativa y elegante,"
				+ " y en verano ofrece una floración de florecillas blancas y con un agradable aroma. ",
				"../img/areca.jpg"
				,new Date(0)
				,"Areca"
				));
		
		//retorna el arreglo de datos
		return post;
	}
	
	public Inicio getinicio()
	{
		return new Inicio("Las 50 plantas y flores que todos deberíamos conocer",
						  "Con o sin flor, para rincones muy luminosos o con poca luz,"
						  + " sin apenas mantenimiento... Aquí tienes una selección de 50 "
						  + "plantas de interior con sus nombres respectivos, entre"
						  + " las que encontrarás las más adecuadas para ti y para tu casa");
	}
	
	//primera forma de enviar atributos por thymelaf
	@GetMapping(path = {"/post","/"})
	public String Saludo(Model model)
	{
		model.addAttribute("post",getPost());
		model.addAttribute("mensaje",getinicio());
		return "index";
	}
	//segunda formas de enviar atributos desde un objeto
	@GetMapping(path = {"/public"})
	public ModelAndView posts() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName(Pages.INDEX);
		modelAndView.addObject("post",getPost());
		modelAndView.addObject("mensaje",getinicio());
		return modelAndView;
		
	}
	@GetMapping(path = {"/private"})
	public ModelAndView getPostI(@RequestParam(defaultValue = "1",name="id",required = false) int id){
		ModelAndView modelAndView=new ModelAndView(Pages.POST);
		List<Post> postFiltrado=getPost().stream().filter(
				(p) -> {return p.getId()==id;}).collect(Collectors.toList());
		modelAndView.addObject("post",postFiltrado.get(0));
		return modelAndView;
	}
	@GetMapping(path = {"/formulario"})
	public ModelAndView getform() {
		ModelAndView modelAndView=new ModelAndView(Pages.FORM);
		modelAndView.addObject("post",new Post());
		return modelAndView;	
	}
	@PostMapping(path={"/form"})
	public String formNew(Post post,Model model,Inicio inicio)
	{
		List<Post> pst=getPost();
		pst.add(post);
		model.addAttribute("post",pst);
		model.addAttribute("mensaje",getinicio());

		return "index";
	}
	
	
}
