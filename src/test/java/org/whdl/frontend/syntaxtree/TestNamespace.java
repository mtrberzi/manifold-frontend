package org.whdl.frontend.syntaxtree;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class TestNamespace {

  private NamespaceIdentifier getNamespaceIdentifier() {
    return new NamespaceIdentifier("whdl:is:cool");
  }

  private VariableIdentifier getVariableIdentifier() {
    VariableIdentifier id = new VariableIdentifier(getNamespaceIdentifier(),
        "foo");

    return id;
  }

  private Expression getTypeExpression() {
    return new LiteralExpression(BitTypeValue.getInstance());
  }

  @Test
  public void testGetAbsoluteName() {
    Namespace n = new Namespace(getNamespaceIdentifier());
    assertEquals(getNamespaceIdentifier(), n.getAbsoluteName());
  }

  @Test
  public void privateScope_distinctFrom_publicScope() {
    Namespace n = new Namespace(getNamespaceIdentifier());
    Scope priv = n.getPrivateScope();
    Scope pub = n.getPublicScope();
    assertNotSame("private scope and public scope not distinct", priv, pub);
  }

  @Test
  public void isVariableDefined_publicScope_success()
      throws MultipleDefinitionException {
    Namespace n = new Namespace(getNamespaceIdentifier());
    n.getPublicScope().defineVariable(getVariableIdentifier(),
        getTypeExpression());
    assertTrue(n.isVariableDefined(getVariableIdentifier()));
  }

  @Test
  public void isVariableDefined_privateScope_fail()
      throws MultipleDefinitionException {
    Namespace n = new Namespace(getNamespaceIdentifier());
    n.getPrivateScope().defineVariable(getVariableIdentifier(),
        getTypeExpression());
    assertFalse(n.isVariableDefined(getVariableIdentifier()));
  }

  @Test
  public void getVariable_publicScope_success()
      throws MultipleDefinitionException, VariableNotDefinedException {
    // depends on correctness of Scope
    Namespace n = new Namespace(getNamespaceIdentifier());
    n.getPublicScope().defineVariable(getVariableIdentifier(),
        getTypeExpression());
    Variable v = n.getVariable(getVariableIdentifier());
    assertEquals(getVariableIdentifier(), v.getIdentifier());
  }

  @Test(expected = VariableNotDefinedException.class)
  public void getVariable_privateScope_throwsVariableNotDefined()
      throws MultipleDefinitionException, VariableNotDefinedException {
    // depends on correctness of Scope
    Namespace n = new Namespace(getNamespaceIdentifier());
    n.getPrivateScope().defineVariable(getVariableIdentifier(),
        getTypeExpression());
    Variable v = n.getVariable(getVariableIdentifier());
    fail("somehow retrieved a variable defined in a private scope");
  }

}
