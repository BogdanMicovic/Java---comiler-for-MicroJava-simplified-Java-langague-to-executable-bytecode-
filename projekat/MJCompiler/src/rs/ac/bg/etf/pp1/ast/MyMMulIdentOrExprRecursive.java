// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMMulIdentOrExprRecursive extends MulIdentOrExpr {

    private MulIdentOrExpr MulIdentOrExpr;
    private MulIdentOrExprOne MulIdentOrExprOne;

    public MyMMulIdentOrExprRecursive (MulIdentOrExpr MulIdentOrExpr, MulIdentOrExprOne MulIdentOrExprOne) {
        this.MulIdentOrExpr=MulIdentOrExpr;
        if(MulIdentOrExpr!=null) MulIdentOrExpr.setParent(this);
        this.MulIdentOrExprOne=MulIdentOrExprOne;
        if(MulIdentOrExprOne!=null) MulIdentOrExprOne.setParent(this);
    }

    public MulIdentOrExpr getMulIdentOrExpr() {
        return MulIdentOrExpr;
    }

    public void setMulIdentOrExpr(MulIdentOrExpr MulIdentOrExpr) {
        this.MulIdentOrExpr=MulIdentOrExpr;
    }

    public MulIdentOrExprOne getMulIdentOrExprOne() {
        return MulIdentOrExprOne;
    }

    public void setMulIdentOrExprOne(MulIdentOrExprOne MulIdentOrExprOne) {
        this.MulIdentOrExprOne=MulIdentOrExprOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulIdentOrExpr!=null) MulIdentOrExpr.accept(visitor);
        if(MulIdentOrExprOne!=null) MulIdentOrExprOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulIdentOrExpr!=null) MulIdentOrExpr.traverseTopDown(visitor);
        if(MulIdentOrExprOne!=null) MulIdentOrExprOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulIdentOrExpr!=null) MulIdentOrExpr.traverseBottomUp(visitor);
        if(MulIdentOrExprOne!=null) MulIdentOrExprOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMMulIdentOrExprRecursive(\n");

        if(MulIdentOrExpr!=null)
            buffer.append(MulIdentOrExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulIdentOrExprOne!=null)
            buffer.append(MulIdentOrExprOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMMulIdentOrExprRecursive]");
        return buffer.toString();
    }
}
