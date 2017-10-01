package cz.muni.fi;

import org.ngmon.structlog.annotation.Var;
import org.ngmon.structlog.annotation.VarContext;
import org.ngmon.structlog.injection.VariableContext;

@VarContext
public class MyContext extends VariableContext {

    @Var
    public MyContext varDouble(double value) {
        this.inject("varDouble", value);
        return this;
    }

    @Var
    public MyContext varLong(long value) {
        this.inject("varLong", value);
        return this;
    }

    @Var
    public MyContext varBoolean(boolean value) {
        this.inject("varBoolean", value);
        return this;
    }

    @Var
    public MyContext varString(String value) {
        this.inject("varString", value);
        return this;
    }

    @Var
    public MyContext varInt(int value) {
        this.inject("varInt", value);
        return this;
    }
}
