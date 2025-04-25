import java.util.Arrays;

public class Hash_Table{
    static final int KEY_SIZE = 10;
    static final int TABLE_SIZE = 137;
    
    static class element{
        String key;
        int score;

        element() {
            this.key = "";
            this.score = 0;
        }
    }

    element[] hash_table = new element[TABLE_SIZE];

    Hash_Table(){
        init_table();
    }

    void init_table()
    {
        Arrays.fill(hash_table, new element()); // 테이블 초기화
    }

    int transform1(String key)
    {
        int number = 0;
        for (char c : key.toCharArray()) {
            number += c;
        }
        return number;
    }
    int hash_function(String key)
    {
        return transform1(key) % TABLE_SIZE;
    }

    boolean isEmpty(element item) {
        return item.key.length() == 0;
    }

    boolean isEqual(String key, element item2) {
        return key.equals(item2.key);
    }
    
    void hash_lp_add(element item){
        int i, hash_value;
        hash_value = i = hash_function(item.key);
        while (!isEmpty(hash_table[i])) {
            if (isEqual(item.key, hash_table[i])) {
                System.err.println("탐색키가 중복되었습니다\n");
                return;
            }
            i = (i + 1) % TABLE_SIZE;
            if (i == hash_value) {
                System.err.println("테이블이 가득찼습니다");
                return;
            }
        }
        hash_table[i] = item;
    }

    String hash_lp_search(String key){
        int i, hash_value;
        hash_value = i = hash_function(key);
        while (!isEmpty(hash_table[i]))
        {
            if (isEqual(key, hash_table[i])) {
                return "검색 된 값 -> " + hash_table[i].key;
            }
            i = (i + 1) % TABLE_SIZE;
            if (i == hash_value) {
                return null;
            }
        }
        return null;
    }

    String hash_lp_delete(String key){
        int i, hash_value;
        hash_value = i = hash_function(key);
        while (!isEmpty(hash_table[i]))
        {
            if (isEqual(key, hash_table[i])) {
                String rst = "삭제 될 값 -> " + hash_table[i].key;
                hash_table[i].key = "";
                hash_table[i].score = 0;
                return rst;
            }
            i = (i + 1) % TABLE_SIZE;
            if (i == hash_value) {
                return null;
            }
        }
        return null;
    }

    void hash_lp_print(){
        int i;
        System.out.println("===============================");
        for (i = 0; i<TABLE_SIZE; i++){
            System.out.printf("[%d]	%s\n", i, hash_table[i].key);
        }
        System.out.println("===============================");
    }


    public static void main(String[] args) {
        Hash_Table ht = new Hash_Table();

        String s[] = {"kor", "eng", "math", "science", "society"};

	    int data[] = { 
		95, 78, 23, 89, 23,
		79, 100, 24, 88, 99,
		24, 82, 21, 79, 23,
		77, 33, 87, 35, 67,
		80, 78, 86, 54, 23,
		100, 68, 87, 24, 88,
		57, 98, 54, 89, 19,
		33, 12, 84, 12, 90,
		98, 87, 88, 99, 30,
		35, 55, 54, 24, 54,
		28, 85, 100, 80, 86
	    };

	    String name[] = {
		"kim",
		"lee",
		"kang",
		"park",
		"choi",
		"cheon",
		"ma",
		"woo",
		"hong",
		"hwang",
		"han"
	    };

        for (int i = 0; i < 5; i++) {
            for(int j = 1; j <= 11; j++){
                element e = new element();
                e.key = name[j-1] + s[i];
                e.score = data[(j-1)*5 + i];
                System.out.printf("%d %s\n", e.score, e.key);  
                ht.hash_lp_add(e);
            }
        }

        ht.hash_lp_print();
        System.out.println(ht.hash_lp_search("hwangmath"));
        System.out.println(ht.hash_lp_delete("hwangmath"));
        ht.hash_lp_print();
    }
}