package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.domain.Product;
import guru.springframework.domain.User;
import guru.springframework.services.RoleService;
import guru.springframework.services.UserService;

@Controller
public class UserController {
    private RoleService roleService;
    private UserService userService;
    
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String roles(Model model){
        model.addAttribute("userList", userService.listAll());
        return "users";
    }
    
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
    	model.addAttribute("user", userService.getById(id));
    	model.addAttribute("userRoles", userService.getById(id).getRoles());
    	model.addAttribute("allRoles", roleService.listAll());
        return "userform";
    }
    
    @RequestMapping("user/new")
    public String newProduct(Model model){
    	User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("allRoles", roleService.listAll());
        return "userform";
    }
    
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Integer id){
    	userService.delete(id);
        return "redirect:/users";
    }
    
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user){
    	userService.saveOrUpdate(user);
        return "redirect:/user/" + user.getId();
    }
    
    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "userdetails";
    }
}
