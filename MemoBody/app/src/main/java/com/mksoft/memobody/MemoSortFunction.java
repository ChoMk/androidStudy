package com.mksoft.memobody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MemoSortFunction {
    public MemoSortFunction() {
    }
    public ArrayList<MemoData> registDateSort(ArrayList<MemoData> inputData){
        Collections.sort(inputData, new Comparator<MemoData>() {
            @Override
            public int compare(MemoData b1, MemoData b2) {
                return b1.getRegistDateTextView().compareTo(b2.getRegistDateTextView());
            }
        });


        return inputData;
    }
    public ArrayList<MemoData> endDateSort(ArrayList<MemoData> inputData){

        Collections.sort(inputData, new Comparator<MemoData>() {
            @Override
            public int compare(MemoData b1, MemoData b2) {
                return b1.getEndDateTextView().compareTo(b2.getEndDateTextView());
            }
        });
        return inputData;
    }

}
