// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMethodDeclList extends MethodDeclList {

    private MethodDeclListOne MethodDeclListOne;

    public MyMethodDeclList (MethodDeclListOne MethodDeclListOne) {
        this.MethodDeclListOne=MethodDeclListOne;
        if(MethodDeclListOne!=null) MethodDeclListOne.setParent(this);
    }

    public MethodDeclListOne getMethodDeclListOne() {
        return MethodDeclListOne;
    }

    public void setMethodDeclListOne(MethodDeclListOne MethodDeclListOne) {
        this.MethodDeclListOne=MethodDeclListOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclListOne!=null) MethodDeclListOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclListOne!=null) MethodDeclListOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclListOne!=null) MethodDeclListOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMethodDeclList(\n");

        if(MethodDeclListOne!=null)
            buffer.append(MethodDeclListOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMethodDeclList]");
        return buffer.toString();
    }
}
