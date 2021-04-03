package rs.ac.bg.etf.pp1;

import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.LinkedList;
import java.util.Stack;


import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;

public class CodeGenerator extends VisitorAdaptor {


	private int mainPc;
	//Condition
	private Stack<LinkedList<Integer>> falseJumpToElseOrNextCond = new Stack<LinkedList<Integer>>();
	private Stack<LinkedList<Integer>> falseJumpToStatement = new Stack<LinkedList<Integer>>();
	//forStatement
	private LinkedList<Integer> forStatementConditionBeginningAddressesList = new LinkedList<Integer>();
	private LinkedList<Integer> forStatementDesignatorStatementBeginningAddressList = new LinkedList<Integer>();
	private LinkedList<Integer> breakStatementfalseJumpAddress = new LinkedList<Integer>();
	private LinkedList<Integer> continueStatementfalseJumpAddress = new LinkedList<Integer>();
	//foreachStatement
	private LinkedList<Integer> foreachFalseJumptoEndList = new LinkedList<Integer>();
	private LinkedList<Integer> foreachStartingAddress = new LinkedList<Integer>();
	private Obj foreachIdentObj = null;
	
	public int getMainPc(){
		return mainPc;
	}

	public void visit(ProgName progName) {
		Obj ord = Tab.find("ord");
		ord.setAdr(Code.pc);
		Code.put(Code.return_);
		Obj chr = Tab.find("chr");
		chr.setAdr(Code.pc);
		Code.put(Code.return_);
		Obj len = Tab.find("len");
		len.setAdr(Code.pc);
		Code.put(Code.arraylength);
		Code.put(Code.return_);
	}
	
	//MethodDeclaration
	public void visit(MyMethodDeclTypesType methodDeclTypeType) {
		MyMethodDecl methodDecl = (MyMethodDecl) methodDeclTypeType.getParent();
		VarCounter varCounter = new VarCounter();
		FormParamCounter formParCounter = new FormParamCounter();
		methodDecl.traverseTopDown(varCounter);
		methodDecl.traverseTopDown(formParCounter);

		int formParsNumber = formParCounter.getCount();
		int localVarsNumber = varCounter.getCount();
		
		methodDeclTypeType.obj.setAdr(Code.pc);//postavi adresu funkcije
		//enter b1,b2
		Code.put(Code.enter);
		Code.put(formParsNumber);
		Code.put(formParsNumber + localVarsNumber); 
	}

	public void visit(MyMethodDeclTypesTypeVoid methodDeclTypeVoid) {
		MyMethodDecl methodDecl = (MyMethodDecl) methodDeclTypeVoid.getParent();
		if(methodDecl.getMethodName().equals("main") || methodDecl.getMethodName().equals("Main")) {
			mainPc = Code.pc;
		}

		VarCounter varCounter = new VarCounter();
		FormParamCounter formParCounter = new FormParamCounter();

		methodDecl.traverseTopDown(varCounter);
		methodDecl.traverseTopDown(formParCounter);

		int formParsNumber = formParCounter.getCount();
		int localVarsNumber = varCounter.getCount();
		
		methodDeclTypeVoid.obj.setAdr(Code.pc);//postavi adresu funkcije
		//enter b1,b2
		Code.put(Code.enter);
		Code.put(formParsNumber);
		Code.put(formParsNumber + localVarsNumber); 
	}

