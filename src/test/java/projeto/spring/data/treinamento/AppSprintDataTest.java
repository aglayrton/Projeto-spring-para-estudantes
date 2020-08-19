package projeto.spring.data.treinamento;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.treinamento.dao.InterfaceSpringDataTelefone;
import projeto.spring.data.treinamento.dao.InterfaceSpringDataUser;
import projeto.spring.data.treinamento.model.Telefone;
import projeto.spring.data.treinamento.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})//busca o caminho do projeto
public class AppSprintDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceSpringDataTelefone interfaceSpringDataTelefone;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("mano@gmail.com");
		usuarioSpringData.setNome("Mano");
		usuarioSpringData.setLogin("admin");
		usuarioSpringData.setSenha("admin");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
	
	@Test
	public void testeInsertTelefone() {
		Telefone telefone =  new Telefone();
		telefone.setNumero("85991529944");
		telefone.setTipo("celular");
		
		Optional<UsuarioSpringData> usuario = interfaceSpringDataUser.findById(1L);
		telefone.setUsuario(usuario.get());
		interfaceSpringDataTelefone.save(telefone);
	}
	
	@Test
	public void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2l);
		System.out.println(usuarioSpringData.get().getNome());
		System.out.println(usuarioSpringData.get().getId());
		System.out.println(usuarioSpringData.get().getEmail());
	}
	
	@Test
	public void testeConsultarTodos() {
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for(UsuarioSpringData user : lista) {
			System.out.println(user.getNome());
		}
	}
	
	@Test
	public void testeUpdate() {
				
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		
		UsuarioSpringData data = usuarioSpringData.get();
		
		data.setNome("");
		
		interfaceSpringDataUser.save(data);
	}
	
	@Test
	public void testeDelete() {
		
		//Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		//interfaceSpringDataUser.delete(usuarioSpringData.get());
		//ou
		
		interfaceSpringDataUser.deleteById(2l);
	}
	
	
	@Test
	public void testeConsultarPorNome() {
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Jose");
		for(UsuarioSpringData user : list) {
			System.out.println(user.getNome());
		}
	}
	
	@Test
	public void testeConsultarNomePorParam() {
		UsuarioSpringData usuario = interfaceSpringDataUser.buscarPorNomeParam("aglayrton");
			System.out.println(usuario.getNome());
	}
	
	@Test 
	public void deletePorNome() {
		interfaceSpringDataUser.deletePorNome("Alex");
	}
	
	
	@Test
	public void updatePorNome() {
		interfaceSpringDataUser.updateEmailPorNome("francisco.juliao@prof.ce.gov.br", "Aglayrton");
	}
	
	
	
	
	
	
	
}
