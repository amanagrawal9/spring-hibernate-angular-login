package com.flikon.controller;

import com.flikon.entity.User;
import com.flikon.service.SecurityService;
import com.flikon.service.UserService;
import com.flikon.wrapper.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		String userName = securityService.findLoggedInUsername();
		if(StringUtils.isBlank(userName)) {
			return "index";
		} else {
			return "home";
		}
	}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        String userName = securityService.findLoggedInUsername();
        if(StringUtils.isBlank(userName)) {
            return "index";
        } else {
            return "home";
        }
    }
}
