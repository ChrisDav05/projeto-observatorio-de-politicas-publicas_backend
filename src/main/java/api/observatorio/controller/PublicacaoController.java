package br.ifpi.observatorio.controller;

import br.ifpi.observatorio.model.Publicacao;
import br.ifpi.observatorio.service.PublicacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicacoes")
@CrossOrigin("*")
public class PublicacaoController {

    private final PublicacaoService service;

    public PublicacaoController(PublicacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Publicacao> listar() {
        return service.listar();
    }

    @GetMapping("/buscar")
    public List<Publicacao> buscar(@RequestParam String titulo) {
        return service.buscarPorTitulo(titulo);
    }

    @GetMapping("/categoria/{id}")
    public List<Publicacao> categoria(@PathVariable Long id) {
        return service.buscarPorCategoria(id);
    }

    @PostMapping
    public Publicacao salvar(@RequestBody Publicacao publicacao) {
        return service.salvar(publicacao);
    }

}