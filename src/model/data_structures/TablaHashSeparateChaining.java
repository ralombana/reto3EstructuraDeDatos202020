package model.data_structures;

import java.util.HashMap;
import java.util.Map;

import clases.Hash;
import clases.Pelicula;
import model.data_structures.ListaEncadenada.Nodo;

public class TablaHashSeparateChaining<K , V> implements TablaSimbolos <K, V>
{

	public V[] arreglo;
	public int tamaño, contador;
	
	/**
	 * 
	 * @param El tamaño debe ser un número primo que permita que haya un factor de carga 5.0, 
	 * es decir, para la lista de 300mil elementos sería minimo de 60mil el tamaño
	 */
	public TablaHashSeparateChaining(int pTamaño) 
	{
		tamaño = pTamaño;
		contador= 0; 
		arreglo = (V[])new Object[tamaño];
		for (int i = 0; i < tamaño; i++) 
		{
			arreglo[i] = (V) new ListaEncadenadaSinComparable<V>();
		}
	}
	
	@Override
	public void put(K llave, V valor) 
	{
		Hash pLlave = (Hash) llave;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[pLlave.darPosicion()];
		((ListaEncadenadaSinComparable<V>) arreglo[pLlave.darPosicion()]).agregarAlPrincipio((V) valor); 
		
	}
	
	@Override
	public V get(K llave) 
	{
		V rta = null;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[ new Hash((String)llave).darPosicion()];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct.darPrimerElemento();
		}
		return (V) rta;
	}

	@Override
	public V remove(K llave) 
	{
		ListaEncadenadaSinComparable<V> rta = null;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[((Hash) llave).darPosicion()];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct;
			arreglo[(int) ((Hash) llave).darPosicion()] = (V) new ListaEncadenadaSinComparable<V>();  
		}
		return (V) rta;
	}

	@Override
	public boolean contains(K llave) 
	{
		boolean rta = false;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[((Hash) llave).darPosicion()];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = true;
		}
		return rta;
	}

	@Override
	public boolean isEmpty() 
	{
		boolean rta = true;
		for (int i = 0; i < tamaño; i++) 
		{
			ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[i];
			if(listaAct.darPrimerElemento()!=null)
			{
				rta = false;
			}
		}
		return rta;
	}

	@Override
	public int size() {
		int rta = 0;
		for (int i = 0; i < tamaño; i++) 
		{
			if(arreglo[i]!=null)
			{
				rta++;
			}
		}
		return rta;
	}

	@Override
	public ListaEncadenadaSinComparable<K> keySet() 
	{
		ListaEncadenadaSinComparable<K> rta = new ListaEncadenadaSinComparable<K>();
		for (int i = 0; i < tamaño; i++) 
		{
			if(((ListaEncadenadaSinComparable<V>) arreglo[i]).darPrimerElemento()!=null)
			{
				Pelicula act = (Pelicula) ((ListaEncadenadaSinComparable<V>) arreglo[i]).darPrimerElemento();
				
			}
				
			}	
		return rta;
	}
		
	

	@Override
	public ListaEncadenadaSinComparable<V> valueSet() 
	{
		ListaEncadenadaSinComparable<V> rta = new ListaEncadenadaSinComparable<V>();
		for (int i = 0; i < tamaño; i++) 
		{
			if(((ListaEncadenadaSinComparable<V>) arreglo[i]).darPrimerElemento()!=null)
			{
				for (int j = 0; j < ((ListaEncadenadaSinComparable<V>) arreglo[i]).contarDatos(); j++) 
				{
					rta.agregarAlPrincipio(((ListaEncadenadaSinComparable<V>) arreglo[i]).darElemento(j));
				}
			}
		}
		return rta;
	}
	



}
