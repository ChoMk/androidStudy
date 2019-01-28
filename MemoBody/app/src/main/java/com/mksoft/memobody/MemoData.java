package com.mksoft.memobody;

public class MemoData {
    private String registDateTextView;
    private String memoText;
    private String endDateTextView;



    public MemoData(String registDateTextView, String memoText, String endDateTextView) {
        this.registDateTextView = registDateTextView;
        this.memoText = memoText;
        this.endDateTextView = endDateTextView;
    }

    public String getRegistDateTextView() {
        return registDateTextView;
    }

    public String getMemoText() {
        return memoText;
    }

    public String getEndDateTextView() {
        return endDateTextView;
    }

    public void setRegistDateTextView(String registDateTextView) {
        this.registDateTextView = registDateTextView;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }

    public void setEndDateTextView(String endDateTextView) {
        this.endDateTextView = endDateTextView;
    }

    @Override
    public String toString() {
        return "MemoData{" +
                "registDateTextView='" + registDateTextView + '\'' +
                ", memoText='" + memoText + '\'' +
                ", endDateTextView='" + endDateTextView + '\'' +
                '}';
    }
}
