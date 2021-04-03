package rs.ac.bg.etf.pp1;


import java.util.LinkedList;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class SemanticPass extends VisitorAdaptor {

	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected = false;
	//mainFound
	boolean mainFunctionFound = false;
	// varDeclaration
	public int varDeclCount = 0;
	Struct varType;
	boolean varHasBrackets = false;
	LinkedList<VarNode> varNodes = new LinkedList<VarNode>();
	// constDeclaration
	int constAssignedType = 0;
	int constAssignedValue = 0;
	// methodDeclaration
	Obj currentMethod = null;
	int numberOfFormalParam = 0;
	boolean formalParHasBrackets = false;
	LinkedList<Obj> formalParamsList = new LinkedList<Obj>();
	SymbolDataStructure currentMethodLocals = new MethodLocals();
	// DesignatorStatement
	Struct designatorType = null;
	// MulopFactorList
	boolean isFirstFactorInMulopFact = false;
	Obj lastFactor = null;
	boolean isMulopRightBefore = false;
	// AddopTermList
	Obj lastTerm = null;
	boolean isAddopRightBefore = false;
	boolean isFirstTermInAddopTerm = false;
	// Expr
	boolean firstFactorInExpr = false;
	Obj firstFactorInExpresion = null;
	// break and contitnue statements
	LinkedList<Boolean> inForOrForeachLoop = new LinkedList<Boolean>();

	// Types comparation function
	// First parameter is any type and second is simple(basic) type
	// type(Struct.int,Struct.Char,Struct.Bool)
	public boolean compareTypes(Struct userType, Struct basicType) {
		if (basicType.getKind() == Struct.Array || userType.getKind() == Struct.Array) {
			report_error("Greska, tip koji se prosledjuje funkciji comapreTypes mora biti jedan od osnovnih", null);
			return false;
		}
		if (userType.getKind() != basicType.getKind()) {
			return false;
		} else {
			return true;
		}

	}

	public boolean compareUserTypes(Struct userType1, Struct userType2) {// ne koristiti - ista kao funkcija iznad
		return compareTypes(userType1, userType2);
	}

	public boolean compatabileTypes(Obj object1, Obj object2) {
		if (object1.getType().getKind() != Struct.Array && object2.getType().getKind() != Struct.Array) {
			return compareTypes(object1.getType(), object2.getType());
		}
		boolean object1IsReference = false;
		boolean object2IsReference = false;
		if (object1.getType().getKind() == Struct.Array) {
			object1IsReference = true;
		}
		if (object2.getType().getKind() == Struct.Array) {
			object2IsReference = true;
		}
		if (object1IsReference == true && object2IsReference == true) {
			return true;
		}
		if (object1IsReference == true && compareTypes(object2.getType(), Tab.nullType)) {
			return true;
		}
		if (object2IsReference == true && compareTypes(object1.getType(), Tab.nullType)) {
			return true;
		}
		return false;
	}

	// Report Info and Error functions
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public boolean passed() {
		return !errorDetected;
	}

	// VarDeclaration: deklaracije globalnih promenljivih - unos u TS ako vec ne
	// postoje u njoj
	public void visit(MyVarDecl varDecl) {

		varType = varDecl.getType().struct;

		while (!varNodes.isEmpty()) {
			VarNode varNode = varNodes.remove();
			Obj obj;
			if (varNode.hasBrackets == false) {
				obj = Tab.insert(Obj.Var, varNode.varName, varType);
				
			} else {
				obj = Tab.insert(Obj.Var, varNode.varName, new Struct(Struct.Array, varType));
			}
			if(obj.equals(Tab.noObj)) {
				report_error("Greska, deklarisana promenljiva "+varNode.varName+" vec postoji", varDecl);
			}

		}

	}

	public void visit(MyVarDeclaration varDeclaration) {
		varDeclCount++;
		report_info("Deklarisana promenljiva " + varDeclaration.getVarName(), varDeclaration);
		varNodes.add(new VarNode(varHasBrackets, varDeclaration.getVarName()));
		varHasBrackets = false;
	}

	public void visit(MySquareBrackets squareBrackets) {
		varHasBrackets = true;
	}

	// ConstDecl
	public void visit(ConstantDeclaration constantDeclaration) {
		ConstantDeclaration constDe = constantDeclaration;
		MyConstantDeclarationsRecursive myConstDeRe = null;
		ConstDecl constDecl = null;
		if (constDe.getParent().getParent() instanceof MyConstantDeclarationsRecursive) {
			myConstDeRe = (MyConstantDeclarationsRecursive) constDe.getParent().getParent();
			while (myConstDeRe.getParent() instanceof MyConstantDeclarationsRecursive) {
				myConstDeRe = (MyConstantDeclarationsRecursive) myConstDeRe.getParent();
			}
			constDecl = (ConstDecl) myConstDeRe.getParent();
		} else {
			constDecl = (ConstDecl) constDe.getParent().getParent();
		}

		Struct constType = constDecl.getType().struct;
		String constName = constantDeclaration.getConstName();
		if (constType.getKind() == constAssignedType) {
			report_info("Deklarisana konstanta " + constName, constantDeclaration);
			Obj constObj = Tab.insert(Obj.Con, constName, constType);
			if(constObj.equals(Tab.noObj)) {
				report_error("Greska, deklarisana konstanta vec postoji u tabeli simbola", constantDeclaration);
			}
			constObj.setAdr(constAssignedValue);
		} else {
			report_error("Greska, tip neterminala mora biti ekvivalentan tipu Type kod deklaracije konstanti ",
					constantDeclaration);
		}
		constAssignedType = 0;
	}

	public void visit(MyConstNum numConst) {
		constAssignedType = Struct.Int;
		constAssignedValue = numConst.getConstInt().intValue();
	}

	public void visit(MyConstChar charConst) {
		constAssignedType = Struct.Char;
		constAssignedValue = Character.getNumericValue(charConst.getConstChar());
	}

	public void visit(MyConstBool boolConst) {
		constAssignedType = Struct.Bool;
		if (boolConst.getConstBool().booleanValue() == true) {
			constAssignedValue = 1;
		} else {
			constAssignedValue = 0;
		}
	}

	// print
	public void visit(MyPrintStatement print) {
		Expr expr = print.getExpr();
		Struct exprType = expr.obj.getType();
		if (!compareTypes(exprType, Tab.intType) && !compareTypes(exprType, Tab.charType)
				&& !compareTypes(exprType, new Struct(Struct.Bool))) {
			report_error("Greska, tip izraza kod print naredbe mora biti tipa int, char ili bool ", print);
		}
	}

	// Program
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(Program program) {
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if(mainFunctionFound == false) {
			report_error("Greska, ne postoji main funkcija", null);
		}

	}

	// Type
	public void visit(MyType type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {

			report_error("Nije pronadjen tip " + type.getTypeName(), null);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
				// report_info("Pronadjen tip " + typeNode.getType().getKind(), type);
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
				type.struct = Tab.noType;
			}

		}

	}

	// MethodDecl i FormPars
	public void visit(MyMethodDeclTypesType methodDeclType) {

		MyMethodDecl methodDecl = (MyMethodDecl) methodDeclType.getParent();
		Struct methodType = methodDeclType.getType().struct;
		String methodName = methodDecl.getMethodName();
		if(methodName.equals("main") || methodName.equals("Main")) {
			mainFunctionFound = true;
		}
		currentMethod = Tab.insert(Obj.Meth, methodName, methodType);
		//if(currentMethod.equals(Tab.noObj)) {
		//	report_error("Greska, metoda "+methodName+" je vec deklarisana", methodDeclType);
		//}
		report_info("Deklarisana metoda " + currentMethod.getName(), methodDeclType);
		Tab.openScope();
		methodDeclType.obj = currentMethod;

	}

	public void visit(MyMethodDeclTypesTypeVoid methodDeclVoid) {

		MyMethodDecl methodDecl = (MyMethodDecl) methodDeclVoid.getParent();
		Struct methodType = new Struct(Struct.None);
		String methodName = methodDecl.getMethodName();
		if(methodName.equals("main") || methodName.equals("Main")) {
			mainFunctionFound = true;
		}
		currentMethod = Tab.insert(Obj.Meth, methodName, methodType);
		//if(currentMethod.equals(Tab.noObj)) {
		//	report_error("Greska, metoda "+methodName+" je vec deklarisana", methodDeclVoid);
		//}
		Tab.openScope();
		methodDeclVoid.obj = currentMethod;
	}

	public void visit(MyMethodDecl methodDecl) {
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		currentMethod = null;
		numberOfFormalParam = 0;
	}

	public void visit(MyFormParsListOneTwo methodFormPar) {
		numberOfFormalParam++;
		Obj formPar = null;
		if (formalParHasBrackets == false) {
			formPar = Tab.insert(Obj.Var, methodFormPar.getFormParName(), methodFormPar.getType().struct);
		} else {
			formPar = Tab.insert(Obj.Var, methodFormPar.getFormParName(),
					new Struct(Struct.Array, methodFormPar.getType().struct));
		}
		formPar.setFpPos(numberOfFormalParam);
		formalParamsList.add(formPar);
		formalParHasBrackets = false;

	}

	public void visit(MySqBrac sqareBrackets) {
		formalParHasBrackets = true;
	}

	// Designator
	public void visit(Designator designator) {
		Obj obj = Tab.find(designator.getDesigatorName());
		designator.obj = obj;
		if (obj.equals(Tab.noObj)) {
			report_error("Greska, promenljiva " + designator.getDesigatorName() + " nije deklarisana", designator);
		}

		if (designator.getMulIdentOrExpr() instanceof MyMMulIdentOrExprRecursive) {
			MyMMulIdentOrExprRecursive mmioer = (MyMMulIdentOrExprRecursive) designator.getMulIdentOrExpr();
			MyMulIdentOrExprOneExpr mmioeoe = (MyMulIdentOrExprOneExpr) mmioer.getMulIdentOrExprOne();
			Expr e = mmioeoe.getExpr();
			if (designator.obj.getType().getKind() != Struct.Array) {
				report_error("Greska, designator " + designator.getDesigatorName() + " mora biti niz ", designator);
			}
			if (!compareTypes(e.obj.getType(), Tab.intType)) {
				report_error("Greska, izraz kod designatora " + designator.getDesigatorName() + " mora biti tipa int",
						designator);
			}
			designator.obj = new Obj(Obj.Elem, designator.obj.getName(), designator.obj.getType().getElemType());
			Loperation loperation = mmioeoe.getLoperation();
			loperation.obj = obj;
		}
	}

	// DesignatorStatement ::= Designator (ActParsOpt)
	public void visit(MyDesigStateActParsList designatorStateActParsList) {
		DesignatorStatement desigSatement = (DesignatorStatement) designatorStateActParsList.getParent();
		Obj designatorObj = desigSatement.getDesignator().obj;
		if (!(designatorObj.getKind() == Obj.Meth)) {
			report_error("Greska, " + designatorObj.getName() + " nije globalna metoda", designatorStateActParsList);
		} else {
			report_info("Poziv metode " + designatorObj.getName(), designatorStateActParsList);
		}
		designatorStateActParsList.obj = designatorObj;
	}

	public void visit(MyActParsOpt actParsOpt) {

	}

	// ActPars ::= Expr
	public void visit(MyActParsNonRecursive actParsExpr) {
		actParsExpr.obj = actParsExpr.getExpr().obj;
	}

	// ActPars ::= ActPars COMMA Expr
	public void visit(MyActParsRecursive actPars) {

	}
	
	public void visit(MyDesigSteteAssignOpExpr assignment) {
		DesignatorStatement designatorStatement = (DesignatorStatement) assignment.getParent();
		Designator designator = designatorStatement.getDesignator();
		Obj designatorObj = designator.obj;
		Obj exprObj = assignment.getExpr().obj;
		if(designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Greska, designator sa leve strane naredbe dodele mora biti promenljiva ili element niza", assignment);
		}
		if(!compatabileTypes(exprObj, designatorObj)) {
			report_error("Greska, izraz i designator moraju biti kompatabilni kod iskaza dodele", assignment);

		}
	}

	// DesignatorStatement ::= Designator ++;

	public void visit(MyDesigStateInc desigSateInc) {
		DesignatorStatement desigSatement = (DesignatorStatement) desigSateInc.getParent();
		Obj designatorObj = desigSatement.getDesignator().obj;
		if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Greska, designator mora biti promenljiva ili element niza kod ++ naredbe ", desigSateInc);
		}
		if (!compareTypes(designatorObj.getType(), Tab.intType)) {
			report_error("Greska, designator mora biti tipa int kod ++ naredbe ", desigSateInc);
		}
	}

	// DesignatorStatement ::= Designator --;

	public void visit(MyDesigStateDec desigStateDec) {
		DesignatorStatement desigSatement = (DesignatorStatement) desigStateDec.getParent();
		Obj designatorObj = desigSatement.getDesignator().obj;
		if (designatorObj.getKind() != Obj.Var && designatorObj.getKind() != Obj.Elem) {
			report_error("Greska, designator mora biti promenljiva ili element niza kod ++ naredbe ", desigStateDec);
		}
		if (!compareTypes(designatorObj.getType(), Tab.intType)) {
			report_error("Greska, designator mora biti tipa int kod ++ naredbe ", desigStateDec);
		}
	}

	// Statement ::= break;

	public void visit(MyBreakStatement breakStatement) {
		if (inForOrForeachLoop.isEmpty()) {
			report_error("Greska, break naredba se moze koristiti samo unutar for ili foreach petlje ", breakStatement);
		}
	}

	// Statement ::= continue;
	public void visit(MyContinueStatement continueStatement) {
		if (inForOrForeachLoop.isEmpty()) {
			report_error("Greska, continue naredba se moze koristiti samo unutar for ili foreach petlje ",
					continueStatement);
		}
	}

	// Statement ::= read(Designator);
	public void visit(MyReadStatement readStatement) {
		Designator designator = readStatement.getDesignator();
		Struct designatorType = designator.obj.getType();
		if (designator.obj.getKind() != Obj.Var && designator.obj.getKind() != Obj.Elem) {
			report_error("Greska, designator mora biti promenljiva ili element niza kod read narede ", readStatement);
		}
		if (!compareTypes(designatorType, Tab.intType) && !compareTypes(designatorType, Tab.charType)
				&& !compareTypes(designatorType, new Struct(Struct.Bool))) {
			report_error("Greska, tip izraza kod print naredbe mora biti tipa int, char ili bool ", readStatement);
		}
	}

	// Expr

	// Term ::= Term Mulop Factor | Factor

	// Factor ::= NUM
	public void visit(MyFactorNum factorNum) {
		String name = factorNum.getN1().toString();
		factorNum.obj = new Obj(Obj.Con, name, Tab.intType);
		factorNum.obj.setAdr(factorNum.getN1());
		factorNum.obj.setLevel(0);
	}

	// Factor := CHAR
	public void visit(MyFactorChar factorChar) {
		String name = factorChar.getC1().toString();
		factorChar.obj = new Obj(Obj.Con, name, Tab.charType);
		factorChar.obj.setAdr(factorChar.getC1());
		factorChar.obj.setLevel(0);
	}

	// Factor ::= BOOL
	public void visit(MyFactorBool factorBool) {
		String name = factorBool.getB1().toString();
		factorBool.obj = new Obj(Obj.Con, name, new Struct(Struct.Bool));
		if (factorBool.getB1() == true) {
			factorBool.obj.setAdr(1);
		} else {
			factorBool.obj.setAdr(0);
		}
		factorBool.obj.setLevel(0);
	}

	// Factor ::= Designator ActParsOptOpt
	public void visit(MyFactor factorDesignator) {
		factorDesignator.obj = factorDesignator.getDesignator().obj;
		if (factorDesignator.getActParsOptOpt() instanceof MyActParsOptOpt) {
			if (factorDesignator.obj.getKind() != Obj.Meth) {
				report_error("Greska, " + factorDesignator.obj.getName() + " mora biti globalna metoda",
						factorDesignator);
			}
		}
	}

	// Factor ::= LBRACKET Expr RBRACKET
	public void visit(MyFactorExpr factorExpr) {
		factorExpr.obj = factorExpr.getExpr().obj;
	}

	// Factor ::= NEW Type SquareExprOpt
	public void visit(MyFactorNew factorNew) {
		if (factorNew.getSquareExprOpt() == null) {
			report_error("Greska, fale uglaste zagrade za deklaraciju niza", factorNew);
		} else {
			Obj exprObj = factorNew.getSquareExprOpt().obj;
			Struct exprType = exprObj.getType();
			if (!compareTypes(exprType, Tab.intType)) {
				report_error("Greska, tip izraza mora biti int ", factorNew);
			}
		}
		Struct arrayStruct = new Struct(Struct.Array);
		arrayStruct.setElementType(factorNew.getType().struct);
		factorNew.obj = new Obj(Obj.Var, "NoName", arrayStruct);
	}

	public void visit(MySquareExprOpt squareExpr) {
		squareExpr.obj = squareExpr.getExpr().obj;
	}

	// Term ::= Factor
	public void visit(FactTerm termFact) {
		termFact.obj = termFact.getFactor().obj;
	}

	public void visit(MulTerm mulTerm) {
		Obj factorObj = mulTerm.getFactor().obj;
		Obj termObj = mulTerm.getTerm().obj;
		if (!compareTypes(termObj.getType(), Tab.intType)) {
			report_error("Greska, term " + termObj.getName() + " mora biti tipa int", mulTerm);
		}
		if (!compareTypes(factorObj.getType(), Tab.intType)) {
			report_error("Greska, factor " + mulTerm.getFactor().obj.getName() + " mora biti tipa int", mulTerm);
		}
		mulTerm.obj = new Obj(Obj.Con, "", Tab.intType);
	}

	public void visit(TermExpr termExpr) {
		termExpr.obj = termExpr.getTerm().obj;
	}

	public void visit(MinusTermExpr minusTermExpr) {
		Obj termObj = minusTermExpr.getTerm().obj;
		if (!compareTypes(termObj.getType(), Tab.intType)) {
			report_error("Greska, term " + termObj.getName() + " mora biti tipa int", minusTermExpr);
		}
		minusTermExpr.obj = minusTermExpr.getTerm().obj;
	}

	public void visit(AddExpr addExpr) {
		Obj termObj = addExpr.getTerm().obj;
		Obj leftExprObj = addExpr.getLeftExpr().obj;
		if (!compareTypes(leftExprObj.getType(), Tab.intType)) {
			report_error("Greska, expr " + leftExprObj.getName() + " mora biti tipa int", addExpr);
		}
		if (!compareTypes(termObj.getType(), Tab.intType)) {
			report_error("Greska, term " + leftExprObj.getName() + " mora biti tipa int", addExpr);
		}
		addExpr.obj = new Obj(Obj.Con, "", Tab.intType);
	}

	public void visit(MyLeftExpr leftExpr) {
		leftExpr.obj = leftExpr.getLeftExpr().obj;
	}

	public void visit(MyExpr rightExpr) {
		Obj leftExprObj = rightExpr.getLeftExpr().obj;
		Obj rightExprObj = rightExpr.getExpr().obj;
		if (!compareTypes(leftExprObj.getType(), Tab.intType)) {
			report_error("Greska, izraz sa leve strane operatora mora biti tipa int ", rightExpr);
		}
		if (!compareTypes(rightExprObj.getType(), Tab.intType)) {
			report_error("Greska, izraz sa desne strane operatora mora biti tipa int ", rightExpr);
		}
		if (leftExprObj.getKind() != Obj.Var && leftExprObj.getKind() != Obj.Elem) {
			report_error("Greska, izraz sa leve strane operatora mora biti promenljiva ili element niza ", rightExpr);
		}
		rightExpr.obj = rightExpr.getLeftExpr().obj;
	}

	public void visit(MulopLeftMul operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "*", Tab.noType);
	}

	public void visit(MulopLeftDiv operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "/", Tab.noType);
	}

	public void visit(MulopLeftPercent operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "%", Tab.noType);
	}

	public void visit(AddopLeftPlus operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "+", Tab.noType);
	}

	public void visit(AddopLeftMinus operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "-", Tab.noType);
	}

	public void visit(PlusEqual operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "+=", Tab.noType);
	}

	public void visit(MinusEqual operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "-=", Tab.noType);
	}

	public void visit(MulEqual operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "*=", Tab.noType);
	}

	public void visit(DivEqual operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "/=", Tab.noType);
	}

	public void visit(PercentEqual operation) {
		operation.obj = new Obj(Obj.NO_VALUE, "%=", Tab.noType);
	}

	// Designator = Expr

	public void visit(MyAssignopRight assign) {
		assign.obj = assign.getRightOp().obj;
	}

	// CondFact ::= Expr | Expr Relop Expr

	public void visit(MyRelopEqual equal) {
		equal.obj = new Obj(Obj.NO_VALUE, "==", new Struct(Struct.None));
	}

	public void visit(MyRelopDifferent different) {
		different.obj = new Obj(Obj.NO_VALUE, "!=", new Struct(Struct.None));
	}

	public void visit(MyRelopBigger bigger) {
		bigger.obj = new Obj(Obj.NO_VALUE, ">", new Struct(Struct.None));
	}

	public void visit(MyRelopBiggerEq biggerEqual) {
		biggerEqual.obj = new Obj(Obj.NO_VALUE, ">=", new Struct(Struct.None));
	}

	public void visit(MyRelopLess less) {
		less.obj = new Obj(Obj.NO_VALUE, "<", new Struct(Struct.None));
	}

	public void visit(MyRelopLessEq lessEqual) {
		lessEqual.obj = new Obj(Obj.NO_VALUE, "<=", new Struct(Struct.None));
	}

	// CondFact ::= Expr
	public void visit(MyCondFactExpr condFactExpr) {
		Obj exprObj = condFactExpr.getExpr().obj;
		if (!compareTypes(exprObj.getType(), new Struct(Struct.Bool))) {
			report_error("Greska, expr " + exprObj.getName() + " mora biti tipa bool ", condFactExpr);
		}
		condFactExpr.obj = condFactExpr.getExpr().obj;
	}

	// CondFact ::= Expr Relop Expr
	public void visit(MyCondFactExorRelop condFactExprRelopExpr) {
		Expr exprLeft = condFactExprRelopExpr.getExpr();
		Expr exprRight = condFactExprRelopExpr.getExpr1();
		Obj exprLeftObj = exprLeft.obj;
		Obj exprRightObj = exprRight.obj;
		if (!compatabileTypes(exprLeftObj, exprRightObj)) {
			report_error("Greska, tipovi izraza moraju biti kompatabilni  ", condFactExprRelopExpr);
		}
		condFactExprRelopExpr.obj = new Obj(Obj.Con, "", new Struct(Struct.Bool));
	}

	// CondTerm ::= CondTerm && CondFact || CondFact

	public void visit(MyCondTermNonRecursive condTermFact) {
		condTermFact.obj = condTermFact.getCondFact().obj;
	}

	public void visit(MyCondTermRecursive condTermAndCondFact) {
		condTermAndCondFact.obj = condTermAndCondFact.getCondFact().obj;
	}

	// Condition ::= Condtidion OR CondTerm | CondTerm

	public void visit(MyConditionNonRecursive conditionCondTerm) {
		conditionCondTerm.obj = conditionCondTerm.getCondTerm().obj;
	}

	public void visit(MyConditionRecursive conditionOrCondTerm) {
		conditionOrCondTerm.obj = conditionOrCondTerm.getCondTerm().obj;
	}

	// Statement ::= return OptExpr

	public void visit(MyReturnStatement returnStatement) {
		OptExpr expr = returnStatement.getOptExpr();
		if (expr instanceof NoMyOptExpr) {
			if (!(compareTypes(currentMethod.getType(), Tab.noType))) {
				report_error("Greska, metoda treba biti deklarisana kao void ", returnStatement);
			}
		} else {
			if (!compareUserTypes(expr.obj.getType(), currentMethod.getType())) {
				report_error("Greska, tip izraza u return iskazu mora biti ekvivalentan tipu metode ", returnStatement);
			}
		}
	}

	public void visit(MyOptExpr optExpr) {
		optExpr.obj = optExpr.getExpr().obj;
	}

	// Statement ::= If (Condition) Statement ElseStatementOpt
	public void visit(MyIfStatement ifStatement) {
		Condition condition = ifStatement.getCondition();
		if (!compareTypes(condition.obj.getType(), new Struct(Struct.Bool))) {
			report_error("Greska, uslov u if naredbi mora biti tipa bool", ifStatement);
		}
	}

	// Statement ::= for(OptDesignatorStatement; OptCondition;
	// OptDesignatorStatement) Statement
	public void visit(MyForStatement forStatement) {
		OptCondition condition = forStatement.getOptCondition();
		if (condition instanceof MyOptCondition) {
			if (!compareTypes(condition.obj.getType(), new Struct(Struct.Bool))) {
				report_error("Greska, uslov u for naredbi mora biti tipa bool", forStatement);
			}
		}
		inForOrForeachLoop.pop();
	}

	public void visit(LBracketFor forStatementStart) {
		inForOrForeachLoop.push(new Boolean(true));
	}

	public void visit(MyOptCondition optCondition) {
		optCondition.obj = optCondition.getCondition().obj;
	}

	// foreachStatement
	public void visit(ForeachIdent foreachIdent) {
		String identName = foreachIdent.getName();
		foreachIdent.obj = Tab.find(identName);
		if(foreachIdent.obj.equals(Tab.noObj)) {
			report_error("Greska iterator kod foreach petlje nije deklarisan",foreachIdent);
		}
		inForOrForeachLoop.push(new Boolean(true));
	}

	public void visit(MyForEachStatement foreachStatement) {
		Designator designator = foreachStatement.getDesignator();
		if(designator.obj.getType().getKind() != Struct.Array ) {
			report_error("Greska, designator "+designator.obj.getName()+ " kod foreach petlje mora biti niz", foreachStatement);
		}
		String identName = foreachStatement.getForeachIdent().getName();
		Obj identObj = Tab.find(identName);
		if(identObj.equals(Tab.noObj)) {
			report_error("Greska iterator "+identName+" kod foreach petlje nije deklarisan", foreachStatement);
		}
		if(identObj.getType().getKind() == Struct.Array) {
			report_error("Greska, iterator ne moze biti niz kod foreach petlje", foreachStatement);
		}
		if(!compareTypes(identObj.getType(), designator.obj.getType().getElemType())) {
			report_error("Greska, tip iteratora kod foreach petlje se razlikuje sa tipom elemenata niza", foreachStatement);
		}
		inForOrForeachLoop.pop();
	}

	public void visit(BinaryExpr be) {
			
		be.obj = new Obj(Obj.Con, "", new Struct(Struct.Int));
		
	}
	
}
