package mat.dev.generics;

import mat.dev.encapsulamento.Produto;

public class RepositoryMain {
	
	
	public static void main(String[] args) {
		
		InMemoryRepository<Produto, Long> repo = new InMemoryRepository<Produto, Long>();
		
		repo.save(1L, new Produto("Alex"));
		repo.save(2L, new Produto("Mateus"));
		
		
		for(Produto pessoa: repo.findAll()) {
			System.out.println(pessoa.getNome());
		}
		
		
		System.out.println("Consulta: " + repo.findById(1L).getNome());
		
		repo.delete(1L);
		
		
		System.out.println("------------------Apos deletar----------------");
		for(Produto pessoa: repo.findAll()) {
			System.out.println(pessoa.getNome());
		}
		
	}

}
