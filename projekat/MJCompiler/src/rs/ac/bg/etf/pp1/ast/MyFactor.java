// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyFactor extends Factor {

    private Designator Designator;
    private ActParsOptOpt ActParsOptOpt;

    public MyFactor (Designator Designator, ActParsOptOpt ActParsOptOpt) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsOptOpt=ActParsOptOpt;
        if(ActParsOptOpt!=null) ActParsOptOpt.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsOptOpt getActParsOptOpt() {
        return ActParsOptOpt;
    }

    public void setActParsOptOpt(ActParsOptOpt ActParsOptOpt) {
        this.ActParsOptOpt=ActParsOptOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsOptOpt!=null) ActParsOptOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsOptOpt!=null) ActParsOptOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsOptOpt!=null) ActParsOptOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyFactor(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOptOpt!=null)
            buffer.append(ActParsOptOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyFactor]");
        return buffer.toString();
    }
}
