package com.project.megaz.controllers;


import com.project.megaz.dto.DTOPost;
import com.project.megaz.dto.UserLogin;
import com.project.megaz.dto.UserRegister;
import com.project.megaz.entity.User;
import com.project.megaz.repository.UserRepository;
import com.project.megaz.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
//Essa anotação informa que se trata de um controller, assim o sistema prepara algumas especificações como o  getmapping.
@Controller
//Creio que não seja bom passar o repositório, mas depois eu troco.
public class UserController {
    UserService userService;
    UserRepository userRepository;


    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    //GetMapping, significa que eu vou mostrar algo na tela pelas requisições de http
    //Tipo Iterable pode encarrar como uma lista, eu fiquei com preguiça de trocar pra ArrayList.
    //ModelAndView É um modelo usado para passar coisas na web, eu poderia passar uma String por exemplo, mas assim é mais seguro
    //addObject, add um Objeto que nesse caso é um Iterable de User(Bem obvío).
    @GetMapping("/user")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("user/index");
        Iterable<User> users = userService.viewall();
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("user/home");
        return mv;
    }


    @GetMapping("/user/register")
    public ModelAndView Novo(UserRegister request) {
        return new ModelAndView("user/register");
    }

    //Postmapping É usado quando você quer passar dados, nesse caso o register.
    @PostMapping("/user")
    public ModelAndView Create(@Valid @ModelAttribute("userRegister") UserRegister request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("user/register");
            mv.addObject("usuario", request);
            return mv;
        }

        else{
            User user = request.ToUser();
            this.userRepository.save(user);
            return new ModelAndView("redirect:/user");

        }
    }

    @GetMapping("/user/login")
    public ModelAndView Login() {
        ModelAndView modelAndView = new ModelAndView("user/login");
        modelAndView.addObject("userLogin", new UserLogin()); // Cria um novo objeto UserLogin
        return modelAndView;

    }

    @PostMapping("/login")
    public ModelAndView Logar(@Valid @ModelAttribute("userLogin")UserLogin login, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()){
             mv.setViewName("user/register");
            mv.addObject("usuario", login);
            return mv;
        }

        User user = userService.login(login);
        if(user != null){
            mv.setViewName("redirect:/user");

        }
        else{

            bindingResult.rejectValue("email", "error.userLogin", "Email ou senha inválidos");
            mv.setViewName("user/login"); // Retorna à página de login
            mv.addObject("userLogin", login); // Retorna o objeto login para preencher os campos
        }

        ModelAndView modelAndView = new ModelAndView("redirect:/user");
        return modelAndView;
    }

 /*   @PostMapping("/post")
    public ModelAndView createPost(@Valid @ModelAttribute("dTOPost")DTOPost post, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();


        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }*/
}

