package com.yourname.springmcp.service;

import com.yourname.springmcp.model.mcp.ContextItem;
import com.yourname.springmcp.model.mcp.McpRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
public class ContextProviderService {
    
    private final CodeAnalysisService codeAnalysisService;
    
    public ContextProviderService(CodeAnalysisService codeAnalysisService) {
        this.codeAnalysisService = codeAnalysisService;
    }
    
    public Mono<List<ContextItem>> processRequest(McpRequest request) {
        return switch (request.method()) {
            case "getCodeContext" -> getCodeContext(request.params());
            case "analyzeRepository" -> analyzeRepository(request.params());
            case "searchCode" -> searchCode(request.params());
            default -> Mono.error(new IllegalArgumentException("Unknown method: " + request.method()));
        };
    }
    
    private Mono<List<ContextItem>> getCodeContext(Map<String, Object> params) {
        String query = (String) params.get("query");
        // Implementation will be added in next phase
        return Mono.just(List.of(
            new ContextItem(
                "ctx-1",
                "code",
                "Sample code context for: " + query,
                Map.of("language", "java", "file", "Example.java"),
                0.95,
                Instant.now()
            )
        ));
    }
    
    private Mono<List<ContextItem>> analyzeRepository(Map<String, Object> params) {
        String repoUrl = (String) params.get("repositoryUrl");
        return codeAnalysisService.analyzeRepository(repoUrl);
    }
    
    private Mono<List<ContextItem>> searchCode(Map<String, Object> params) {
        String searchQuery = (String) params.get("query");
        // Vector search implementation coming next
        return Mono.just(List.of());
    }
}
