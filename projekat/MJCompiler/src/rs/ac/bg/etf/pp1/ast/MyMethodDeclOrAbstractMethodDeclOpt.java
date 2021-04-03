// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyMethodDeclOrAbstractMethodDeclOpt extends MethodDeclOrAbstractMethodDeclOpt {

    private MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList;

    public MyMethodDeclOrAbstractMethodDeclOpt (MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList) {
        this.MethodDeclOrAbstractMethodDeclList=MethodDeclOrAbstractMethodDeclList;
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.setParent(this);
    }

    public MethodDeclOrAbstractMethodDeclList getMethodDeclOrAbstractMethodDeclList() {
        return MethodDeclOrAbstractMethodDeclList;
    }

    public void setMethodDeclOrAbstractMethodDeclList(MethodDeclOrAbstractMethodDeclList MethodDeclOrAbstractMethodDeclList) {
        this.MethodDeclOrAbstractMethodDeclList=MethodDeclOrAbstractMethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclOrAbstractMethodDeclList!=null) MethodDeclOrAbstractMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyMethodDeclOrAbstractMethodDeclOpt(\n");

        if(MethodDeclOrAbstractMethodDeclList!=null)
            buffer.append(MethodDeclOrAbstractMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyMethodDeclOrAbstractMethodDeclOpt]");
        return buffer.toString();
    }
}
