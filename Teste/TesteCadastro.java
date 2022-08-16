package Teste;
import org.junit.Assert;
import org.junit.Test;
import Classe.Cliente;
public class TesteCadastro {
	
		
		Cliente cli = new Cliente();
				
			@Test 
			public void atualizar () {
				Assert.assertEquals("6",cli.getId());
				Assert.assertEquals("Laryssa Peçanha de Oliveira Barreto da Silva",cli.getNome());
				Assert.assertEquals("laryssascampark@gmail.com",cli.getEmail());
				Assert.assertEquals("1997",cli.getWhats());
				
			}
			
			
			
		
		}
		


