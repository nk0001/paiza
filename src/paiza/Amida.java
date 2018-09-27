package paiza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Amida {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String term = sc.nextLine();
        String[] str = term.split(" ");
        int l = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);

        Node[] node = new Node[n];
        for(int i = 0; i < n; i++) {
        	node[i] = new Node();
        }

        for(int i = 0; i < m; i++) {
        	String tmp = sc.nextLine();
            String[] temp = tmp.split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            int c = Integer.parseInt(temp[2]);

            node[a-1].put(b, c, 1);
            node[a].put(c, b, 0);
        }

        for(int i = 0; i < n; i++) {
        	node[i].sort();
        }

        int posX = 0;
        int posY = l + 1;
        while(true) {
//        	Stream <Integer[]>stream = node[posX].getStream();
//        	Optional<Integer[]> opt = stream.filter(s -> s[0] < posY).min((x, y) -> x[0].compareTo(y[0]));
//        	Integer[] pos = opt.orElse(null);
        	Integer[] pos = node[posX].getStream(posY);
        	if(pos == null) {
        		break;
        	}
        	if(pos[2] == 0) {
        		posX -= 1;
        	}else {
        		posX += 1;
        	}
        	posY = pos[1];
        }
        System.out.println(posX + 1);
        sc.close();
    }
}

class Node {
	List<Integer[]> list;

	Node(){
		list = new ArrayList<Integer[]>();
	}

	void put(int str, int end, int pos) {
		Integer[] set = {str, end, pos};
		list.add(set);
	}

	void sort() {
		Collections.sort(list, (set1, set2) -> Integer.compare(set1[0], set2[0]));
	}

	Integer[] getStream(int posY) {
		Stream<Integer[]> stream = list.stream();
		Optional<Integer[]> opt = stream.filter(s -> s[0] < posY).max((x, y) -> x[0].compareTo(y[0]));
    	Integer[] pos = opt.orElse(null);
//		return list.stream();
    	return pos;

	}
}
