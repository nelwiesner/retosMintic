package co.edu.usa.reto3.audience.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import co.edu.usa.reto3.audience.model.Categoria;
import co.edu.usa.reto3.audience.service.CategoriaServicio;

@RestController
@RequestMapping("/api/Category")
public class CategoriaControlador {
    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping("/all")
    public List<Categoria>getCategoria(){
        return categoriaServicio.getAll();
    }

    @GetMapping("/{id")
    public Optional<Categoria>getCategoria(@PathVariable("id") int id){
        return categoriaServicio.getCategoria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public Categoria save(@RequestBody Categoria categoria){
        return categoriaServicio.save(categoria);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaServicio.update(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategoria(@PathVariable("id") int id){
        return categoriaServicio.deleteCategoria(id);

    }
}
