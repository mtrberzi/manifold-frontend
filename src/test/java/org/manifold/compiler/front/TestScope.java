package org.manifold.compiler.front;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.manifold.compiler.BooleanTypeValue;
import org.manifold.compiler.BooleanValue;

import com.google.common.collect.ImmutableSet;

public class TestScope {

  /*
   * Most of these tests depend on the correct operation of Variable. Look to
   * those tests if errors show up.
   */

  /*
  @Test
  public void testGetParentScope() {
    Scope foo = new Scope(null);
    Scope bar = new Scope(foo);
    assertSame(foo, bar.getParentScope());
  }

  private NamespaceIdentifier getNamespaceIdentifier() {
    return new NamespaceIdentifier("manifold:is:cool");
  }

  private VariableIdentifier getVariableIdentifier() {
    VariableIdentifier id = new VariableIdentifier(
        getNamespaceIdentifier(),
        "foo"
    );

    return id;
  }

  private Expression getTypeExpression() {
    return new LiteralExpression(BooleanTypeValue.getInstance());
  }

  // TODO(lucas) return an instance of the type
  private Expression getValueExpression() {
    return new LiteralExpression(BooleanValue.getInstance(true));
  }

  @Test
  public void testDefineVariable() throws MultipleDefinitionException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
  }

  @Test(expected = MultipleDefinitionException.class)
  public void testDefineVariableMultiple() throws MultipleDefinitionException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    s.defineVariable(getVariableIdentifier());
  }

  @Test
  public void testIsVariableDefined_true() throws MultipleDefinitionException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    assertTrue(s.isVariableDefined(getVariableIdentifier()));
  }

  @Test
  public void testIsVariableDefined_false() {
    Scope s = new Scope();
    assertFalse(s.isVariableDefined(getVariableIdentifier()));
  }

  
  @Test
  public void testGetVariableType() throws MultipleDefinitionException,
      TypeMismatchException, VariableNotDefinedException {

    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    assertEquals(getTypeExpression().getValue(s),
        s.getVariableType(getVariableIdentifier()));
  }
  

  @Test(expected = VariableNotDefinedException.class)
  public void testGetVariableNotDefined() throws VariableNotDefinedException {
    Scope s = new Scope();
    s.getVariable(getVariableIdentifier());
  }

  @Test
  public void testGetVariable() throws MultipleDefinitionException,
      VariableNotDefinedException, TypeMismatchException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    Variable v = s.getVariable(getVariableIdentifier());

    assertEquals(v.getIdentifier(), getVariableIdentifier());
    //assertEquals(v.getType(), getTypeExpression().getValue(s));
  }

  @Test
  public void testGetVariable_ParentScope() throws MultipleDefinitionException {
    Scope s1 = new Scope();
    Scope s2 = new Scope(s1);
    s1.defineVariable(getVariableIdentifier());
    try {
      Variable v = s2.getVariable(getVariableIdentifier());
      assertTrue(s2.isVariableDefined(getVariableIdentifier()));
    } catch (VariableNotDefinedException vnde) {
      fail("could not get a variable defined in a parent scope");
    }
  }

  @Test
  public void testGetVariableValue() throws MultipleDefinitionException,
      VariableNotDefinedException, MultipleAssignmentException,
      VariableNotAssignedException {

    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    s.assignVariable(getVariableIdentifier(), getValueExpression());

    assertEquals(getValueExpression().getValue(s),
        s.getVariableValue(getVariableIdentifier()));
  }

  @Test
  public void testGetSymbolIdentifiers() throws MultipleDefinitionException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    assertEquals(ImmutableSet.of(getVariableIdentifier()),
        s.getSymbolIdentifiers());
  }

  @Test(expected = VariableNotDefinedException.class)
  public void testAssignVariableNotDefined()
      throws VariableNotDefinedException, MultipleAssignmentException {
    Scope s = new Scope();
    s.assignVariable(getVariableIdentifier(), getValueExpression());
  }

  @Test
  public void testAssignVariable() throws MultipleDefinitionException,
      VariableNotDefinedException, MultipleAssignmentException,
      VariableNotAssignedException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    s.assignVariable(getVariableIdentifier(), getValueExpression());
    assertEquals(s.getVariableValue(getVariableIdentifier()),
        getValueExpression().getValue(s));
  }

  @Test(expected = MultipleAssignmentException.class)
  public void testAssignVariableMultiple() throws MultipleDefinitionException,
      VariableNotDefinedException, MultipleAssignmentException {
    Scope s = new Scope();
    s.defineVariable(getVariableIdentifier());
    s.assignVariable(getVariableIdentifier(), getValueExpression());
    s.assignVariable(getVariableIdentifier(), getValueExpression());
  }

  */
}
