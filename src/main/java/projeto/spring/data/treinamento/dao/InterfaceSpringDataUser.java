package projeto.spring.data.treinamento.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.spring.data.treinamento.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {
	
	//p de pessoa da classe
	@Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
	public List<UsuarioSpringData> buscaPorNome(String nome);
	
	@Query(value = "select p from UsuarioSpringData p where p.nome = :paranome")
	public UsuarioSpringData buscarPorNomeParam(@Param("paranome") String paranome);
	
	
	default <S extends UsuarioSpringData> S saveAtual(S entity) {
		//processa qualquer coisa
		return save(entity);
	}
	
	@Modifying
	@Transactional
	@Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
	public void deletePorNome(String nome);
	
	
}
