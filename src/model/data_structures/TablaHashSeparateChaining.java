package model.data_structures;

import java.util.HashMap;
import java.util.Map;

public class TablaHashSeparateChaining<K extends Comparable<K>, V extends Comparable<V>> implements TablaSimbolos <K, V>
{

	public Object[] arreglo;
	public int tamaño, contador, sigPrimoTamaño;
	
	
	public TablaHashSeparateChaining() 
	{
		tamaño = 70051;
		arreglo = new Object[tamaño];
		for (int i = 0; i < arreglo.length; i++) 
		{
			arreglo[i] = new ListaEncadenada<V>();
		}
		sigPrimoTamaño = siguientePrimo(tamaño);
	}
	
	public void reHash()
	{
	}
	
	public int funcionHash(String llaveACambiar)
	{
		int rta = llaveACambiar.hashCode();
		rta = ((rta*darNumeroAlAzar()+ darNumeroAlAzar())% sigPrimoTamaño)%tamaño;
		return rta;
	}
	
	public int siguientePrimo(int num) 
	{
		num++;
		for (int i = 2; i < num; i++) 
		{
			if(num%i == 0) 
			{
				num++;
				i=2;
			} else 
			{
				continue;
			}
		}
		return num;
	}
	   
	public int darNumeroAlAzar()
    { 
        int max = sigPrimoTamaño; 
        int min = 1; 
        int range = max - min + 1; 
        int rta = 0;
  
        for (int i = 0; i < sigPrimoTamaño; i++) 
        { 
            rta = (int)(Math.random() * range) + min; 
        } 
       return rta;
    } 
	
	@Override
	public void put(K llave, V valor) 
	{
		int pos = funcionHash((String) llave);
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[pos];
		listaAct.agregarAlPrincipio(valor);
	}
	

	@Override
	public ListaEncadenada<V> get(K llave) 
	{
		ListaEncadenada<V> rta = null;
		int pos = funcionHash((String) llave);
		@SuppressWarnings("unchecked")
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[pos];
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
			int pos = funcionHash((String) llave);
			ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[pos];
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
		int pos = funcionHash((String) llave);
		ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[pos];
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
		for (int i = 0; i < arreglo.length; i++) 
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
		for (int i = 0; i < arreglo.length; i++) 
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
		for (int i = 0; i < arreglo.length; i++) 
		{
			//No se como retornar todas las llaves solamente, tocaría llevar un registro de ellas, porque a todas las llaves se les aplica la funcionHash y no creo que se pueda hacer la inversa a esa
		}
		return rta;
	}

	@Override
	public ListaEncadenada<V> valueSet() 
	{
		ListaEncadenada<V> rta = new ListaEncadenada<V>();
		for (int i = 0; i < arreglo.length; i++) 
		{
			ListaEncadenada<V> listaAct = (ListaEncadenada<V>) arreglo[i];  
			if(listaAct.darPrimerElemento()!=null)
			{
				rta.agregarAlPrincipio(this.get(i));
			}
		}
		return rta;
	}

}
