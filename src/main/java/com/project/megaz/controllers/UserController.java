package com.project.megaz.controllers;


import com.project.megaz.dto.UserRegister;
import com.project.megaz.entity.User;
import com.project.megaz.repository.UserRepository;
import com.project.megaz.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/user/register")
    public ModelAndView Novo() {
        return new ModelAndView("/user/register");
    }

    //Postmapping É usado quando você quer passar dados, nesse caso o register.
    @PostMapping("/user")
    public String Create(@Valid UserRegister request, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println("Jenio");
            return "redirect:/user/register";
        }
        else{
            User user = request.ToUser();
            this.userRepository.save(user);
            return "redirect:/user";
        }

        //redict Significa que quando você terminar o que tem que fazer ele vai ser direcionado para a página user.
    }
}
