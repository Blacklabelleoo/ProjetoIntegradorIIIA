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
	
	public Livro retiraFim() { //refazer esse retira para o remove com index
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
	
	public Livro retirar(int index) {
		if(index < 0 
		   || index >= tamanho 
		   || inicio == null) {
			return null;
			
		} else if (index == 0) {
			return retirarInicio();
		} else if (index == tamanho -1) {
			return retiraFim();
		}
		No local = inicio;
		for(int i = 0; i < index; i++ ) {
			local = local.proximo;
		}
		if(local.anterior != null) {
			local.anterior.proximo = local.proximo;
		}
		if(local.proximo != null) {
			local.proximo.anterior = local.anterior;
		}
		tamanho --;
		
		return local.livro;
	}
	
	public int tamanho() {
		return tamanho;
	}
	
	public Livro get(int index) {
		if(index < 0 
		   || index >= tamanho 
		   || inicio == null) {
			return null;
			
		} else if (index == 0) {
			return inicio.livro;
		} else if (index == tamanho -1) {
			return fim.livro;
		}
		No local = inicio;
		for(int i = 0; i < index; i++ ) {
			local = local.proximo;
		}
		
		return local.livro;
	}
//	
//	public ordenar() {
//		//fazer
//	}
}









