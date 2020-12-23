package br.projetos.api.apiRestSpring;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.apirest.schedule.model.Agendamento;
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "*", allowedHeaders = "*" )

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AgendamentoRest {
	
	@Autowired
    AgendamentoRepository agendamentoRepository;
	
	@Autowired
	LoginRepository loginAgendamento;

    @PostMapping("/agendamento")
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        Agendamento retorno = agendamentoRepository.save(agendamento);
        return ResponseEntity.ok(retorno);
    }


    @PutMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable("id") Long id, @RequestBody Agendamento agendamento){
    	Optional<Agendamento> anterior = agendamentoRepository.findById(id);
       
    	if(anterior.isPresent()){
    		Agendamento a = anterior.get();
            a.setNome(agendamento.getNome());
            a.setCurso(agendamento.getCurso());
            a.setMatricula(agendamento.getMatricula());
            a.setData(agendamento.getData());
            a.setAssunto(agendamento.getAssunto());
            a.setFinalizada(agendamento.getFinalizada());
            
            agendamentoRepository.save(a);
            
            return ResponseEntity.ok(a);
        }else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
   
    @GetMapping("/agendamento")
    public ResponseEntity<List<Agendamento>> getAgendamento(){
        List<Agendamento> lista = agendamentoRepository.findAll();
        return ResponseEntity.ok(lista);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Login> salvarLogin(@RequestBody Login login){
        Login retorno = loginAgendamento.save(login);
        return ResponseEntity.ok(retorno);
    }
    
    @GetMapping("/login")
    public ResponseEntity<List<Login>> getLogin(){
        List<Login> lista = loginAgendamento.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> getProdutoById(@PathVariable("id") Long id){
        Agendamento agendamento = agendamentoRepository.findById(id).get();
        return ResponseEntity.ok(agendamento);
    }
    
    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity delete(@PathVariable("id")  Long id){
    	agendamentoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    /*
    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody Login login) {
        return ResponseEntity.ok(login.getUsuario().equals("admin") && login.getSenha().equals("admin"));
    }*/
	
}
