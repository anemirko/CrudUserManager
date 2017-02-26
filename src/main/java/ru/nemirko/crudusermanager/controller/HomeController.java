package ru.nemirko.crudusermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.nemirko.crudusermanager.model.User;
import ru.nemirko.crudusermanager.service.UserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        //logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView userListPage(@PageableDefault(page = 0, value = 5) Pageable pageable) {
        return new ModelAndView("list", "page", userService.findAll(pageable));
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public ModelAndView userSearchPage(@PageableDefault(page = 0, value = 5) Pageable pageable,
                                       @RequestParam(value = "searchstring", required = false) String s) {
        return new ModelAndView("list", "page", userService.findByNameStartingWith(s, pageable));
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView newUserPage() {
        return new ModelAndView("form", "user", new User());
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user, final RedirectAttributes redirectAttributes){

        ModelAndView mav = new ModelAndView();
        String message = "New user " + user.getName() + " was successfully created.";

        userService.create(user);
        mav.setViewName("redirect:/list");

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");

        User user = userService.findById(id);

        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user, @PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("redirect:/list");

        userService.update(user);
        String message = "User " + user.getName() + " was successfully updated.";

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView mav = new ModelAndView("redirect:/list");

        User user = userService.delete(id);
        String message = "User " + user.getName() + " was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);

        return mav;
    }
}
