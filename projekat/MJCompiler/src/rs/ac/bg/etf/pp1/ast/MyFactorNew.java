// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyFactorNew extends Factor {

    private Type Type;
    private SquareExprOpt SquareExprOpt;

    public MyFactorNew (Type Type, SquareExprOpt SquareExprOpt) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.SquareExprOpt=SquareExprOpt;
        if(SquareExprOpt!=null) SquareExprOpt.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public SquareExprOpt getSquareExprOpt() {
        return SquareExprOpt;
    }

    public void setSquareExprOpt(SquareExprOpt SquareExprOpt) {
        this.SquareExprOpt=SquareExprOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(SquareExprOpt!=null) SquareExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(SquareExprOpt!=null) SquareExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(SquareExprOpt!=null) SquareExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyFactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SquareExprOpt!=null)
            buffer.append(SquareExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyFactorNew]");
        return buffer.toString();
    }
}
