package by.grc.GrandCapitalTask.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/deposit")
@RequiredArgsConstructor
@Tag(name = "DepositController", description = "контроллер для депозитов")
public class DepositController {

}
