package model.data_structures;

public class ListaEncadenada<T extends Comparable<T>> implements IListaEncadenada<T>{

	private Nodo first;

	public class Nodo{

		private T info;

		private Nodo siguiente = null;

		public Nodo(T informacion) {
			info = informacion;
		}

		public Nodo darSiguiente() {
			return siguiente;
		}

		public void cambiarSiguiente(Nodo nuevo) {
			siguiente = nuevo;
		}

		public T darInfo() {
			return info;
		}

	}

	@Override
	public void insertar(T dato) {
		// TODO Auto-generated method stub

	}

	public ListaEncadenada(){
		first = null;
	}

	public Nodo darFirst()
	{
		return first;
	}
	public int contarDatos() {
		if(!existeEnLaLista()) {
			return 0;
		}
		Nodo actual = first;
		int cantidad = 0;
		boolean endHere= false;
		while(!endHere)
		{
			cantidad++;

			if(actual.darSiguiente() == null)
			{
				endHere = true;
			}
			else
			{
				actual = actual.darSiguiente();	
			}
		}
		return cantidad;

	}

	public void insert(T dato) {
		if(!existeEnLaLista()) {
			first = new Nodo(dato);
		}
		else {
			Nodo actual = first;
			boolean termine = false;
			while(!termine) {
				if(actual.darSiguiente() == null) {
					actual.cambiarSiguiente(new Nodo(dato));
					termine = true;
				}
				actual = actual.darSiguiente();
			}
		}
	}

	public T darPosicionDatos(int posicion) { 
		Nodo devolverDatos = null;
		boolean finalizar= true;
		Nodo actual = first;
		int posicionActual = 0;
		if(!existeEnLaLista()) {
			return null;
		}
		else {
			while(!finalizar && posicionActual<contarDatos()) {
				if(posicionActual == posicion) {
					devolverDatos = actual;
					finalizar = false;
				}
				posicionActual++;
				actual = actual.darSiguiente();
			}
		}
		return devolverDatos == null? null:devolverDatos.darInfo();
	}

	public boolean existeEnLaLista() {
		return first == null? true:false ;
	}

	public void agregarAlPrincipio(T dato) {
		Nodo nodo = new Nodo(dato);
		if(first==null)
		{
			first = nodo;
		}
		else
		{
			nodo.cambiarSiguiente(first);
			first = nodo;
		}
	}

	public T borrar(T dato) {
		boolean acabar = false;
		if(dato.equals(first.darInfo())) {
			first = first.darSiguiente();
		}
		else {
			Nodo anterior = first;
			Nodo actual = first.darSiguiente();
			while(!acabar && actual != null) {
				if(actual.darInfo().equals(dato)) {
					anterior.cambiarSiguiente(actual.darSiguiente());
					acabar = true;
				}
				actual = actual.darSiguiente();
				anterior = anterior.darSiguiente();

			}
		}
		return dato;
	}

	public T borrarPorPosicion(int pos) {
		T quitar = darPosicionDatos(pos);
		return borrar(quitar);
	}


	public T darPrimerElemento() {
		return existeEnLaLista()?first.darInfo():null;
	}

	public T darUltimoElemento() {

		if(!existeEnLaLista()) {
			return null;
		}
		else {
			return darPosicionDatos(contarDatos()-1);
		}
	}


	public T buscar(T dato) {
		Nodo pos = first;
		if(pos.darInfo().equals(dato)) return pos.darInfo();
		while(pos.darSiguiente() != null) {
			pos = pos.darSiguiente();
			if(pos.darInfo().equals(dato)) {
				return pos.darInfo();
			}
		}
		return dato;

	}

	@Override
	public void agregarAlFinal(T dato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T darElemento(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
