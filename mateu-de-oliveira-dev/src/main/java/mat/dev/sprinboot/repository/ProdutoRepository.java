package mat.dev.sprinboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mat.dev.sprinboot.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("select p from Produto p where lower(p.nome) like %:nome%")
	List<Produto> buscarPorNome(@Param("nome") String nome);
	
	@Query("select p from Produto p where p.categoria.id = :idCategoria")
	List<Produto> buscarPorCategoria(@Param("idCategoria") Long idCategoria);
	

	@Transactional
	@Modifying /*tem que ter @Modifying para update e delete */
	@Query("update Produto set quantidade = quantidade + :quantidade where id = :id")
	void adicionarEstoque(@Param("id") Long id, @Param("quantidade") Integer quantidade);
	

	@Transactional
	@Modifying /*tem que ter @Modifying para update e delete */
	@Query("update Produto set quantidade = quantidade - :quantidade where id = :id")
	void removerEstoque(@Param("id") Long id, @Param("quantidade") Integer quantidade);

}