	public void visit(MyMethodDecl methodDecl) {
		if(methodDecl.getMethodDeclTypes() instanceof MyMethodDeclTypesType) {
			Code.put(Code.trap);
			Code.put(1); //argument za trap - ispisuje poruku o vrsti greske
		}
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	//Statement ::= print 
	public void visit(MyPrintStatement printStatement) {
		Obj exprObj = printStatement.getExpr().obj;
		if(exprObj.getType().getKind() == Struct.Array) {
			if(exprObj.getType().getElemType().getKind() == Struct.Int) {
				if(printStatement.getOptNumConst() instanceof NoMyOptNumConst) {
					Code.loadConst(5);
				}
				else {
					MyOptNumConst numConst = (MyOptNumConst) printStatement.getOptNumConst();
					Code.loadConst(numConst.getN1().intValue());
				}
				Code.put(Code.print);
			}
			else {
				if(printStatement.getOptNumConst() instanceof NoMyOptNumConst) {
					Code.loadConst(1);
				}
				else {
					MyOptNumConst numConst = (MyOptNumConst) printStatement.getOptNumConst();
					Code.loadConst(numConst.getN1().intValue());
				}
				Code.put(Code.bprint);
			}
		}
		else {
			if(printStatement.getExpr().obj.getType().getKind() == Struct.Int ) {
				if(printStatement.getOptNumConst() instanceof NoMyOptNumConst) {
					Code.loadConst(5);
				}
				else {
					MyOptNumConst numConst = (MyOptNumConst) printStatement.getOptNumConst();
					Code.loadConst(numConst.getN1().intValue());
				}
				Code.put(Code.print);
			}
			else {
				if(printStatement.getOptNumConst() instanceof NoMyOptNumConst) {
					Code.loadConst(1);
				}
				else {
					MyOptNumConst numConst = (MyOptNumConst) printStatement.getOptNumConst();
					Code.loadConst(numConst.getN1().intValue());
				}
				Code.put(Code.bprint);
			}
		}

	}

	//Statement ::= read(Designator);

	public void visit(MyReadStatement readStatement) {
		Designator designator = readStatement.getDesignator();
		if(designator.obj.getType().getKind() == Struct.Char) {
			Code.put(Code.bread);
		}
		else {
			Code.put(Code.read);
		}
		
		Code.store(designator.obj);
	}


	//DesignatorStatement ::= Designator INC 

	public void visit(MyDesigStateInc designatorInc) {
		DesignatorStatement designatorStatement = (DesignatorStatement) designatorInc.getParent();
		Obj designatorObj = designatorStatement.getDesignator().obj;
		if(designatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorObj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(designatorObj);
	}

	//DesignatorStatement ::= Designator DEC

	public void visit(MyDesigStateDec designatorDec) {
		DesignatorStatement designatorStatement = (DesignatorStatement) designatorDec.getParent();
		Obj designatorObj = designatorStatement.getDesignator().obj;
		if(designatorObj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(designatorObj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(designatorObj);

	}

	//DesignatorStatement ::= Designator Assignop Expr

	public void visit(MyDesigSteteAssignOpExpr assign) {
		DesignatorStatement designatorStatement = (DesignatorStatement)assign.getParent();
		Obj designatorObj = designatorStatement.getDesignator().obj;
		if(assign.getAssignop() instanceof MyAssignopRight) {
			String assignOperation = assign.getAssignop().obj.getName();
			switch(assignOperation) {
			case "*=": Code.put(Code.mul);
			break;

			case "/=": Code.put(Code.div);
			break;

			case "%=": Code.put(Code.rem);
			break;

			case "+=": Code.put(Code.add);
			break;

			case "-=": Code.put(Code.sub);
			break;
			}
		}
		Code.store(designatorObj);
	}
	
	public void visit(MyAssignopRight assign) {//koristi se da uradi dup i Code.load(designator) da bi na steku imali adr index niz[index]
			                                   //pre nego sto se obradi Expr sa desne strane i stavi svoju vrednost na stek 
			if(assign.getParent() instanceof MyDesigSteteAssignOpExpr) {
				MyDesigSteteAssignOpExpr designatorAssignStatement = (MyDesigSteteAssignOpExpr) assign.getParent();
				if(designatorAssignStatement.getParent() instanceof DesignatorStatement) {
					DesignatorStatement ds = (DesignatorStatement) designatorAssignStatement.getParent();
					Designator d = (Designator) ds.getDesignator();
					if(d.obj.getKind() == Obj.Elem) {
						Code.put(Code.dup2);
					}
					Code.load(d.obj);
				}
			}
	}

	//Designator ::= IDENT MulIdentOrExpr
	public void visit(Loperation lsqure) {//Stavlja adresu Designatora koji je niz - koristi se i u izrazima i u dodeli i u ++ i -- iskazima
		//Designator designator = (Designator) lsqure.getParent().getParent().getParent();
		//Obj designatorObj = designator.obj;
		//Code.load(designatorObj);//ucitaj pocetnu adresu niza sa hipa
		//designator.obj = new Obj(Obj.Elem,designator.obj.getName(),designator.obj.getType().getElemType());
		Code.load(lsqure.obj);
	} 


	//Expr
	public void visit(MyFactorNum factorNum) {
		Code.load(factorNum.obj);
	}

	public void visit(MyFactorChar factorChar) {
		Code.load(factorChar.obj);
	}

	public void visit(MyFactorBool factorBool) {
		Code.load(factorBool.obj);
	}

	public void visit(MyFactorNew factorNew) {
		Code.put(Code.newarray);
		if(factorNew.getType().struct.equals(Tab.intType)) {
			Code.put(1);
		}
		else {
			Code.put(0);
		}
	}

	public void visit(MyFactor factorDesignator) {
		factorDesignator.obj = factorDesignator.getDesignator().obj;
		if(factorDesignator.obj.getKind() == Obj.Elem) { // Za slucaj kada imamo niz[Expr] = Expr duplirati adr i index na steku
			if(factorDesignator.getParent() instanceof FactTerm) {
				FactTerm ft = (FactTerm) factorDesignator.getParent();
				if(ft.getParent() instanceof TermExpr) {
					TermExpr te = (TermExpr) ft.getParent();
					if(te.getParent() instanceof MyExpr) {
						Code.put(Code.dup2);
					}
				}
			}
		}
		if (factorDesignator.getActParsOptOpt() instanceof NoMyActParsOptOpt) {
			Code.load(factorDesignator.obj);
		} else {
			Code.put(Code.call);
			Code.put2(factorDesignator.obj.getAdr() - Code.pc + 1);
		}
	}


	public void visit(MulTerm mulTerm) {
		String mulOperation = mulTerm.getMulop().obj.getName();
		switch(mulOperation) {
		case "*": Code.put(Code.mul);
		break;

		case "/": Code.put(Code.div);
		break;

		case "%": Code.put(Code.rem);
		break;
		}
	}

	public void visit(MinusTermExpr minusTermExpr) {
		Code.put(Code.neg);
	}
	
	public void visit(AddExpr addExpr) {
		String addOperation = addExpr.getAddop().obj.getName();
		switch(addOperation) {
		case "+": Code.put(Code.add);
		break; 

		case "-": Code.put(Code.sub);
		break;
		}
	}

	public void visit(MyExpr expr) {
		Obj leftOperand = expr.getLeftExpr().obj;
		String operationName = expr.getRightOp().obj.getName();

		switch(operationName) {
		case "*=": Code.put(Code.mul);
		break;

		case "/=": Code.put(Code.div);
		break;

		case "%=": Code.put(Code.rem);
		break;

		case "+=": Code.put(Code.add);
		break;

		case "-=": Code.put(Code.sub);
		break;
		}

		if(leftOperand.getKind() == Obj.Elem) {
		//if(leftOperand.getType().getKind() == Struct.Array) {
			Code.put(Code.dup_x2);
			leftOperand = new Obj(Obj.Elem,leftOperand.getName(),leftOperand.getType());
		}
		else {
			Code.put(Code.dup);
		}
		Code.store(leftOperand);
	}

	//Method Call - from statement - Statement ::= Designator ActParsOpt

	public void visit(MyDesigStateActParsList functionCall) {
		Code.put(Code.call);
		int offset = functionCall.obj.getAdr() - Code.pc + 1;
		Code.put2(offset);
	}
	
	
	public void visit(MyReturnStatement returnStatement) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	// Condtition
	
	public void visit(MyCondFactExorRelop condFact) {
		String relopName = condFact.getRelop().obj.getName();
		switch(relopName) {
		case "==": Code.putFalseJump(Code.eq, 0);
			break;
		case "!=": Code.putFalseJump(Code.ne, 0);
		break;
		case ">": Code.putFalseJump(Code.gt, 0);
		break;
		case ">=": Code.putFalseJump(Code.ge, 0);
		break;
		case "<": Code.putFalseJump(Code.lt, 0);
		break;
		case "<=": Code.putFalseJump(Code.le, 0);
		break;
		}
		
		int adr = Code.pc - 2;
		LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
		falseJumpToElselist.push(adr);
	}
	
	public void visit(MyCondFactExpr condFact) {
		Code.loadConst(0);
		Code.putFalseJump(Code.ne, 0);
		
		int adr = Code.pc - 2;
		LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
		falseJumpToElselist.push(adr);
	}
	
	public void visit(MyConditionNonRecursive condition) {
		if(condition.getParent() instanceof MyConditionRecursive) {// nije koreni
			Code.putJump(Code.pc-1);
			int adr = Code.pc - 2;
			LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
			falseJumpToStatementlist.push(adr);
			
			LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
			while(!falseJumpToElselist.isEmpty()) {
				Integer adrToBackpatch = falseJumpToElselist.pop();
				Code.fixup(adrToBackpatch.intValue());
			}
			
		}
	}
	
	public void visit(MyConditionRecursive condition) {
		if(condition.getParent() instanceof MyConditionRecursive) {// nije koreni
			Code.putJump(Code.pc-1);
			int adr = Code.pc - 2;
			LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
			falseJumpToStatementlist.push(adr);
			
			LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
			while(!falseJumpToElselist.isEmpty()) {
				Integer adrToBackpatch = falseJumpToElselist.pop();
				Code.fixup(adrToBackpatch.intValue());
			}
			
		}
	}
	
	// Statement ::= IfStatement
	
	public void visit(LBracketIf ifStatementLBracket) {
		LinkedList<Integer> falseJumptoElseList = new LinkedList<Integer>();
		LinkedList<Integer> falseJumptoStatementList = new LinkedList<Integer>();
		falseJumpToElseOrNextCond.push(falseJumptoElseList);
		falseJumpToStatement.push(falseJumptoStatementList);
	}

	public void visit(IfStatement IfStatement) {
		LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
		while(!falseJumpToStatementlist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToStatementlist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}
	}
	
	public void visit(ElseStat elseStatement) {
		Code.putJump(Code.pc-1);
		LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
		int adr = Code.pc - 2;
		falseJumpToStatementlist.push(adr);
		
		LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
		while(!falseJumpToElselist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToElselist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}
	}
	
	public void visit(NoMyElseStatementOpt noElseStatement) {
		LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
		while(!falseJumpToElselist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToElselist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}
	}

	public void visit(MyIfStatement endOfIfStatement) { //cvor koji se obilazi na kraju kod If iskaza
														// postavlja odredisnu adresu u skoku jmp na pocetku else bloka
														// i skida sa oba steka po jednu listu adresa za taj if
		LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
		if(!falseJumpToStatementlist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToStatementlist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}

		falseJumpToElseOrNextCond.pop();
		falseJumpToStatement.pop();
	}
	
	//forStatement
	
	public void visit(LBracketFor forStatementLBracket) {
		LinkedList<Integer> falseJumptoElseList = new LinkedList<Integer>();
		LinkedList<Integer> falseJumptoStatementList = new LinkedList<Integer>();
		falseJumpToElseOrNextCond.push(falseJumptoElseList);
		falseJumpToStatement.push(falseJumptoStatementList);
	}
	
	public void visit(ConditionFor contition) {
		Integer forStatementConditionBebinningAddress = new Integer(Code.pc);
		forStatementConditionBeginningAddressesList.push(forStatementConditionBebinningAddress);
	}
	
	
	public void visit(DesigStateStart designatorStatementStart) {
		Code.putJump(Code.pc-1);
		LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
		int adr = Code.pc - 2;
		falseJumpToStatementlist.push(adr);
		
		Integer forStatementDesignatorBeginningAddress = new Integer(Code.pc);
		forStatementDesignatorStatementBeginningAddressList.push(forStatementDesignatorBeginningAddress);
	}

	public void visit(DesigStateEnd designatorStatementEnd) {
		Integer conditionBeginningAddress =	forStatementConditionBeginningAddressesList.pop();
		int adr = conditionBeginningAddress.intValue();
		Code.putJump(adr);
	}
	
	public void visit(ForStatement forStatement) {
		LinkedList<Integer> falseJumpToStatementlist = falseJumpToStatement.peek();
		while(!falseJumpToStatementlist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToStatementlist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}
	}
	
	
	
	public void visit(MyForStatement forStatementEnd) {
		if(!continueStatementfalseJumpAddress.isEmpty()) {
			Integer continueStatementAddress = continueStatementfalseJumpAddress.pop();
			int addr = continueStatementAddress.intValue();
			Code.fixup(addr);
		}
		
			Integer forStatementDesignatorBeginningAddress = forStatementDesignatorStatementBeginningAddressList.pop();
			int adr = forStatementDesignatorBeginningAddress.intValue();
			Code.putJump(adr);
		
		LinkedList<Integer> falseJumpToElselist = falseJumpToElseOrNextCond.peek();
		while(!falseJumpToElselist.isEmpty()) {
			Integer adrToBackpatch = falseJumpToElselist.pop();
			Code.fixup(adrToBackpatch.intValue());
		}
		
		if(!breakStatementfalseJumpAddress.isEmpty()) {
			Integer breakStatementAddress = breakStatementfalseJumpAddress.pop();
			int addr = breakStatementAddress.intValue();
			Code.fixup(addr);
		}
		
		falseJumpToElseOrNextCond.pop();
		falseJumpToStatement.pop();
	}
	
	//break statement
	
	public void visit(MyBreakStatement breakStatement) {
		Code.putJump(Code.pc-1);
		Integer breakStatementAddress = new Integer(Code.pc - 2);
		breakStatementfalseJumpAddress.push(breakStatementAddress);
	}
	
	//continue Statement
	
	public void visit(MyContinueStatement conitnueStatement) {
		Code.putJump(Code.pc-1);
		Integer continueStatementAddress = new Integer(Code.pc - 2);
		continueStatementfalseJumpAddress.push(continueStatementAddress);
	}
	
	// foreach Statement
	
	public void visit(ForeachIdent ident) {
		foreachIdentObj = ident.obj;
		if(foreachIdentObj == null) {
			System.out.println("NULL");
		}
		Code.loadConst(0);
	}
	
	public void visit(DesigStart desigStart) {
		int adr = Code.pc;
		foreachStartingAddress.push(new Integer(adr));
		Code.put(Code.dup);
	}
	
	public void visit(DesigEnd desigEnd) {
		MyForEachStatement foreachStatement = (MyForEachStatement) desigEnd.getParent();
		Designator designator = (Designator) foreachStatement.getDesignator();
		Obj designaotrObj = designator.obj;
		Code.load(designaotrObj);
		designaotrObj = new Obj(Obj.Elem,designaotrObj.getName(),designaotrObj.getType().getElemType());
		Code.put(Code.dup_x2);
		Code.put(Code.arraylength);
		Code.putFalseJump(Code.lt, 0);
		int adr = Code.pc - 2;
		foreachFalseJumptoEndList.push(new Integer(adr));
		Code.put(Code.dup_x1);
		Code.load(designaotrObj);
		Code.store(foreachIdentObj);
		Code.loadConst(1);
		Code.put(Code.add);
	}
	
	public void visit(MyForEachStatement foreachEnd) {
		Integer StartingAddress = foreachStartingAddress.pop();
		int adr = StartingAddress.intValue();
		Code.putJump(adr);
		Integer backPatchAddress = foreachFalseJumptoEndList.pop();
		int addr = backPatchAddress.intValue();
		Code.fixup(addr);
		Code.put(Code.pop);
		Code.put(Code.pop);       
		if(!breakStatementfalseJumpAddress.isEmpty()) {
			Integer breakStatementAddress = breakStatementfalseJumpAddress.pop();
			int breaJumpAddress = breakStatementAddress.intValue();
			Code.fixup(breaJumpAddress);
		}
	}
	
	
}
