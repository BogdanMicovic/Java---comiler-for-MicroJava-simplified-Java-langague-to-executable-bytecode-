// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ActParsOpt ActParsOpt);
    public void visit(OptCondition OptCondition);
    public void visit(OptFormParsList OptFormParsList);
    public void visit(Factor Factor);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(MethodDeclTypes MethodDeclTypes);
    public void visit(Statement Statement);
    public void visit(SquareBrackets SquareBrackets);
    public void visit(MethodDecl MethodDecl);
    public void visit(DesignatorStatementOpt DesignatorStatementOpt);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(MethodDeclListOne MethodDeclListOne);
    public void visit(Relop Relop);
    public void visit(DeclList DeclList);
    public void visit(Expr Expr);
    public void visit(MethodDeclOrAbstractMethodDecl MethodDeclOrAbstractMethodDecl);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(VarDecl VarDecl);
    public void visit(MulIdentOrExpr MulIdentOrExpr);
    public void visit(ConstantDeclarations ConstantDeclarations);
    public void visit(MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList);
    public void visit(Declaration Declaration);
    public void visit(MulSqBrackets MulSqBrackets);
    public void visit(SquareExprOpt SquareExprOpt);
    public void visit(MethodDeclOrAbstractMethodDeclOpt MethodDeclOrAbstractMethodDeclOpt);
    public void visit(ExtendsTypesOne ExtendsTypesOne);
    public void visit(Constant Constant);
    public void visit(SqBrac SqBrac);
    public void visit(FormParsList FormParsList);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(Condition Condition);
    public void visit(Mulop Mulop);
    public void visit(Addop Addop);
    public void visit(StatementList StatementList);
    public void visit(Assignop Assignop);
    public void visit(MulIdentOrExprOne MulIdentOrExprOne);
    public void visit(Type Type);
    public void visit(OptExpr OptExpr);
    public void visit(CondTerm CondTerm);
    public void visit(FormParsListOneTwo FormParsListOneTwo);
    public void visit(MulMethodDeclListOne MulMethodDeclListOne);
    public void visit(ActParsOptOpt ActParsOptOpt);
    public void visit(ClassDecl ClassDecl);
    public void visit(ExtendsTypes ExtendsTypes);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(LeftExpr LeftExpr);
    public void visit(OptNumConst OptNumConst);
    public void visit(ElseStatementOpt ElseStatementOpt);
    public void visit(DesignatorName DesignatorName);
    public void visit(ActPars ActPars);
    public void visit(VarDeclList VarDeclList);
    public void visit(CondFact CondFact);
    public void visit(Term Term);
    public void visit(OptDesignatorSatement OptDesignatorSatement);
    public void visit(MultipleSquareBrackets MultipleSquareBrackets);
    public void visit(RightOp RightOp);
    public void visit(MyAbstractMethodDeclError MyAbstractMethodDeclError);
    public void visit(MyAbstractMethodDecl MyAbstractMethodDecl);
    public void visit(MyMethodDeclAbstract MyMethodDeclAbstract);
    public void visit(MyMethodDeclNoAbstract MyMethodDeclNoAbstract);
    public void visit(NoMyMethodDeclOrAbstractMethodDeclList NoMyMethodDeclOrAbstractMethodDeclList);
    public void visit(MyMethodDeclOrAbstractMethodDeclList MyMethodDeclOrAbstractMethodDeclList);
    public void visit(NoMyMethodDeclOrAbstractMethodDeclOpt NoMyMethodDeclOrAbstractMethodDeclOpt);
    public void visit(MyMethodDeclOrAbstractMethodDeclOpt MyMethodDeclOrAbstractMethodDeclOpt);
    public void visit(MyAbstractClassDecl MyAbstractClassDecl);
    public void visit(NoMyOptNumConst NoMyOptNumConst);
    public void visit(MyOptNumConst MyOptNumConst);
    public void visit(NoMyOptExpr NoMyOptExpr);
    public void visit(MyOptExpr MyOptExpr);
    public void visit(NoMyOptCondition NoMyOptCondition);
    public void visit(MyOptCondition MyOptCondition);
    public void visit(NoMyOptDesignatorSatement NoMyOptDesignatorSatement);
    public void visit(MyOptDesignatorSatement MyOptDesignatorSatement);
    public void visit(ForStatement ForStatement);
    public void visit(DesigStateEnd DesigStateEnd);
    public void visit(DesigStateStart DesigStateStart);
    public void visit(ConditionFor ConditionFor);
    public void visit(LBracketFor LBracketFor);
    public void visit(ElseStat ElseStat);
    public void visit(NoMyElseStatementOpt NoMyElseStatementOpt);
    public void visit(MyElseStatementOpt MyElseStatementOpt);
    public void visit(MyRelopLessEq MyRelopLessEq);
    public void visit(MyRelopLess MyRelopLess);
    public void visit(MyRelopBiggerEq MyRelopBiggerEq);
    public void visit(MyRelopBigger MyRelopBigger);
    public void visit(MyRelopDifferent MyRelopDifferent);
    public void visit(MyRelopEqual MyRelopEqual);
    public void visit(MyCondFactExorRelop MyCondFactExorRelop);
    public void visit(MyCondFactExpr MyCondFactExpr);
    public void visit(MyCondTermNonRecursive MyCondTermNonRecursive);
    public void visit(MyCondTermRecursive MyCondTermRecursive);
    public void visit(MyConditionNonRecursive MyConditionNonRecursive);
    public void visit(MyConditionRecursive MyConditionRecursive);
    public void visit(IfStatement IfStatement);
    public void visit(LBracketIf LBracketIf);
    public void visit(PercentEqual PercentEqual);
    public void visit(DivEqual DivEqual);
    public void visit(MulEqual MulEqual);
    public void visit(MinusEqual MinusEqual);
    public void visit(PlusEqual PlusEqual);
    public void visit(MyAssignopRight MyAssignopRight);
    public void visit(MyAssignop MyAssignop);
    public void visit(AddopLeftMinus AddopLeftMinus);
    public void visit(AddopLeftPlus AddopLeftPlus);
    public void visit(MulopLeftPercent MulopLeftPercent);
    public void visit(MulopLeftDiv MulopLeftDiv);
    public void visit(MulopLeftMul MulopLeftMul);
    public void visit(NoMySquareExprOpt NoMySquareExprOpt);
    public void visit(MySquareExprOpt MySquareExprOpt);
    public void visit(MyActParsNonRecursive MyActParsNonRecursive);
    public void visit(MyActParsRecursive MyActParsRecursive);
    public void visit(NoMyActParsOpt NoMyActParsOpt);
    public void visit(MyActParsOpt MyActParsOpt);
    public void visit(ActParsRBracket ActParsRBracket);
    public void visit(ActParsLBracket ActParsLBracket);
    public void visit(NoMyActParsOptOpt NoMyActParsOptOpt);
    public void visit(MyActParsOptOpt MyActParsOptOpt);
    public void visit(MyFactorExpr MyFactorExpr);
    public void visit(MyFactorNew MyFactorNew);
    public void visit(MyFactorBool MyFactorBool);
    public void visit(MyFactorChar MyFactorChar);
    public void visit(MyFactorNum MyFactorNum);
    public void visit(MyFactor MyFactor);
    public void visit(FactTerm FactTerm);
    public void visit(MulTerm MulTerm);
    public void visit(BinaryExpr BinaryExpr);
    public void visit(MinusTermExpr MinusTermExpr);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(MyLeftExpr MyLeftExpr);
    public void visit(MyExpr MyExpr);
    public void visit(Loperation Loperation);
    public void visit(MyMulIdentOrExprOneExpr MyMulIdentOrExprOneExpr);
    public void visit(MyMulIdentOrExprOneIdent MyMulIdentOrExprOneIdent);
    public void visit(MyMulIdentOrExprNonRecursive MyMulIdentOrExprNonRecursive);
    public void visit(MyMMulIdentOrExprRecursive MyMMulIdentOrExprRecursive);
    public void visit(Designator Designator);
    public void visit(MyDesigStateDec MyDesigStateDec);
    public void visit(MyDesigStateInc MyDesigStateInc);
    public void visit(MyDesigStateActParsList MyDesigStateActParsList);
    public void visit(MyDesigSteteAssignOpExpr MyDesigSteteAssignOpExpr);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesigStart DesigStart);
    public void visit(DesigEnd DesigEnd);
    public void visit(ForeachIdent ForeachIdent);
    public void visit(MyForEachStatement MyForEachStatement);
    public void visit(MyStatemets MyStatemets);
    public void visit(MyPrintStatement MyPrintStatement);
    public void visit(MyReadStatement MyReadStatement);
    public void visit(MyReturnStatement MyReturnStatement);
    public void visit(MyContinueStatement MyContinueStatement);
    public void visit(MyBreakStatement MyBreakStatement);
    public void visit(MyForStatement MyForStatement);
    public void visit(MyIfStatement MyIfStatement);
    public void visit(ErrAssignment ErrAssignment);
    public void visit(MyDesignatorStatement MyDesignatorStatement);
    public void visit(NoMyStatementList NoMyStatementList);
    public void visit(MyStatementList MyStatementList);
    public void visit(MySqBrac MySqBrac);
    public void visit(NoMyMulSqBrackets NoMyMulSqBrackets);
    public void visit(MyMulSqBrackets MyMulSqBrackets);
    public void visit(FormParsListError FormParsListError);
    public void visit(MyFormParsListOneTwo MyFormParsListOneTwo);
    public void visit(MyFormParsListNonRecursive MyFormParsListNonRecursive);
    public void visit(MyFormParsListRecursive MyFormParsListRecursive);
    public void visit(NoMyOptFormParsList NoMyOptFormParsList);
    public void visit(MyOptFormParsList MyOptFormParsList);
    public void visit(MyMethodDeclTypesTypeVoid MyMethodDeclTypesTypeVoid);
    public void visit(MyMethodDeclTypesType MyMethodDeclTypesType);
    public void visit(MyMethodDecl MyMethodDecl);
    public void visit(MyMulMethodDeclListOneNonRecursive MyMulMethodDeclListOneNonRecursive);
    public void visit(MyMulMethodDeclListOneRecursive MyMulMethodDeclListOneRecursive);
    public void visit(MyMethodDeclListOne MyMethodDeclListOne);
    public void visit(NoMyMhetodDeclList NoMyMhetodDeclList);
    public void visit(MyMethodDeclList MyMethodDeclList);
    public void visit(NoMyVarDeclList NoMyVarDeclList);
    public void visit(MyVarDeclList MyVarDeclList);
    public void visit(MyExtendsTypesOne MyExtendsTypesOne);
    public void visit(NoMyExtendsTypes NoMyExtendsTypes);
    public void visit(MyExtendsTypes MyExtendsTypes);
    public void visit(MyClassDecl MyClassDecl);
    public void visit(MySquareBrackets MySquareBrackets);
    public void visit(NoMyMultipleSquareBrackets NoMyMultipleSquareBrackets);
    public void visit(MyMultipleSquareBrackets MyMultipleSquareBrackets);
    public void visit(VarDeclError VarDeclError);
    public void visit(MyVarDeclaration MyVarDeclaration);
    public void visit(MyVarDeclarationsNonRecursive MyVarDeclarationsNonRecursive);
    public void visit(MyVarDeclarationsRecursive MyVarDeclarationsRecursive);
    public void visit(MyVarDecl MyVarDecl);
    public void visit(MyType MyType);
    public void visit(MyConstBool MyConstBool);
    public void visit(MyConstChar MyConstChar);
    public void visit(MyConstNum MyConstNum);
    public void visit(ConstantDeclaration ConstantDeclaration);
    public void visit(MyConstantDeclarationsNonRecursive MyConstantDeclarationsNonRecursive);
    public void visit(MyConstantDeclarationsRecursive MyConstantDeclarationsRecursive);
    public void visit(ConstDecl ConstDecl);
    public void visit(MyClasses MyClasses);
    public void visit(MyAbstractClasses MyAbstractClasses);
    public void visit(MyVars MyVars);
    public void visit(MyConstats MyConstats);
    public void visit(MyNoDeclList MyNoDeclList);
    public void visit(MyDeclList MyDeclList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
