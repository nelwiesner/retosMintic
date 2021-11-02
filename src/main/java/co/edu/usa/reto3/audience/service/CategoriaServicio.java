package co.edu.usa.reto3.audience.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usa.reto3.audience.model.Categoria;
import co.edu.usa.reto3.audience.repository.CategoriaRepositorio;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria>getAll(){
        return categoriaRepositorio.getAll();
    }

    public Optional<Categoria>getCategoria(int id){
        return categoriaRepositorio.getCategoria(id);
    }

    public Categoria save(Categoria categoria){
        //Verificar si el id es nulo
        if(categoria.getId()==null){
            return categoriaRepositorio.save(categoria);
        }else{//Verifico si existe o no en la base de datos
            Optional<Categoria> consulta=categoriaRepositorio.getCategoria(categoria.getId());
            if (consulta.isEmpty()){
                return categoriaRepositorio.save(categoria);
            }else{
                return categoria;
            }
        }   
    }
}
