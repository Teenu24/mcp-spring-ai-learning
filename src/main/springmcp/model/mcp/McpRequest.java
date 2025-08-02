package com.yourname.springmcp.model.mcp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record McpRequest(
    @JsonProperty("id") 
    @NotBlank String id,
    
    @JsonProperty("method") 
    @NotBlank String method,
    
    @JsonProperty("params") 
    @NotNull Map<String, Object> params
) {}
