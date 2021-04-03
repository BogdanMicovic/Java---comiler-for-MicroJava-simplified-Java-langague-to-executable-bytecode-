// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyAbstractClassDecl extends AbstractClassDecl {

    private String abstractClassName;
    private ExtendsTypes ExtendsTypes;
    private VarDeclList VarDeclList;
    private MethodDeclOrAbstractMethodDeclOpt MethodDeclOrAbstractMethodDeclOpt;

    public MyAbstractClassDecl (String abstractClassName, ExtendsTypes ExtendsTypes, VarDeclList VarDeclList, MethodDeclOrAbstractMethodDeclOpt MethodDeclOrAbstractMethodDeclOpt) {
        this.abstractClassName=abstractClassName;
        this.ExtendsTypes=ExtendsTypes;
        if(ExtendsTypes!=null) ExtendsTypes.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.MethodDeclOrAbstractMethodDeclOpt=MethodDeclOrAbstractMethodDeclOpt;
        if(MethodDeclOrAbstractMethodDeclOpt!=null) MethodDeclOrAbstractMethodDeclOpt.setParent(this);
    }

    public String getAbstractClassName() {
        return abstractClassName;
    }

    public void setAbstractClassName(String abstractClassName) {
        this.abstractClassName=abstractClassName;
    }

    public ExtendsTypes getExtendsTypes() {
        return ExtendsTypes;
    }

    public void setExtendsTypes(ExtendsTypes ExtendsTypes) {
        this.ExtendsTypes=ExtendsTypes;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public MethodDeclOrAbstractMethodDeclOpt getMethodDeclOrAbstractMethodDeclOpt() {
        return MethodDeclOrAbstractMethodDeclOpt;
    }

    public void setMethodDeclOrAbstractMethodDeclOpt(MethodDeclOrAbstractMethodDeclOpt MethodDeclOrAbstractMethodDeclOpt) {
        this.MethodDeclOrAbstractMethodDeclOpt=MethodDeclOrAbstractMethodDeclOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsTypes!=null) ExtendsTypes.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(MethodDeclOrAbstractMethodDeclOpt!=null) MethodDeclOrAbstractMethodDeclOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsTypes!=null) ExtendsTypes.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(MethodDeclOrAbstractMethodDeclOpt!=null) MethodDeclOrAbstractMethodDeclOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsTypes!=null) ExtendsTypes.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(MethodDeclOrAbstractMethodDeclOpt!=null) MethodDeclOrAbstractMethodDeclOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyAbstractClassDecl(\n");

        buffer.append(" "+tab+abstractClassName);
        buffer.append("\n");

        if(ExtendsTypes!=null)
            buffer.append(ExtendsTypes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclOrAbstractMethodDeclOpt!=null)
            buffer.append(MethodDeclOrAbstractMethodDeclOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyAbstractClassDecl]");
        return buffer.toString();
    }
}
