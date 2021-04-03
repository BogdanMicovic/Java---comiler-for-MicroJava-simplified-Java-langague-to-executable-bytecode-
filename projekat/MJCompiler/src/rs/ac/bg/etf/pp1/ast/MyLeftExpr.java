// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyLeftExpr extends Expr {

    private LeftExpr LeftExpr;

    public MyLeftExpr (LeftExpr LeftExpr) {
        this.LeftExpr=LeftExpr;
        if(LeftExpr!=null) LeftExpr.setParent(this);
    }

    public LeftExpr getLeftExpr() {
        return LeftExpr;
    }

    public void setLeftExpr(LeftExpr LeftExpr) {
        this.LeftExpr=LeftExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftExpr!=null) LeftExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftExpr!=null) LeftExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftExpr!=null) LeftExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyLeftExpr(\n");

        if(LeftExpr!=null)
            buffer.append(LeftExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyLeftExpr]");
        return buffer.toString();
    }
}
