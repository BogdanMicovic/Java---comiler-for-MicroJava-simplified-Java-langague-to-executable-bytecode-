// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyExpr extends Expr {

    private LeftExpr LeftExpr;
    private RightOp RightOp;
    private Expr Expr;

    public MyExpr (LeftExpr LeftExpr, RightOp RightOp, Expr Expr) {
        this.LeftExpr=LeftExpr;
        if(LeftExpr!=null) LeftExpr.setParent(this);
        this.RightOp=RightOp;
        if(RightOp!=null) RightOp.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public LeftExpr getLeftExpr() {
        return LeftExpr;
    }

    public void setLeftExpr(LeftExpr LeftExpr) {
        this.LeftExpr=LeftExpr;
    }

    public RightOp getRightOp() {
        return RightOp;
    }

    public void setRightOp(RightOp RightOp) {
        this.RightOp=RightOp;
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
        if(LeftExpr!=null) LeftExpr.accept(visitor);
        if(RightOp!=null) RightOp.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftExpr!=null) LeftExpr.traverseTopDown(visitor);
        if(RightOp!=null) RightOp.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftExpr!=null) LeftExpr.traverseBottomUp(visitor);
        if(RightOp!=null) RightOp.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyExpr(\n");

        if(LeftExpr!=null)
            buffer.append(LeftExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RightOp!=null)
            buffer.append(RightOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyExpr]");
        return buffer.toString();
    }
}
