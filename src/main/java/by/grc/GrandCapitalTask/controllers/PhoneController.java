package by.grc.GrandCapitalTask.controllers;

import by.grc.GrandCapitalTask.dtos.PhoneDto;
import by.grc.GrandCapitalTask.mapper.Mapper;
import by.grc.GrandCapitalTask.models.Phone;
import by.grc.GrandCapitalTask.services.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Tag(name = "PhoneController", description = "контроллер для работы с номерами телефонов")
public class PhoneController {

    private final PhoneService phoneService;
    private final Mapper<Phone, PhoneDto> mapper;

    @Operation(summary = "Добавление", description = "Добавляет новый номер телефона")
    @PostMapping("/add")
    public ResponseEntity<PhoneDto> addPhone(@RequestBody PhoneDto phoneDto) {

        return ResponseEntity.ok(this.mapper.toDto(this.phoneService.
                save(this.mapper.toEntity(phoneDto, Phone.class)), PhoneDto.class));
    }

    @Operation(summary = "Изменение", description = "Изменяет номер телефона")
    @PutMapping("/update")
    public ResponseEntity<PhoneDto> updatePhone(@RequestBody PhoneDto phoneDto) {
        return ResponseEntity.ok(this.mapper.toDto(this.phoneService.
                update(this.mapper.toEntity(phoneDto, Phone.class)), PhoneDto.class));
    }

    @Operation(summary = "Удаление", description = "Удаляет номер телефона")
    @DeleteMapping("/delete")
    public void deletePhone(@RequestBody PhoneDto phoneDto) {
        this.phoneService.delete(this.mapper.toEntity(phoneDto, Phone.class));
    }
}
