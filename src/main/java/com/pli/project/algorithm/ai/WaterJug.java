package com.pli.project.algorithm.ai;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by lipeng on 2015/5/23.
 */
public class WaterJug {

    public static void waterJug(int a, int b, int target){
        /** Eliminate unproper input. */
        if(a <= 0 || b <= 0 || target > b){
            System.out.println("no solution for " + a + ", " + b + ", " + target);
            return;
        }
        BigInteger bigA = new BigInteger(String.valueOf(a));
        BigInteger bigB = new BigInteger(String.valueOf(b));
        int gcd = bigA.gcd(bigB).intValue();
        if(target % gcd != 0){
            System.out.println("no solution for " + a + ", " + b + ", " + target);
            return;
        }
        if(a > b){
            System.out.println("b is supposed to greater than a.");
            return;
        }
        HashSet<WjState> stateSpace = new HashSet<WjState>();   //stores all the states.
        WjState firstState = new WjState(0, 0);
        Stack<WjState> stateStack = new Stack<WjState>();
        stateStack.add(firstState);
        WjState curState = firstState;
        /** DFS to find target result. Result is not guaranteed to be optimized **/
        while(stateStack.size() > 0 && curState.x != target && curState.y != target){
            curState = stateStack.peek();
            WjState nextState = new WjState(0, 0, curState.step + 1, curState);
            if(curState.x < a && !stateSpace.contains(nextState.setPos(a, curState.y))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.y < b && !stateSpace.contains(nextState.setPos(curState.x, b))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.x > 0 && !stateSpace.contains(nextState.setPos(0, curState.y))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.y > 0 && !stateSpace.contains(nextState.setPos(curState.x, 0))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.x + curState.y > a && !stateSpace.contains(nextState.setPos(a, curState.y - a + curState.x))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.x + curState.y > b && !stateSpace.contains(nextState.setPos(curState.x - b + curState.y, b))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.x + curState.y <=a && !stateSpace.contains(nextState.setPos(curState.x + curState.y, 0))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else if(curState.x + curState.y <=b && !stateSpace.contains(nextState.setPos(0, curState.x + curState.y))){
                stateSpace.add(nextState);
                stateStack.add(nextState);
            }
            else{
                stateStack.pop();
            }
        }// while
        /** Output result */
        StringBuffer output = new StringBuffer();
        while(curState != null){
            output.insert(0, " -> " + curState);
            curState = curState.pre;
        }
        output.delete(0, 4);
        System.out.println(output);
    }


    public static class WjState{
        int x, y;
        int step;   //How many steps is needed in order to reach the state
        WjState pre;    //to define the state before it.

        public boolean posEquals(WjState state){
            if(this.x==state.x&&this.y==state.y){
                return true;
            }
            return false;
        }

        public WjState(int x, int y){
            this.x = x;
            this.y = y;
        }

        public WjState(int x, int y, int step, WjState pre){
            this.x = x;
            this.y = y;
            this.step = step;
            this.pre = pre;
        }

        public WjState setPos(int x, int y){
            this.x = x;
            this.y = y;
            return this;
        }

        public int hashCode() {
            int hash = 1 ;
            hash = hash * 31 + x;
            hash = hash * 31 + y;
            return hash;
        }

        public String toString(){
            return "(" + this.x + ", " + this.y + ")";
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WjState wjState = (WjState) o;
            if (x != wjState.x) return false;
            return y == wjState.y;
        }
    }

    public static void main(String[] args) {
        waterJug(3, 5, 4);
    }
}
