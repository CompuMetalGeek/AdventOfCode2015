/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses.Day07;

import java.util.Map;

/**
 *
 * @author jarno
 */
public abstract class BitwiseOp {
    protected String input;
    protected String input2;
    protected String output;
    
    public void setInput(String input){
        this.input=input;
    }
    public void setInput2(String input2){
        this.input2=input2;
    }
    public void setOutput(String output){
        this.output=output;
    }

    public String getInput() {
        return input;
    }

    public String getInput2() {
        return input2;
    }

    public String getOutput() {
        return output;
    }
    
    public abstract Character getOutput(Map<String,Character> values);
    
}
