/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chanuka
 */
public class Stringer {

    public static void main(String[] args) {
                
        long builder_total = 0;

        long buffer_total = 0;

        final String a = "a";
        final int rounds = Integer.decode(args[0]);

        for (int j = 0; j < rounds; j++) {
            StringBuilder s = new StringBuilder(1000000);
            StringBuffer r = new StringBuffer(1000000);
            
            long startBuilder = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                s.append(a);
            }
            long endBuilder = System.nanoTime();
            
            builder_total += (endBuilder-startBuilder);

            long startBuffer = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                r.append(a);
            }
            long endBuffer = System.nanoTime();
            buffer_total += (endBuffer - startBuffer);
        }
        
        System.out.println("Builder" + "\t| Buffer");
        System.out.println(builder_total/rounds + "\t " + buffer_total/rounds + "\n");

    }

}
