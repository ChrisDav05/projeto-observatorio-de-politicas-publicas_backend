package br.ifpi.observatorio.controller;

import br.ifpi.observatorio.model.Categoria;
import br.ifpi.observatorio.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service){

        this.service = service;

    }

    @GetMapping
    public List<CategoriaResponse> listar(){

        return service.listar();

    }

    @PostMapping
    public CategoriaResponse salvar(

            @Valid

            @RequestBody

            CategoriaRequest dto){

        return service.salvar(dto);

    }

}
