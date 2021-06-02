package chab.dog.dogoapp.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import chab.dog.dogoapp.interfaces.IComunicaFragement;

public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener callback;

    public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }

    public interface OnHeadlineSelectedListener {
        public void onItemMenuSelected(int position);
    }

}
