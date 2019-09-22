package br.com.springessential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.springessential.repositories.EmpresaRepository;
import br.com.springessential.services.EmpresaService;

@SpringBootApplication
public class SpringEssentialApplication {
    
    @Autowired
    private EmpresaRepository empresaRepository;	
    
    @Autowired
    private EmpresaService empresaService;
    
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
	    this.empresaService.testarService();
	};

    }

}
