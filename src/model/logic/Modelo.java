package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Queue;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import clases.Hash;
import clases.Pelicula;
import clases.ShellSort;
import controller.Controller;
import model.data_structures.Accident;
import model.data_structures.ArregloDinamico;
import model.data_structures.BST;
import model.data_structures.IListaEncadenada;
import model.data_structures.ListaEncadenada;
import model.data_structures.ListaEncadenada.Nodo;
import model.data_structures.ListaEncadenadaSinComparable;
import model.data_structures.NodoHash;
import model.data_structures.RedBlackBST;
import model.data_structures.TablaHashSeparateChaining;
import model.data_structures.TablaSimbolos;
import model.data_structures.tablaHashLinearProbing;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	private RedBlackBST<Date,ArrayList<Accident>> rbt = new RedBlackBST<Date, ArrayList<Accident>>();
	
	private BST<Date, ArrayList<Accident>> bst = new BST<Date, ArrayList<Accident>>();
	
	private static String file = "us_accidents_dis_2017.csv";
	
	public void loadAccidents()
	{
		int total = 0;
		
		int notLoaded = 0;
		
		Path path = FileSystems.getDefault().getPath("data/", file);
		Reader reader;
		
		try 
		{
			reader = Files.newBufferedReader(path);
			
			CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
				 
			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
			
		    String[] line;
		    while ((line = csvReader.readNext()) != null) 
		    {
		    	if(line[0].equals("") || line[3].equals("")|| line[4].equals(""))
		    	{
		    		notLoaded++;
		    	}
		    	else
		    	{
			    	Accident acc = new Accident(line[0], Integer.parseInt(line[3]), line[4]);
			    	ArrayList<Accident> tmp = new ArrayList<Accident>();
			        if(rbt.contains(acc.getDate()))
			        {
			        	rbt.get(acc.getDate()).add(acc);
			        	bst.get(acc.getDate()).add(acc);
			        }
			        else
			        {
			        	tmp.add(acc);
			        	rbt.put(acc.getDate(), tmp);
			        	bst.put(acc.getDate(), tmp);
			        }
			        total++;
		    	}
		    	
		    }
		    reader.close();
		    csvReader.close();
		    
		    System.out.println("Total accidentes cargados: " + total);
		    System.out.println("Total accidentes no cargados: " + notLoaded);
		    
		    System.out.println("Total de llaves cargadas RBT: " + rbt.size());
		    System.out.println("Altura del RBT: " + rbt.height());
		    System.out.println("Valor mínimo RBT: " + rbt.min() + " y valor máximo RBT: " + rbt.max());
		    
		    System.out.println("Total de llaves cargadas BST: " + bst.size());
		    System.out.println("Altura del BST: " + bst.height());
		    System.out.println("Valor mínimo BST: " + bst.min() + " y valor máximo BST: " + bst.max());
		    
		    
		} 
		catch (IOException | NumberFormatException | CsvValidationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int[] SearchByDateRBT(Date search)
	{
			
		int[] ans = new int[5];
		
		ArrayList<Accident> list =  rbt.get(search);
		
		
		if(list != null)
		{
			ans[0] = list.size();
			
			for (Accident a : list) 
			{
				ans[a.getSeverity()] += 1;
			}
		}
		
		return ans;
	}
	
	public int[] SearchByDateBST(Date search)
	{
			
		int[] ans = new int[5];
		
		ArrayList<Accident> list =  bst.get(search);
		
		
		if(list != null)
		{
			ans[0] = list.size();
			
			for (Accident a : list) 
			{
				ans[a.getSeverity()] += 1;
			}
		}
		
		return ans;
	}
	
}
