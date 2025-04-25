package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.dtos.EmailDto;
import by.grc.GrandCapitalTask.mapper.MapperImpl;
import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final MapperImpl<Email, EmailDto> mapper;

    @PostMapping("/add")
    public ResponseEntity<EmailDto> addEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(this.mapper.toDto(this.emailService.save(email), EmailDto.class));
    }
}
