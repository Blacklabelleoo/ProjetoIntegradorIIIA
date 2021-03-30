package Biblioteca;

public class ListaLivro{
	No inicio;
	No fim;
	int tamanho;
	
	public void inserirInicio(Livro livro) {
		No no = new No();
		no.livro = livro;
		no.anterior = null;
		no.proximo = inicio;
		if (inicio != null) {
			inicio.anterior = no;
		}		
		inicio = no;
		if (tamanho == 0 ) {
			fim = inicio;
		}
		tamanho ++;
	}
	
	public Livro retirarInicio() {
		if(inicio == null) {
			return null;
		}
		Livro out = inicio.livro;
		inicio = inicio.proximo;
		if (inicio != null) {
			inicio.anterior = null;
		} else {
			fim = null;
		}
		tamanho --;
		
		return out;
	}
	
	public void inserirFim(Livro livro) {
		No no = new No();
		no.livro = livro;
		no.proximo = null;
		no.anterior = fim;
		if (fim != null) {
			fim.proximo = no;
		}
		fim = no;
		if(tamanho == 0) {
			inicio = fim;
		}
		tamanho ++;	
	}
	
	public Livro retiraFim() {
		if (fim == null) {
			return null;
		}
		Livro out = fim.livro;
		fim = fim.anterior;
		if (fim != null) {
			fim.proximo = null;
		} else {
			inicio = null;
		}
		tamanho --;		
		return out;		
	}
	
	public int tamanho() {
		return tamanho;
	}
	
	public Livro get(int index) {
		//fazer
	}
	
	public ordenar() {
		//fazer
	}
}









