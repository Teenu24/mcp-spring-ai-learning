package com.yourname.springmcp.model.mcp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Map;

public record ContextItem(
    @JsonProperty("id") String id,
    @JsonProperty("type") String type,
    @JsonProperty("content") String content,
    @JsonProperty("metadata") Map<String, Object> metadata,
    @JsonProperty("relevanceScore") Double relevanceScore,
    @JsonProperty("timestamp") Instant timestamp
) {}
