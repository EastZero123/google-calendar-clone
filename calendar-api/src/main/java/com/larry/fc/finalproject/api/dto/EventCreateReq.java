package com.larry.fc.finalproject.api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventCreateReq {
    private final String title;
    private final String description;
    private final LocalDateTime startAt;
    private final LocalDateTime endAt;
    private final List<Long> attendeeIds;
}
