package com.example.merge.mergetuples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of couple values, merge them.
 * 
 * For example, given [(2, 6), (1, 3), (7, 10), (8, 11), (4, 5)] the output should be [(1, 6), (7, 11)].
 * 
 * @author meghneel.gore
 *
 */
public class MergeTuples {

	public static void main(String[] args) {
		List<Tuple> tupleList = new ArrayList<>();

		tupleList.add(new Tuple(2, 6));
		tupleList.add(new Tuple(1, 3));
		tupleList.add(new Tuple(-100, 100));
		tupleList.add(new Tuple(4, 5));
		tupleList.add(new Tuple(8, 11));
		tupleList.add(new Tuple(7, 10));

		MergeTuples m = new MergeTuples();
		tupleList = m.merge(tupleList);
		for(Tuple t: tupleList) {
			System.out.print(t.toString() + ", ");
		}
	}

	int outputListPointer = 0;
	int inputListPointer = 0;
	
	public List<Tuple> merge(List<Tuple> list) {
		Collections.sort(list);
		List<Tuple> outputList = new ArrayList<>();

		outputList.add(list.remove(0));
		

		while(list.size() > 0) {
			Tuple o = list.remove(inputListPointer);
			int inX = o.x;
			int inY = o.y;

			Tuple t = outputList.get(outputListPointer);
			int outX = t.x;
			int outY = t.y;

			int tupleX, tupleY;

			if(outY < inX) {
				//Add tuple
				tupleX = inX;
				tupleY = inY;
				outputList.add(new Tuple(tupleX, tupleY));
				outputListPointer++;
				continue;
			} else if(inX < outX && inY > outX && inY < outY) {
				//remove present out and add tuple
				tupleX = inX;
				tupleY = outY;
				outputList.remove(outputListPointer);
				outputList.add(new Tuple(tupleX, tupleY));
				continue;
			} else if(inX > outX && inY < outY) {
				//ignore this one

			} else if(inX > outX && inY > outY) {
				tupleX = outX;
				tupleY = inY;
				outputList.remove(outputListPointer);
				outputList.add(new Tuple(tupleX, tupleY));
				continue;
			}
			else if(inX > outY) {
				//Add tuple
				tupleX = inX;
				tupleY = inY;
				outputList.remove(outputListPointer);
				outputList.add(new Tuple(tupleX, tupleY));
				continue;
			}
		}


		return outputList;


	}
	
}
