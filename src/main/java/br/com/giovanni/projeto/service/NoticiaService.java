package br.com.giovanni.projeto.service;

import br.com.giovanni.projeto.entity.Noticia;
import br.com.giovanni.projeto.entity.NoticiaDocumento;
import br.com.giovanni.projeto.models.NoticiaDocumentoDTO;
import br.com.giovanni.projeto.models.NoticiaDTO;
import br.com.giovanni.projeto.models.NoticiaResponseDTO;
import br.com.giovanni.projeto.repository.NoticiaDocumentoRepository;
import br.com.giovanni.projeto.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticiaService {

    @Autowired
    private FileStorageService fileService;

    @Autowired
    private NoticiaDocumentoRepository noticiaDocumentoRepository;

    @Autowired
    private NoticiaRepository repository;

    public List<NoticiaResponseDTO> listAll() {
        List<Noticia> noticias = repository.findAll();

        List<NoticiaResponseDTO> list = new ArrayList<>();

        for (Noticia noticia : noticias) {
            list.add(NoticiaResponseDTO.converter(noticia));
        }

        return list;
    }

    public NoticiaDTO save(NoticiaDTO noticiaDTO) {
        Noticia noticia = Noticia.converter(noticiaDTO);

        repository.save(noticia);

        noticiaDTO.setId(noticia.getId());
        noticiaDTO.setDataPublicacao(noticia.getDataPublicacao());

        return noticiaDTO;
    }

    public Resource loadFile(String fileName) {
        return fileService.load(fileName);
    }

    public NoticiaDocumentoDTO upload(MultipartFile file) {
        String filePath = this.fileService.save(file);

        NoticiaDocumento noticiaDocumento = new NoticiaDocumento();
        noticiaDocumento.setPath(filePath);
        noticiaDocumento.setFullPath(filePath);

        noticiaDocumentoRepository.save(noticiaDocumento);

        return NoticiaDocumentoDTO.convert(noticiaDocumento);
    }
}
