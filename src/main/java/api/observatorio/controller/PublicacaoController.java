package br.ifpi.observatorio.controller;

import br.ifpi.observatorio.model.Publicacao;
import br.ifpi.observatorio.service.PublicacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    private final PublicacaoService service;

    public PublicacaoController(PublicacaoService service){

        this.service = service;

    }

    @GetMapping
    public List<PublicacaoResponse> listar(){

        return service.listar();

    }

    @PostMapping
    public PublicacaoResponse salvar(

            @Valid

            @RequestBody

            PublicacaoRequest dto){

        return service.salvar(dto);

    }

}