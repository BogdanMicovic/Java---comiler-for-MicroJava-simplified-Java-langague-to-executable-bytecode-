// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyIfStatement extends Statement {

    private LBracketIf LBracketIf;
    private Condition Condition;
    private IfStatement IfStatement;
    private Statement Statement;
    private ElseStatementOpt ElseStatementOpt;

    public MyIfStatement (LBracketIf LBracketIf, Condition Condition, IfStatement IfStatement, Statement Statement, ElseStatementOpt ElseStatementOpt) {
        this.LBracketIf=LBracketIf;
        if(LBracketIf!=null) LBracketIf.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.IfStatement=IfStatement;
        if(IfStatement!=null) IfStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStatementOpt=ElseStatementOpt;
        if(ElseStatementOpt!=null) ElseStatementOpt.setParent(this);
    }

    public LBracketIf getLBracketIf() {
        return LBracketIf;
    }

    public void setLBracketIf(LBracketIf LBracketIf) {
        this.LBracketIf=LBracketIf;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public IfStatement getIfStatement() {
        return IfStatement;
    }

    public void setIfStatement(IfStatement IfStatement) {
        this.IfStatement=IfStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseStatementOpt getElseStatementOpt() {
        return ElseStatementOpt;
    }

    public void setElseStatementOpt(ElseStatementOpt ElseStatementOpt) {
        this.ElseStatementOpt=ElseStatementOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LBracketIf!=null) LBracketIf.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(IfStatement!=null) IfStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStatementOpt!=null) ElseStatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracketIf!=null) LBracketIf.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(IfStatement!=null) IfStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStatementOpt!=null) ElseStatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracketIf!=null) LBracketIf.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(IfStatement!=null) IfStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStatementOpt!=null) ElseStatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyIfStatement(\n");

        if(LBracketIf!=null)
            buffer.append(LBracketIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfStatement!=null)
            buffer.append(IfStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseStatementOpt!=null)
            buffer.append(ElseStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyIfStatement]");
        return buffer.toString();
    }
}
