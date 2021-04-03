package rs.ac.bg.etf.pp1;

import java.util.LinkedList;

import rs.etf.pp1.symboltable.concepts.Obj;

public class ParametersList {

	private LinkedList<Obj> parametersList;
	
	public ParametersList() {
		parametersList = new LinkedList<Obj>();
	}
	
	public void add(Obj obj) {
		parametersList.add(obj);
	}
	
	public Obj get() {
		return parametersList.removeFirst();
	}
	
	
}
