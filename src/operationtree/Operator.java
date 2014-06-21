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
public interface Operator {
    
    public SimpleOperator resolve();
    public int getPriority();
}
