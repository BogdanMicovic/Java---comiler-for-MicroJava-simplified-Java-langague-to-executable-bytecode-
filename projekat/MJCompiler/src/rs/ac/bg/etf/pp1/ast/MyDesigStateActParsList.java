// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyDesigStateActParsList extends DesignatorStatementOpt {

    private ActParsOptOpt ActParsOptOpt;

    public MyDesigStateActParsList (ActParsOptOpt ActParsOptOpt) {
        this.ActParsOptOpt=ActParsOptOpt;
        if(ActParsOptOpt!=null) ActParsOptOpt.setParent(this);
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
        if(ActParsOptOpt!=null) ActParsOptOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsOptOpt!=null) ActParsOptOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsOptOpt!=null) ActParsOptOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyDesigStateActParsList(\n");

        if(ActParsOptOpt!=null)
            buffer.append(ActParsOptOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyDesigStateActParsList]");
        return buffer.toString();
    }
}
