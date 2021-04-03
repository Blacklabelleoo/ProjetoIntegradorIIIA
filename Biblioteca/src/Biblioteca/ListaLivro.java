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
	public void insert(int index, Livro info) {
		if(index <= 0) {
			inserirInicio(info);
		} else if (index >= tamanho) {
			inserirFim(info);
		} else {
			No local = inicio;
			for (int i = 0; i < index-1; i++){
				local = local.proximo;
			}
			No no = new No();
			no.livro = info;
			no.anterior = local;
			no.proximo = local.proximo;
			local.proximo = no;
			no.proximo.anterior = no;
			tamanho++;
		}
	}
	public void set(int index, Livro info) {
		No local = inicio;
		for (int i = 0; i < index; i++){
			local = local.proximo;
		}
		local.livro = info;

	}
	
	static int partition(ListaLivro list, int begin, int end) {
	    int pivot = end;

	    int counter = begin;
	    for (int i = begin; i < end; i++) {
	        if (list.get(i).getTitulo().compareTo(list.get(pivot).getTitulo()) < 0) { //ver como comparar os titulos
	        	
	            Livro temp = list.get(counter);
	            list.set(counter, list.get(i));
	            list.set(i, temp);
	            counter++;
	        }
	    }
	    Livro temp = list.get(pivot);
	    list.set(pivot, list.get(counter));
	    list.set(counter, temp);

	    return counter;
	}

	public void quickSort(ListaLivro list, int begin, int end) {
	    if (end <= begin) return;
	    int pivot = partition(list, begin, end);
	    quickSort(list, begin, pivot-1);
	    quickSort(list, pivot+1, end);
	}
	
	public static void insertionSort(ListaLivro list) {
	    for (int i = 1; i < list.tamanho(); i++) {
	        Livro current = list.get(i);
	        int j = i - 1;
	        while(j >= 0 && current.getTitulo().compareTo(list.get(j).getTitulo()) < 0 ){
	            list.set(j + 1, list.get(j)); 
	            j--;
	        }

	        list.set(j + 1, current);
	    }
	}
	
}









