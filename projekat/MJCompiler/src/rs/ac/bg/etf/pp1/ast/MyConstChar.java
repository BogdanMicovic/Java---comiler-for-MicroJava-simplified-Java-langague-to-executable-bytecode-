// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:16


package rs.ac.bg.etf.pp1.ast;

public class MyConstChar extends Constant {

    private Character constChar;

    public MyConstChar (Character constChar) {
        this.constChar=constChar;
    }

    public Character getConstChar() {
        return constChar;
    }

    public void setConstChar(Character constChar) {
        this.constChar=constChar;
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
        buffer.append("MyConstChar(\n");

        buffer.append(" "+tab+constChar);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyConstChar]");
        return buffer.toString();
    }
}
