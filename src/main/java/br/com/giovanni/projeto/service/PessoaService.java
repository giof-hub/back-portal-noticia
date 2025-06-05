package br.com.giovanni.projeto.service;

import br.com.giovanni.projeto.entity.Pessoa;
import br.com.giovanni.projeto.models.PessoaDTO;
import br.com.giovanni.projeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public void insert(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getIdade());

        repository.save(pessoa);
    }
}
