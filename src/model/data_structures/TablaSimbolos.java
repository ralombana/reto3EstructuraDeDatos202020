package model.data_structures;

import clases.Pelicula;

public interface TablaSimbolos<K extends Comparable<K>, V extends Comparable<V>> 
{
	public void put(K llave, V Valor);
	
	public V get(K llave);
	
	public V remove(K llave);
	
	public boolean contains(K llave);
	
	public boolean isEmpty();
	
	public int size();
	
	public ListaEncadenada<K> keySet();
	
	public ListaEncadenada<V> valueSet();
	
}
