package com.example.rag.web.rest;

import com.example.rag.domain.Document;
import com.example.rag.service.DocumentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentResource {

    private final Logger log = LoggerFactory.getLogger(DocumentResource.class);
    private final DocumentService documentService;

    public DocumentResource(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document) throws URISyntaxException {
        log.debug("REST request to save Document: {}", document);
        Document result = documentService.buildAndSave(document);

        return ResponseEntity
                .created(new URI("/documents/" + result.getId()))
                .body(result);
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        log.debug("REST request to get all Documents");
        return documentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable Long id) {
        log.debug("REST request to get Document: {}", id);
        Optional<Document> document = documentService.findById(id);
        return document.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        log.debug("REST request to delete Document: {}", id);
        documentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}