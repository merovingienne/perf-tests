/**
 *
 * @author chanuka
 */
public class Stringer {

    public static void main(String[] args) {
                
        long builder_total = 0;

        long buffer_total = 0;

        final String a = "a";

        // Warm-up
        for (int j = 0; j < 1200; j++) {
            StringBuilder s = new StringBuilder(10000);
            StringBuffer r = new StringBuffer(10000);
            
            for (int i = 0; i < 10000; i++) {
                s.append(a);
            }
            
            for (int i = 0; i < 10000; i++) {
                r.append(a);
            }
        }

        
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
        System.out.println(builder_total/(rounds*1000) + "\t " + buffer_total/(rounds*1000) + "\n");

    }

}
