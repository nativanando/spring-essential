package br.com.springessential;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.springessential.entities.Empresa;
import br.com.springessential.repositories.EmpresaRepository;
import br.com.springessential.utils.SenhaUtils;

@SpringBootApplication
public class SpringEssentialApplication {
    
    @Autowired
    private EmpresaRepository empresaRepository;	
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	SpringApplication.run(SpringEssentialApplication.class, args);
    }

    /**
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner() {
	return args -> {
	    String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
	    System.out.println("Senha encoded: " + senhaEncoded);
	    String newSenhaEncoded = SenhaUtils.gerarBCrypt("123456");
	    System.out.println("Senha encoded: " + newSenhaEncoded);
	    System.out.println("Match da senha: " + SenhaUtils.senhaValida("123456", senhaEncoded));
	    System.out.println("Match da senha: " + SenhaUtils.senhaValida("123456", newSenhaEncoded));	  
	 
	    /// Lista uma empresa e busca todas
	    Empresa empresa = new Empresa();
	    empresa.setRazaoSocial("nativa-soft");
	    empresa.setCnpj("123456789");
	    this.empresaRepository.save(empresa);
	    List<Empresa> empresas = empresaRepository.findAll();
	    empresas.forEach(System.out::println);
	    
	    // Altera uma empresa
	    Empresa empresaDb = this.empresaRepository.findById(1L).orElse(null);
	    empresaDb.setRazaoSocial("nova-razao-social-nativa-soft");
	    this.empresaRepository.save(empresaDb);
	    System.out.println("Empres com o cnpj atualizado = " + empresaDb);
	    
	    //Busca pelo end point criado manualmente
	    Empresa empresaCnpj = this.empresaRepository.findByCnpj("123456789");
	    System.out.println("Empresa por CNPJ = =" + empresaCnpj);
	    
	    //Delete uma empresa
	    this.empresaRepository.deleteById(1L);
	    
	    //Lista todas as empresas
	    empresas = this.empresaRepository.findAll();
	    System.out.println("Empresas cadastradas = " + empresas.size());
	};

    }

}
