package com.example.PA4.Controller;
import com.example.PA4.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UsuarioService servico;

    @GetMapping("/user")
    public ModelAndView getusers() {
        ModelAndView mv = new ModelAndView("user");
        mv.addObject("user", servico.getUsers());
        return mv;
    }

    @GetMapping("/username/{username}")
    public ModelAndView getbyusername(@PathVariable(name = "username") String username) {
        ModelAndView mv = new ModelAndView("user");
        //Usuario user = servico.getuserbyid(Id);
        mv.addObject("user", servico.getuserbyusername(username));
        return mv;
    }
}
