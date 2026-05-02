package ru.practicum.ewm.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.EndpointHitDto;
import ru.practicum.ewm.ViewStatsDto;
import ru.practicum.ewm.filter.StatsFilter;
import ru.practicum.ewm.service.EndpointHitService;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class StatsRestController {

    private final EndpointHitService statsService;

    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHit(@RequestBody EndpointHitDto dto) {
        statsService.createHit(dto);
    }

    @GetMapping("/stats")
    public List<ViewStatsDto> findStats(@ParameterObject StatsFilter filter) {
        return statsService.findStats(filter);
    }
}