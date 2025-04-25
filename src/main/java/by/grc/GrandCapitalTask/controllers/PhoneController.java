package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.dtos.PhoneDto;
import by.grc.GrandCapitalTask.mapper.Mapper;
import by.grc.GrandCapitalTask.models.Phone;
import by.grc.GrandCapitalTask.services.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;
    private final Mapper<Phone, PhoneDto> mapper;

    @PostMapping("/add")
    public ResponseEntity<PhoneDto> addPhone(@RequestBody PhoneDto phoneDto) {

        return ResponseEntity.ok(this.mapper.toDto(this.phoneService.
                save(this.mapper.toEntity(phoneDto, Phone.class)), PhoneDto.class));
    }

    @PutMapping("/update")
    public ResponseEntity<PhoneDto> updatePhone(@RequestBody PhoneDto phoneDto) {
        return ResponseEntity.ok(this.mapper.toDto(this.phoneService.
                update(this.mapper.toEntity(phoneDto, Phone.class)), PhoneDto.class));
    }

    @DeleteMapping("/delete")
    public void deletePhone(@RequestBody PhoneDto phoneDto) {
        this.phoneService.delete(this.mapper.toEntity(phoneDto, Phone.class));
    }
}
