// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class PercentEqual extends RightOp {

    public PercentEqual () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PercentEqual(\n");

        buffer.append(tab);
        buffer.append(") [PercentEqual]");
        return buffer.toString();
    }
}
