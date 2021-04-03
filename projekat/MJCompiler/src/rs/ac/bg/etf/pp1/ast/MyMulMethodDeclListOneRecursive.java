// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMulMethodDeclListOneRecursive extends MulMethodDeclListOne {

    private MulMethodDeclListOne MulMethodDeclListOne;
    private MethodDecl MethodDecl;

    public MyMulMethodDeclListOneRecursive (MulMethodDeclListOne MulMethodDeclListOne, MethodDecl MethodDecl) {
        this.MulMethodDeclListOne=MulMethodDeclListOne;
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public MulMethodDeclListOne getMulMethodDeclListOne() {
        return MulMethodDeclListOne;
    }

    public void setMulMethodDeclListOne(MulMethodDeclListOne MulMethodDeclListOne) {
        this.MulMethodDeclListOne=MulMethodDeclListOne;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulMethodDeclListOne!=null) MulMethodDeclListOne.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMulMethodDeclListOneRecursive(\n");

        if(MulMethodDeclListOne!=null)
            buffer.append(MulMethodDeclListOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMulMethodDeclListOneRecursive]");
        return buffer.toString();
    }
}
