package operationtree;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario dell
 */
public abstract class SimpleOperator implements Operator{
    private final static int priority = 0;
    @Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
}
