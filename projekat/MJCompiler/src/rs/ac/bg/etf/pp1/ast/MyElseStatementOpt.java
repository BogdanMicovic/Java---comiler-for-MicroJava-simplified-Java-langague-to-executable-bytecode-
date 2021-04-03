// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyElseStatementOpt extends ElseStatementOpt {

    private ElseStat ElseStat;
    private Statement Statement;

    public MyElseStatementOpt (ElseStat ElseStat, Statement Statement) {
        this.ElseStat=ElseStat;
        if(ElseStat!=null) ElseStat.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ElseStat getElseStat() {
        return ElseStat;
    }

    public void setElseStat(ElseStat ElseStat) {
        this.ElseStat=ElseStat;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ElseStat!=null) ElseStat.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ElseStat!=null) ElseStat.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ElseStat!=null) ElseStat.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyElseStatementOpt(\n");

        if(ElseStat!=null)
            buffer.append(ElseStat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyElseStatementOpt]");
        return buffer.toString();
    }
}
