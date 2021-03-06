package br.org.generation.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity //create table entidade
	@Table(name = "tb_temas") //tabela
	public class Tema {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private long id;
		//gere o valor , estrategia geracao modelo identidade
		//long grande
		
		
		@NotNull(message = "O atributo Descrição é obrigatorio e não pode haver espaços em branco!") 
		private String descricao;
		
		@OneToMany (mappedBy = "tema", cascade= CascadeType.ALL)
		@JsonIgnoreProperties ("tema")
		private List<Postagem> postagem;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Postagem> getPostagem() {
			return postagem;
		}

		public void setPostagem(List<Postagem> postagem) {
			this.postagem = postagem;
		}
		
		

}
