// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMethodDeclListOne extends MethodDeclListOne {

    private MulMethodDeclListOne MulMethodDeclListOne;

    public MyMethodDeclListOne (MulMethodDeclListOne MulMethodDeclListOne) {
        this.MulMethodDeclListOne=MulMethodDeclListOne;
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.setParent(this);
    }

    public MulMethodDeclListOne getMulMethodDeclListOne() {
        return MulMethodDeclListOne;
    }

    public void setMulMethodDeclListOne(MulMethodDeclListOne MulMethodDeclListOne) {
        this.MulMethodDeclListOne=MulMethodDeclListOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMethodDeclListOne(\n");

        if(MulMethodDeclListOne!=null)
            buffer.append(MulMethodDeclListOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMethodDeclListOne]");
        return buffer.toString();
    }
}
