package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Obj;

public class ExprOperand {

	public String operationName;
	public Obj operand;
	
	public ExprOperand(String operationName, Obj operand) {
		this.operationName = operationName;
		this.operand = operand;
	}
	
}
