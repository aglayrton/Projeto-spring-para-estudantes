package projeto.spring.data.treinamento;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.treinamento.dao.InterfaceSpringDataUser;
import projeto.spring.data.treinamento.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})//busca o caminho do projeto
public class AppSprintDataTest {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Test
	public void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("aglayrtonjuliao@gmail.com");
		usuarioSpringData.setNome("Aglayrton");
		usuarioSpringData.setLogin("admin");
		usuarioSpringData.setSenha("admin");
		
		interfaceSpringDataUser.save(usuarioSpringData);
	}
	
	@Test
	public void testeConsulta() {
		System.out.println("Iniciou o spring com sucesso");
	}
	
}
