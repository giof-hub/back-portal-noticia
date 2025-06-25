package br.com.giovanni.projeto.controller;

import br.com.giovanni.projeto.models.*;
import br.com.giovanni.projeto.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author giovanni.5160
 */
@RestController
@RequestMapping("v1/noticia")
@CrossOrigin("http://localhost:4200")
public class NoticiaController {

    @Autowired
    private NoticiaService service;

    @GetMapping
    public ResponseEntity<ResultDTO<List<NoticiaResponseDTO>>> listAll() {
        List<NoticiaResponseDTO> noticias = service.listAll();

        return ResponseEntity.ok(new ResultDTO<>(noticias));
    }

    @GetMapping(path = "file/{file}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<Resource> loadFile(@PathVariable String file) throws IOException {
        Resource resource = service.loadFile(file);

        return ResponseEntity.ok()
                .contentLength(resource.contentLength())
                .body(resource);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResultDTO<NoticiaDTO>> noticiar(@RequestBody NoticiaDTO noticiaDTO) {

        noticiaDTO = service.save(noticiaDTO);

        return ResponseEntity.ok(new ResultDTO<>(noticiaDTO));
    }

    @PostMapping(path = "/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public ResponseEntity<ResultDTO<NoticiaDocumentoDTO>> upload(@RequestPart("file") MultipartFile file) {

        NoticiaDocumentoDTO dto = service.upload(file);

        return ResponseEntity.ok(new ResultDTO<>(dto));
    }
}
