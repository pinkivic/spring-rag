package com.example.rag.service;

import com.example.rag.domain.Document;
import com.example.rag.repository.DocumentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final Logger log = LoggerFactory.getLogger(DocumentService.class);
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document buildAndSave(Document document) {
        log.debug("Request to buildAndSave Document: {}", document);
        return documentRepository.save(document);
    }

    public Optional<Document> findById(Long id) {
        log.debug("Request to find Document by id: {}", id);
        return documentRepository.findById(id);
    }

    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    public void deleteById(Long id) {
        log.debug("Request to delete Document by id: {}", id);
        documentRepository.deleteById(id);
    }
}