package model.data_structures;

import java.util.HashMap;
import java.util.Map;

import clases.Pelicula;
import model.data_structures.ListaEncadenada.Nodo;

public class TablaHashSeparateChaining<K extends Comparable<K>, V> implements TablaSimbolos <K, V>
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
	
	public void reHash()
	{
	}
	
	@Override
	public void put(K llave, V valor) 
	{
		ListaEncadenadaSinComparable<V> listaEntrante = (ListaEncadenadaSinComparable<V>) valor;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[(int) llave];
		if(listaAct.darPrimerElemento() !=null)
		{
			((ListaEncadenadaSinComparable<V>) arreglo[(int) llave]).agregarAlPrincipio(listaEntrante.darPrimerElemento());
			Pelicula peliEntrante = (Pelicula) listaEntrante.darPrimerElemento(); 
			System.out.print("Colision, tamaño nuevo:" + ((ListaEncadenadaSinComparable<V>) arreglo[(int) llave]).contarDatos()+ "  "); 
		}
		else
		{
			arreglo[(int) llave] = (V) listaEntrante; 
		}
		
	}
	
	@Override
	public V get(K llave) 
	{
		ListaEncadenadaSinComparable<V> rta = null;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[(int) llave];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct;
		}
		return (V) rta;
	}

	@Override
	public V remove(K llave) 
	{
		ListaEncadenadaSinComparable<V> rta = null;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[(int) llave];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct;
			arreglo[(int) llave] = (V) new ListaEncadenadaSinComparable<V>();  
		}
		return (V) rta;
	}

	@Override
	public boolean contains(K llave) 
	{
		boolean rta = false;
		ListaEncadenadaSinComparable<V> listaAct = (ListaEncadenadaSinComparable<V>) arreglo[(int) llave];
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
	public ListaEncadenada<K> keySet() 
	{
		ListaEncadenada<K> rta = new ListaEncadenada<K>();
		for (int i = 0; i < tamaño; i++) 
		{
			ListaEncadenadaSinComparable<V> listaAct= (ListaEncadenadaSinComparable<V>) arreglo[i];
			if(listaAct.darPrimerElemento()!=null) 
			{
				Pelicula peli = (Pelicula)listaAct.darPrimerElemento();
				peli.darLlave();
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
			NodoHash<K, V> nodoAct = (NodoHash<K, V>) arreglo[i];
			ListaEncadenadaSinComparable<V> listaValores = (ListaEncadenadaSinComparable<V>) nodoAct.getValue();
			if(listaValores.contarDatos()!=0)
			{
				for (int j = 0; j < listaValores.contarDatos(); j++) 
				{
					rta.agregarAlPrincipio(listaValores.darElemento(i));
				}
			}
		}
		return rta;
	}



}
