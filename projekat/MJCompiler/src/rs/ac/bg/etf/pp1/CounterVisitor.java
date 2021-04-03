package rs.ac.bg.etf.pp1;


import rs.ac.bg.etf.pp1.ast.MyFormParsListOneTwo;
import rs.ac.bg.etf.pp1.ast.MyVarDeclaration;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {

	protected int count;
	
	public int getCount(){
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor{
	
		public void visit(MyFormParsListOneTwo formParamDecl){
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor{
		
		public void visit(MyVarDeclaration varDecl){
			count++;
		}
	}
	
	
}
