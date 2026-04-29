package ru.practicum.ewm.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.dto.compilation.CompilationFullDto;
import ru.practicum.ewm.service.CompilationService;

import java.util.List;

@RestController
@RequestMapping("/compilations")
@RequiredArgsConstructor
@Validated
@Slf4j
public class CompilationController {

    private final CompilationService service;

    @GetMapping
    public List<CompilationFullDto> find(
            @RequestParam(required = false) Boolean pinned,
            @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return service.find(pinned, pageable);
    }

    @GetMapping("/{compId}")
    public CompilationFullDto findById(@Positive @PathVariable Long compId) {
        return service.getEntityFool(compId);
    }
}