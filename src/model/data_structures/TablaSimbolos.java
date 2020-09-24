package model.data_structures;

import clases.Pelicula;

public interface TablaSimbolos<K extends Comparable<K>, V> 
{
	public void put(K llave, V valor);
	
	public V get(K llave);
	
	public V remove(K llave);
	
	public boolean contains(K llave);
	
	public boolean isEmpty();
	
	public int size();
	
	public ListaEncadenada<K> keySet();
	
	public V[] valueSet();
	
}
