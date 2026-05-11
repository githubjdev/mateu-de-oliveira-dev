package mat.dev.sprinboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mat.dev.sprinboot.entidades.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	@Query("select p from Categoria p where lower(p.nome) like %:nome%")
	List<Categoria> buscarPorNome(@Param("nome") String nome);

}
