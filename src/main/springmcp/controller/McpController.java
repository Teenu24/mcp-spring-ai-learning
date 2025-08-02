package com.yourname.springmcp.controller;

import com.yourname.springmcp.model.mcp.McpRequest;
import com.yourname.springmcp.model.mcp.McpResponse;
import com.yourname.springmcp.service.ContextProviderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/mcp")
public class McpController {
    
    private final ContextProviderService contextProviderService;
    
    public McpController(ContextProviderService contextProviderService) {
        this.contextProviderService = contextProviderService;
    }
    
    @PostMapping("/context")
    public Mono<McpResponse> handleContextRequest(@RequestBody McpRequest request) {
        return contextProviderService.processRequest(request)
            .map(result -> McpResponse.success(request.id(), result))
            .onErrorResume(error -> Mono.just(
                McpResponse.error(request.id(), 
                    new McpError(-1, error.getMessage(), null))
            ));
    }
    
    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("MCP Server is running");
    }
}
