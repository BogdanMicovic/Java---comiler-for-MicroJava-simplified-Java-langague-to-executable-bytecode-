package rs.ac.bg.etf.pp1;

import java.util.LinkedList;

public class ParametersStack {

	
	private LinkedList<ParametersList> parametersStack;
	
	public ParametersStack() {
		parametersStack = new LinkedList<ParametersList>();
	}
	
	public void addList(ParametersList list) {
		parametersStack.add(list);
	}
	
	public ParametersList get() {
		return parametersStack.removeFirst();
	}
	
}
