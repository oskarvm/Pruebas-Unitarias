package ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void put() {
        ex2.HashTable ht = new ex2.HashTable();
        ht.put("put1","1put");
        ht.put("put2","2put");
        ht.put("2","3put");
        ht.put("02","4put");
        ht.put("put1","5put");
        ht.put("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","6put"); //java.lang.ArrayIndexOutOfBoundsException: Index -15 out of bounds for length 16

        ht.count();
        ht.size();
        ht.toString();
        Assertions.assertEquals(5,ht.count());
        Assertions.assertEquals(16,ht.size());
        Assertions.assertEquals("\n bucket[2] = [put1, 1put] -> [2, 3put] -> [02, 4put]" +
                                        "\n bucket[3] = [put2, 2put]",ht.toString());
    }

    @Test
    void get() {

        ex2.HashTable ht = new ex2.HashTable();
        ht.put("put1","1put");
        ht.put("put2","2put");
        ht.put("2","3put");
        ht.put("02","4put");

        String sinColision = ht.get("put2");
        String conColisionInicio = ht.get("put1");
        String conColisionCentro = ht.get("2");
        String conColisionFinal = ht.get("02");
        String noExiste = ht.get("put3");

        Assertions.assertEquals("2put",sinColision);
        Assertions.assertEquals("1put", conColisionInicio);
        Assertions.assertEquals("3put", conColisionCentro);
        Assertions.assertEquals("4put", conColisionFinal);
        Assertions.assertEquals(null, noExiste);

        ht.count();
        ht.size();
        ht.toString();
        Assertions.assertEquals(4,ht.count());
        Assertions.assertEquals(16,ht.size());
        Assertions.assertEquals("\n bucket[2] = [put1, 1put] -> [2, 3put] -> [02, 4put]" +
                                        "\n bucket[3] = [put2, 2put]",ht.toString());
    }

    @Test
    void drop() {
        HashTable ht = new HashTable();

        ht.put("put1","1put"); ht.put("2","5put"); ht.put("02","6put");
        ht.put("put2","2put"); ht.put("3","7put"); ht.put("03","8put");
        ht.put("put3","3put"); ht.put("4","9put"); ht.put("04","10put");
        ht.put("put4","4put");

        ht.drop("put1");
        ht.drop("3");
        ht.drop("04");
        ht.drop("put4");

        ht.drop("noExiste");

        ht.count();
        ht.size();
        ht.toString();
        Assertions.assertEquals(6,ht.count());
        Assertions.assertEquals(16,ht.size());
        Assertions.assertEquals("\n bucket[2] = [2, 5put] -> [02, 6put]" +
                                        "\n bucket[3] = [put2, 2put] -> [03, 8put]" +
                                        "\n bucket[4] = [put3, 3put] -> [4, 9put]",ht.toString());
    }

}