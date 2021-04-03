// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMulSqBrackets extends MulSqBrackets {

    private SqBrac SqBrac;

    public MyMulSqBrackets (SqBrac SqBrac) {
        this.SqBrac=SqBrac;
        if(SqBrac!=null) SqBrac.setParent(this);
    }

    public SqBrac getSqBrac() {
        return SqBrac;
    }

    public void setSqBrac(SqBrac SqBrac) {
        this.SqBrac=SqBrac;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SqBrac!=null) SqBrac.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SqBrac!=null) SqBrac.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SqBrac!=null) SqBrac.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMulSqBrackets(\n");

        if(SqBrac!=null)
            buffer.append(SqBrac.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMulSqBrackets]");
        return buffer.toString();
    }
}
