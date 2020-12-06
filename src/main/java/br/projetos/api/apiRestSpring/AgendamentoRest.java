package br.projetos.api.apiRestSpring;

import java.util.ArrayList;
import java.util.List;

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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*" )

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AgendamentoRest {
	
	@Autowired
    AgendamentoRepository agendamentoRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        Agendamento retorno = agendamentoRepository.save(agendamento);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping("/update")
    public ResponseEntity<Agendamento> atualizarAgendamento(@RequestBody Agendamento agendamento){
        if(agendamento.getId()==null){
            ResponseEntity.notFound().build();
        }
        agendamento = agendamentoRepository.save(agendamento);
        
        return ResponseEntity.ok(agendamento);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Agendamento>> getAgendamento(){
        List<Agendamento> lista = agendamentoRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Agendamento> getProdutoById(@PathVariable("id") Long id){
        Agendamento agendamento = agendamentoRepository.findById(id).get();
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")  Long id){
    	agendamentoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/lista/finalizado")
    public ResponseEntity<List<Agendamento>> getProdutosFinalizados(){
    	
    	List<Agendamento> finalizado = new ArrayList<Agendamento>();
 
        List<Agendamento> lista = agendamentoRepository.findAll();
        
        for(Agendamento agend : lista) {
        	if(agend.getFinalizada() == "true") {
        		finalizado.add(agend);
        	}
        }
        
        return ResponseEntity.ok(finalizado);
    }
    
    @GetMapping("/lista/finalizadofalse")
    public ResponseEntity<List<Agendamento>> getProdutosFinalizadosfalse(){
    	
    	List<Agendamento> finalizado = new ArrayList<Agendamento>();
 
        List<Agendamento> lista = agendamentoRepository.findAll();
        
        for(Agendamento agend : lista) {
        	if(agend.getFinalizada() == "false") {
        		finalizado.add(agend);
        	}
        }
        
        return ResponseEntity.ok(finalizado);
    }
	
}
