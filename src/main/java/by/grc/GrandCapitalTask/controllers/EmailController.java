package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.dtos.EmailDto;
import by.grc.GrandCapitalTask.mapper.MapperImpl;
import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final MapperImpl<Email, EmailDto> mapper;

    @PostMapping("/add")
    public ResponseEntity<EmailDto> addEmail(@RequestBody EmailDto emailDto) {
        return ResponseEntity.ok(this.mapper.toDto(this.emailService
                .save(this.mapper.toEntity(emailDto, Email.class)), EmailDto.class));
    }

    @PutMapping("/update")
    public ResponseEntity<EmailDto> updateEmail(@RequestBody EmailDto emailDto) {
        return ResponseEntity.ok(this.mapper.toDto(this.emailService
                .update(this.mapper.toEntity(emailDto, Email.class)), EmailDto.class));
    }

    @DeleteMapping("/delete")
    public void deleteEmail(@RequestBody EmailDto emailDto) {
        this.emailService.delete(this.mapper.toEntity(emailDto, Email.class));
    }
}
