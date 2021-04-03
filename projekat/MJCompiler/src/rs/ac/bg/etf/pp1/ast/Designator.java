// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String desigatorName;
    private MulIdentOrExpr MulIdentOrExpr;

    public Designator (String desigatorName, MulIdentOrExpr MulIdentOrExpr) {
        this.desigatorName=desigatorName;
        this.MulIdentOrExpr=MulIdentOrExpr;
        if(MulIdentOrExpr!=null) MulIdentOrExpr.setParent(this);
    }

    public String getDesigatorName() {
        return desigatorName;
    }

    public void setDesigatorName(String desigatorName) {
        this.desigatorName=desigatorName;
    }

    public MulIdentOrExpr getMulIdentOrExpr() {
        return MulIdentOrExpr;
    }

    public void setMulIdentOrExpr(MulIdentOrExpr MulIdentOrExpr) {
        this.MulIdentOrExpr=MulIdentOrExpr;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulIdentOrExpr!=null) MulIdentOrExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulIdentOrExpr!=null) MulIdentOrExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulIdentOrExpr!=null) MulIdentOrExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+desigatorName);
        buffer.append("\n");

        if(MulIdentOrExpr!=null)
            buffer.append(MulIdentOrExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
