package com.pli.project.lambda;

/**
 * Created by lipeng on 2016/6/10.
 */
public class Basic {

    public static void main(String[] args) {
        simpleWay();
        lambdaWay();
    }

    public static void simpleWay() {
        Math add = new Math() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        Math sub = new Math() {
            public int operate(int a, int b) {
                return a - b;
            }
        };
        System.out.println(MathOperation(1, 2, add));
        System.out.println(MathOperation(1, 2, sub));
    }

    public static void lambdaWay() {
        Math add = (int a, int b) -> a + b;
        Math sub = (int a, int b) -> {
            return a - b;
        };
        System.out.println(MathOperation(1, 2, add));
        System.out.println(MathOperation(1, 2, sub));
    }

    /**
     * MathOperation and Math are the core for defining lambda expression.
     * An operation interface and a function which uses interface.do() to return something.
     */

    public static int MathOperation (int a, int b, Math math) {
        return math.operate(a, b);
    }

    interface Math {
        public int operate(int a, int b);
    }

}
