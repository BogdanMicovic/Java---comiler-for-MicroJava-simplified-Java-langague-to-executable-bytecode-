// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMethodDeclOrAbstractMethodDeclList extends MethodDeclOrAbstractMethodDeclList {

    private MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList;
    private MethodDeclOrAbstractMethodDecl MethodDeclOrAbstractMethodDecl;

    public MyMethodDeclOrAbstractMethodDeclList (MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList, MethodDeclOrAbstractMethodDecl MethodDeclOrAbstractMethodDecl) {
        this.MethodDeclOrAbstractMethodDeclList=MethodDeclOrAbstractMethodDeclList;
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.setParent(this);
        this.MethodDeclOrAbstractMethodDecl=MethodDeclOrAbstractMethodDecl;
        if(MethodDeclOrAbstractMethodDecl!=null) MethodDeclOrAbstractMethodDecl.setParent(this);
    }

    public MethodDeclOrAbstractMethodDeclList getMethodDeclOrAbstractMethodDeclList() {
        return MethodDeclOrAbstractMethodDeclList;
    }

    public void setMethodDeclOrAbstractMethodDeclList(MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList) {
        this.MethodDeclOrAbstractMethodDeclList=MethodDeclOrAbstractMethodDeclList;
    }

    public MethodDeclOrAbstractMethodDecl getMethodDeclOrAbstractMethodDecl() {
        return MethodDeclOrAbstractMethodDecl;
    }

    public void setMethodDeclOrAbstractMethodDecl(MethodDeclOrAbstractMethodDecl MethodDeclOrAbstractMethodDecl) {
        this.MethodDeclOrAbstractMethodDecl=MethodDeclOrAbstractMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.accept(visitor);
        if(MethodDeclOrAbstractMethodDecl!=null) MethodDeclOrAbstractMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.traverseTopDown(visitor);
        if(MethodDeclOrAbstractMethodDecl!=null) MethodDeclOrAbstractMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.traverseBottomUp(visitor);
        if(MethodDeclOrAbstractMethodDecl!=null) MethodDeclOrAbstractMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMethodDeclOrAbstractMethodDeclList(\n");

        if(MethodDeclOrAbstractMethodDeclList!=null)
            buffer.append(MethodDeclOrAbstractMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclOrAbstractMethodDecl!=null)
            buffer.append(MethodDeclOrAbstractMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMethodDeclOrAbstractMethodDeclList]");
        return buffer.toString();
    }
}
