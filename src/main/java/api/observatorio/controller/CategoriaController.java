package api.observatorio.controller;

import api.observatorio.dto.CategoriaRequest;
import api.observatorio.dto.CategoriaResponse;
import api.observatorio.service.CategoriaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:4200")
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

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        
        service.deletar(id);

    }


}