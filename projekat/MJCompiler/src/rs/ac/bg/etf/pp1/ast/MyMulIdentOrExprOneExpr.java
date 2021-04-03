// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMulIdentOrExprOneExpr extends MulIdentOrExprOne {

    private Loperation Loperation;
    private Expr Expr;

    public MyMulIdentOrExprOneExpr (Loperation Loperation, Expr Expr) {
        this.Loperation=Loperation;
        if(Loperation!=null) Loperation.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public Loperation getLoperation() {
        return Loperation;
    }

    public void setLoperation(Loperation Loperation) {
        this.Loperation=Loperation;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Loperation!=null) Loperation.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Loperation!=null) Loperation.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Loperation!=null) Loperation.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMulIdentOrExprOneExpr(\n");

        if(Loperation!=null)
            buffer.append(Loperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMulIdentOrExprOneExpr]");
        return buffer.toString();
    }
}
