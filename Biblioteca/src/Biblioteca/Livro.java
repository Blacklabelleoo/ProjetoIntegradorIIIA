package Biblioteca;

public class Livro {
	private String titulo;
	private Integer isbn;
	private Autor autor;
	private String editora;
	private Integer ano;

	
	public Livro(String titulo, Integer isbn, Autor autor, String editora, Integer ano) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
	}

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getIsbn() {
		return isbn;
	}
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
