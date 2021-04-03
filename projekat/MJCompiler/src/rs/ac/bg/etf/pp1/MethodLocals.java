package rs.ac.bg.etf.pp1;

import java.util.Collection;
import java.util.LinkedList;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class MethodLocals extends SymbolDataStructure {

	LinkedList<Obj> locals;
	
	public MethodLocals() {
		locals = new LinkedList<Obj>();
	}
	
	@Override
	public Obj searchKey(String key) {
		int i = 0;
		Obj  localNode = Tab.noObj;
		while(!locals.isEmpty()) {
			  localNode = locals.get(i);
			i++;
			if(localNode.getName().equals(key)) {
				return Tab.noObj;
			}
		}
		return localNode;
	}

	@Override
	public boolean deleteKey(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertKey(Obj node) {
		Obj search = Tab.noObj;
		search = searchKey(node.getName());
		if(search.equals(Tab.noObj)) {
			return false;
		}
		else {
			locals.add(node);
			return true;
		}
	}

	@Override
	public Collection<Obj> symbols() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numSymbols() {
		// TODO Auto-generated method stub
		return 0;
	}

}
