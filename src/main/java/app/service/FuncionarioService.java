package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
		@Autowired
		private FuncionarioRepository repository;
		
		public String save(Funcionario obj) {
			this.repository.save(obj);
			return obj.getNome() + " Funcionário salvo com sucesso.";
		}
		
		public List<Funcionario> listAll(){
			return this.repository.findAll();
		}
		
		public String update(long id, Funcionario obj) {
			obj.setId(id);
			this.repository.save(obj);
			return "Funcionário não encontrado para alterar";
		}
		
		public Funcionario findById(long id) {
			Funcionario obj = this.repository.findById(id).get();
			return obj;
		}
		
		public String delete(long id) {
			this.repository.deleteById(id);
			return "Funcionário não encontrado para deletar";
		}	
	}