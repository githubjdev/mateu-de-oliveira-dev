package mat.dev.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mat.dev.sprinboot.entidades.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   
}
