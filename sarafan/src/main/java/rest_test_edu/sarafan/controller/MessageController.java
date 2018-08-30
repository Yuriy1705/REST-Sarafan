package rest_test_edu.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import rest_test_edu.sarafan.domain.Message;
import rest_test_edu.sarafan.domain.Views;
import rest_test_edu.sarafan.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepository.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable ("id") Message message) {
        return message;
    }


    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable ("id") Message messageFromDB,
                          @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");
        return messageRepository.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable ("id") Message message) {
        messageRepository.delete(message);
    }
}
