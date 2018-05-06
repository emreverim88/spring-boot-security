package main.controller;


import main.dto.AccountDTO;
import main.entity.Account;
import main.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class RegisterController {


    @Autowired
    private AccountService accountService;


    @GetMapping("/register")
    public String register(Model model) {

        AccountDTO accountDTO = new AccountDTO();
        model.addAttribute("accountDTO", accountDTO);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid AccountDTO accountDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());
        accountService.createAccount(account);

        return "redirect:/register/success";

    }

    @GetMapping("/register/success")
    public String registerResult() {
        return "result";
    }

}
