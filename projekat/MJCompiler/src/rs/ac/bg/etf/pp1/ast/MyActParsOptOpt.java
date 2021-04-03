// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyActParsOptOpt extends ActParsOptOpt {

    private ActParsLBracket ActParsLBracket;
    private ActParsOpt ActParsOpt;
    private ActParsRBracket ActParsRBracket;

    public MyActParsOptOpt (ActParsLBracket ActParsLBracket, ActParsOpt ActParsOpt, ActParsRBracket ActParsRBracket) {
        this.ActParsLBracket=ActParsLBracket;
        if(ActParsLBracket!=null) ActParsLBracket.setParent(this);
        this.ActParsOpt=ActParsOpt;
        if(ActParsOpt!=null) ActParsOpt.setParent(this);
        this.ActParsRBracket=ActParsRBracket;
        if(ActParsRBracket!=null) ActParsRBracket.setParent(this);
    }

    public ActParsLBracket getActParsLBracket() {
        return ActParsLBracket;
    }

    public void setActParsLBracket(ActParsLBracket ActParsLBracket) {
        this.ActParsLBracket=ActParsLBracket;
    }

    public ActParsOpt getActParsOpt() {
        return ActParsOpt;
    }

    public void setActParsOpt(ActParsOpt ActParsOpt) {
        this.ActParsOpt=ActParsOpt;
    }

    public ActParsRBracket getActParsRBracket() {
        return ActParsRBracket;
    }

    public void setActParsRBracket(ActParsRBracket ActParsRBracket) {
        this.ActParsRBracket=ActParsRBracket;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsLBracket!=null) ActParsLBracket.accept(visitor);
        if(ActParsOpt!=null) ActParsOpt.accept(visitor);
        if(ActParsRBracket!=null) ActParsRBracket.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsLBracket!=null) ActParsLBracket.traverseTopDown(visitor);
        if(ActParsOpt!=null) ActParsOpt.traverseTopDown(visitor);
        if(ActParsRBracket!=null) ActParsRBracket.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsLBracket!=null) ActParsLBracket.traverseBottomUp(visitor);
        if(ActParsOpt!=null) ActParsOpt.traverseBottomUp(visitor);
        if(ActParsRBracket!=null) ActParsRBracket.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyActParsOptOpt(\n");

        if(ActParsLBracket!=null)
            buffer.append(ActParsLBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOpt!=null)
            buffer.append(ActParsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsRBracket!=null)
            buffer.append(ActParsRBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyActParsOptOpt]");
        return buffer.toString();
    }
}
