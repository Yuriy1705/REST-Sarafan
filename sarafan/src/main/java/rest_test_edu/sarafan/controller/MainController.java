package rest_test_edu.sarafan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rest_test_edu.sarafan.domain.User;
import rest_test_edu.sarafan.repository.MessageRepository;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final MessageRepository messageRepository;

    @Autowired
    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){

        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile", user);
        data.put("messages", messageRepository.findAll());

        model.addAttribute("frontendData", data);
        return  "index";
    }
}
