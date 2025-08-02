package com.yourname.springmcp.model.mcp;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McpError(
    @JsonProperty("code") int code,
    @JsonProperty("message") String message,
    @JsonProperty("data") Object data
) {}
