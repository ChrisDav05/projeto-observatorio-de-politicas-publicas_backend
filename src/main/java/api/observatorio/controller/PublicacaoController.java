package api.observatorio.controller;

import api.observatorio.dto.PublicacaoRequest;
import api.observatorio.dto.PublicacaoResponse;
import api.observatorio.service.PublicacaoService;
import jakarta.validation.Valid;

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