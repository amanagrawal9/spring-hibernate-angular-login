package com.flikon.controller;

import com.flikon.entity.User;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flikon.service.SecurityService;
import com.flikon.service.UserService;
import com.flikon.validator.UserValidator;
import com.flikon.wrapper.UserInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = {"/current_user"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> loggedInUser() {
        User user = null;
        String userName = securityService.findLoggedInUsername();
        if(StringUtils.isNotBlank(userName)) {
            user = userService.getUserByEmail(userName);
            user.setPassword(null);
            return returnWrapper(user, HttpStatus.OK);
        }
        return returnWrapper("User not logged in", HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> registration(@RequestBody UserInfo userForm) {

        userService.saveUser(userForm);
        return returnWrapper("User Saved Sucessfully", HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> returnWrapper(Object data, HttpStatus status) {
        Map<String, Object> returnWrapperMap = new HashMap<>();
        returnWrapperMap.put("data", data);
        returnWrapperMap.put("status", status.value());
        return new ResponseEntity<>(returnWrapperMap, status);
    }


    /*@RequestMapping(value = "/edit", method = RequestMethod.GET)
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
        User user = userService.updateUser(userForm);
        return "welcome";
    }*/
}
