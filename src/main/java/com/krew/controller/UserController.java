package com.krew.controller;

import com.krew.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.krew.service.SecurityService;
import com.krew.service.UserService;
import com.krew.validator.UserValidator;
import com.krew.wrapper.UserInfo;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserInfo());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserInfo userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        JSONObject responseStatus = userService.saveUser(userForm);

        if(responseStatus != null && "failed".equals(responseStatus.getString("Response Status"))) {
        	bindingResult.rejectValue("salesforceStatus", "", responseStatus.getString("Response Text"));
        	return "registration";
        }
        securityService.autologin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "welcome";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        String userName = securityService.findLoggedInUsername();
        if(StringUtils.isNotBlank(userName)) {
            User user = userService.getUserByEmail(userName);
            model.addAttribute("userForm", userService.adaptUserToUserInfo(user));
        }
        return "welcome";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model) {
        String userName = securityService.findLoggedInUsername();
        if(StringUtils.isNotBlank(userName)) {
            User user = userService.getUserByEmail(userName);
            model.addAttribute("userForm", userService.adaptUserToUserInfo(user));
        }
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("userForm") UserInfo userForm, BindingResult bindingResult, Model model) {
        /*userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }*/
        User user = userService.updateUser(userForm);
        return "welcome";
    }
}
