// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:16


package rs.ac.bg.etf.pp1.ast;

public class MyConstNum extends Constant {

    private Integer constInt;

    public MyConstNum (Integer constInt) {
        this.constInt=constInt;
    }

    public Integer getConstInt() {
        return constInt;
    }

    public void setConstInt(Integer constInt) {
        this.constInt=constInt;
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
        buffer.append("MyConstNum(\n");

        buffer.append(" "+tab+constInt);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyConstNum]");
        return buffer.toString();
    }
}
