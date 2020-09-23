package model.data_structures;

import java.util.HashMap;
import java.util.Map;

public class TablaHashSeparateChaining<K extends Comparable<K>, V extends Comparable<V>> implements TablaSimbolos <K, V>
{

	public Object[] arreglo;
	public int tamaño;
	
	/**
	 * 
	 * @param El tamaño debe ser un número primo que permita que haya un factor de carga 5.0, 
	 * es decir, para la lista de 300mil elementos sería minimo de 60mil el tamaño
	 */
	public TablaHashSeparateChaining(int pTamaño) 
	{
		tamaño = pTamaño;
		arreglo = new Object[tamaño];
		for (int i = 0; i < tamaño; i++) 
		{
			arreglo[i] = new ListaEncadenada<NodoHash<K,V>>();
		}
	}
	
	public void reHash()
	{
	}
	
	@Override
	public void put(K llave, V valor) 
	{
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[(int) llave];
		listaAct.agregarAlPrincipio(valor);
	}
	

	@Override
	public ListaEncadenada<V> get(K llave) 
	{
		ListaEncadenada<V> rta = null;
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[(int) llave];
		if(listaAct.darPrimerElemento()!=null)
		{
			rta = listaAct;
		}
		return rta;
	}

	@Override
	public ListaEncadenada<V> remove(K llave) 
	{
		ListaEncadenada<V> rta = null;
		if(this.contains(llave))
		{
			rta = this.get(llave);
			ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[(int) llave];
			listaAct = new ListaEncadenada<V>();
		}
		else
		{
		}
		return rta; 
	}

	@Override
	public boolean contains(K llave) 
	{
		boolean rta = false;
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[(int) llave];
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
			ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[i];  
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
			ListaEncadenada<V> listaNodos = (ListaEncadenada<V>) arreglo[i]; 
			NodoHash<K, V> x = (NodoHash<K, V>) listaNodos.darPrimerElemento();
			if(x!=null) 
			{
				rta.agregarAlFinal(x.getKey());
			}	
		}
		return rta;
	}

	@Override
	public ListaEncadenada<V> valueSet() 
	{
		ListaEncadenada<V> rta = new ListaEncadenada<V>();
		for (int i = 0; i < tamaño; i++) 
		{
			ListaEncadenada<V> listaNodos = (ListaEncadenada<V>) arreglo[i]; 
			for (int j = 0; j < listaNodos.contarDatos(); j++) 
			{
				NodoHash<K, V> x = (NodoHash<K, V>) listaNodos.darElemento(j);
				if(x!=null) 
				{
					rta.agregarAlFinal(x.getValue());
				}	
			}
		}
		return rta;
	}

}
