package co.edu.usa.reto3.audience.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.reto3.audience.repository.crud.CategoriaCrudRepositorio;
import co.edu.usa.reto3.audience.model.Categoria;

@Repository
public class CategoriaRepositorio {
    @Autowired
    CategoriaCrudRepositorio categoriaCrudRepositorio;
    public List<Categoria>getAll(){
        return (List<Categoria>)categoriaCrudRepositorio.findAll();
    }
    public Optional<Categoria>getCategoria(int id){
        return categoriaCrudRepositorio.findById(id);
    }
    public Categoria save(Categoria categoria){
        return categoriaCrudRepositorio.save(categoria);
    }

    public void delete(Categoria categoria){
        categoriaCrudRepositorio.delete(categoria);
    }
}
