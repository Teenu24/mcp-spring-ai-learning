package com.yourname.springmcp.model.mcp;

import com.fasterxml.jackson.annotation.JsonProperty;

public record McpResponse(
    @JsonProperty("id") String id,
    @JsonProperty("result") Object result,
    @JsonProperty("error") McpError error
) {
    public static McpResponse success(String id, Object result) {
        return new McpResponse(id, result, null);
    }
    
    public static McpResponse error(String id, McpError error) {
        return new McpResponse(id, null, error);
    }
}
