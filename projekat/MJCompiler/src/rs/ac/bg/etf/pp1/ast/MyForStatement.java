// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyForStatement extends Statement {

    private LBracketFor LBracketFor;
    private OptDesignatorSatement OptDesignatorSatement;
    private ConditionFor ConditionFor;
    private OptCondition OptCondition;
    private DesigStateStart DesigStateStart;
    private OptDesignatorSatement OptDesignatorSatement1;
    private DesigStateEnd DesigStateEnd;
    private ForStatement ForStatement;
    private Statement Statement;

    public MyForStatement (LBracketFor LBracketFor, OptDesignatorSatement OptDesignatorSatement, ConditionFor ConditionFor, OptCondition OptCondition, DesigStateStart DesigStateStart, OptDesignatorSatement OptDesignatorSatement1, DesigStateEnd DesigStateEnd, ForStatement ForStatement, Statement Statement) {
        this.LBracketFor=LBracketFor;
        if(LBracketFor!=null) LBracketFor.setParent(this);
        this.OptDesignatorSatement=OptDesignatorSatement;
        if(OptDesignatorSatement!=null) OptDesignatorSatement.setParent(this);
        this.ConditionFor=ConditionFor;
        if(ConditionFor!=null) ConditionFor.setParent(this);
        this.OptCondition=OptCondition;
        if(OptCondition!=null) OptCondition.setParent(this);
        this.DesigStateStart=DesigStateStart;
        if(DesigStateStart!=null) DesigStateStart.setParent(this);
        this.OptDesignatorSatement1=OptDesignatorSatement1;
        if(OptDesignatorSatement1!=null) OptDesignatorSatement1.setParent(this);
        this.DesigStateEnd=DesigStateEnd;
        if(DesigStateEnd!=null) DesigStateEnd.setParent(this);
        this.ForStatement=ForStatement;
        if(ForStatement!=null) ForStatement.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public LBracketFor getLBracketFor() {
        return LBracketFor;
    }

    public void setLBracketFor(LBracketFor LBracketFor) {
        this.LBracketFor=LBracketFor;
    }

    public OptDesignatorSatement getOptDesignatorSatement() {
        return OptDesignatorSatement;
    }

    public void setOptDesignatorSatement(OptDesignatorSatement OptDesignatorSatement) {
        this.OptDesignatorSatement=OptDesignatorSatement;
    }

    public ConditionFor getConditionFor() {
        return ConditionFor;
    }

    public void setConditionFor(ConditionFor ConditionFor) {
        this.ConditionFor=ConditionFor;
    }

    public OptCondition getOptCondition() {
        return OptCondition;
    }

    public void setOptCondition(OptCondition OptCondition) {
        this.OptCondition=OptCondition;
    }

    public DesigStateStart getDesigStateStart() {
        return DesigStateStart;
    }

    public void setDesigStateStart(DesigStateStart DesigStateStart) {
        this.DesigStateStart=DesigStateStart;
    }

    public OptDesignatorSatement getOptDesignatorSatement1() {
        return OptDesignatorSatement1;
    }

    public void setOptDesignatorSatement1(OptDesignatorSatement OptDesignatorSatement1) {
        this.OptDesignatorSatement1=OptDesignatorSatement1;
    }

    public DesigStateEnd getDesigStateEnd() {
        return DesigStateEnd;
    }

    public void setDesigStateEnd(DesigStateEnd DesigStateEnd) {
        this.DesigStateEnd=DesigStateEnd;
    }

    public ForStatement getForStatement() {
        return ForStatement;
    }

    public void setForStatement(ForStatement ForStatement) {
        this.ForStatement=ForStatement;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LBracketFor!=null) LBracketFor.accept(visitor);
        if(OptDesignatorSatement!=null) OptDesignatorSatement.accept(visitor);
        if(ConditionFor!=null) ConditionFor.accept(visitor);
        if(OptCondition!=null) OptCondition.accept(visitor);
        if(DesigStateStart!=null) DesigStateStart.accept(visitor);
        if(OptDesignatorSatement1!=null) OptDesignatorSatement1.accept(visitor);
        if(DesigStateEnd!=null) DesigStateEnd.accept(visitor);
        if(ForStatement!=null) ForStatement.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LBracketFor!=null) LBracketFor.traverseTopDown(visitor);
        if(OptDesignatorSatement!=null) OptDesignatorSatement.traverseTopDown(visitor);
        if(ConditionFor!=null) ConditionFor.traverseTopDown(visitor);
        if(OptCondition!=null) OptCondition.traverseTopDown(visitor);
        if(DesigStateStart!=null) DesigStateStart.traverseTopDown(visitor);
        if(OptDesignatorSatement1!=null) OptDesignatorSatement1.traverseTopDown(visitor);
        if(DesigStateEnd!=null) DesigStateEnd.traverseTopDown(visitor);
        if(ForStatement!=null) ForStatement.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LBracketFor!=null) LBracketFor.traverseBottomUp(visitor);
        if(OptDesignatorSatement!=null) OptDesignatorSatement.traverseBottomUp(visitor);
        if(ConditionFor!=null) ConditionFor.traverseBottomUp(visitor);
        if(OptCondition!=null) OptCondition.traverseBottomUp(visitor);
        if(DesigStateStart!=null) DesigStateStart.traverseBottomUp(visitor);
        if(OptDesignatorSatement1!=null) OptDesignatorSatement1.traverseBottomUp(visitor);
        if(DesigStateEnd!=null) DesigStateEnd.traverseBottomUp(visitor);
        if(ForStatement!=null) ForStatement.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyForStatement(\n");

        if(LBracketFor!=null)
            buffer.append(LBracketFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptDesignatorSatement!=null)
            buffer.append(OptDesignatorSatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionFor!=null)
            buffer.append(ConditionFor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptCondition!=null)
            buffer.append(OptCondition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigStateStart!=null)
            buffer.append(DesigStateStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptDesignatorSatement1!=null)
            buffer.append(OptDesignatorSatement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigStateEnd!=null)
            buffer.append(DesigStateEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStatement!=null)
            buffer.append(ForStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyForStatement]");
        return buffer.toString();
    }
}
