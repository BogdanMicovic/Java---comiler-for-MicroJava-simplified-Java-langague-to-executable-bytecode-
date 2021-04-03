// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:16


package rs.ac.bg.etf.pp1.ast;

public class MyConstBool extends Constant {

    private Boolean constBool;

    public MyConstBool (Boolean constBool) {
        this.constBool=constBool;
    }

    public Boolean getConstBool() {
        return constBool;
    }

    public void setConstBool(Boolean constBool) {
        this.constBool=constBool;
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
        buffer.append("MyConstBool(\n");

        buffer.append(" "+tab+constBool);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyConstBool]");
        return buffer.toString();
    }
}
