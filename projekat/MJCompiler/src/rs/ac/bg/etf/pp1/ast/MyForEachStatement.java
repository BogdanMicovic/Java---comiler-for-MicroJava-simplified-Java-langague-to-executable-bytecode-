// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyForEachStatement extends Statement {

    private ForeachIdent ForeachIdent;
    private DesigStart DesigStart;
    private Designator Designator;
    private DesigEnd DesigEnd;
    private Statement Statement;

    public MyForEachStatement (ForeachIdent ForeachIdent, DesigStart DesigStart, Designator Designator, DesigEnd DesigEnd, Statement Statement) {
        this.ForeachIdent=ForeachIdent;
        if(ForeachIdent!=null) ForeachIdent.setParent(this);
        this.DesigStart=DesigStart;
        if(DesigStart!=null) DesigStart.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesigEnd=DesigEnd;
        if(DesigEnd!=null) DesigEnd.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForeachIdent getForeachIdent() {
        return ForeachIdent;
    }

    public void setForeachIdent(ForeachIdent ForeachIdent) {
        this.ForeachIdent=ForeachIdent;
    }

    public DesigStart getDesigStart() {
        return DesigStart;
    }

    public void setDesigStart(DesigStart DesigStart) {
        this.DesigStart=DesigStart;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesigEnd getDesigEnd() {
        return DesigEnd;
    }

    public void setDesigEnd(DesigEnd DesigEnd) {
        this.DesigEnd=DesigEnd;
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
        if(ForeachIdent!=null) ForeachIdent.accept(visitor);
        if(DesigStart!=null) DesigStart.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
        if(DesigEnd!=null) DesigEnd.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForeachIdent!=null) ForeachIdent.traverseTopDown(visitor);
        if(DesigStart!=null) DesigStart.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesigEnd!=null) DesigEnd.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForeachIdent!=null) ForeachIdent.traverseBottomUp(visitor);
        if(DesigStart!=null) DesigStart.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesigEnd!=null) DesigEnd.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyForEachStatement(\n");

        if(ForeachIdent!=null)
            buffer.append(ForeachIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigStart!=null)
            buffer.append(DesigStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigEnd!=null)
            buffer.append(DesigEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyForEachStatement]");
        return buffer.toString();
    }
}
